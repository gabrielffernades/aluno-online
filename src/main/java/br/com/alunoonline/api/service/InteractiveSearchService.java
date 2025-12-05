package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.FilterDto;
import br.com.alunoonline.api.dtos.InteractiveQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InteractiveSearchService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final Set<String> ALLOWED_TABLES = Set.of("aluno", "professor", "disciplina");

    private static final Map<String, List<String>> ALLOWED_COLUMNS = Map.of(
            "aluno", Arrays.asList("id", "completName", "email", "cpf"),
            "professor", Arrays.asList("id", "nome", "email", "cpf"),
            "disciplina", Arrays.asList("id", "name", "professor_id")
    );

    private static final Set<String> ALLOWED_OPERATIONS = Set.of("contains", "equals", "gte", "lte");

    private static final int DEFAULT_LIMIT = 200;
    private static final int MAX_LIMIT = 1000;

    public List<String> getAllowedTables() {
        return new ArrayList<>(ALLOWED_TABLES);
    }

    public List<String> getAllowedColumns(String table) {
        if (!ALLOWED_TABLES.contains(table)) {
            throw new IllegalArgumentException("Tabela não permitida: " + table);
        }
        return new ArrayList<>(ALLOWED_COLUMNS.get(table));
    }

    public List<Map<String, Object>> query(InteractiveQueryDto dto) {
        validateQuery(dto);

        String sql = buildQuery(dto);
        MapSqlParameterSource params = buildParameters(dto);

        return jdbcTemplate.queryForList(sql, params);
    }

    public byte[] exportCsv(InteractiveQueryDto dto) {
        List<Map<String, Object>> rows = query(dto);
        return convertToCsv(rows, dto.getColumns());
    }

    private void validateQuery(InteractiveQueryDto dto) {
        if (dto.getTable() == null || !ALLOWED_TABLES.contains(dto.getTable())) {
            throw new IllegalArgumentException("Tabela inválida ou não permitida: " + dto.getTable());
        }

        if (dto.getColumns() == null || dto.getColumns().isEmpty()) {
            throw new IllegalArgumentException("Colunas não podem ser vazias");
        }

        List<String> allowedCols = ALLOWED_COLUMNS.get(dto.getTable());
        for (String col : dto.getColumns()) {
            if (!allowedCols.contains(col)) {
                throw new IllegalArgumentException("Coluna não permitida: " + col);
            }
        }

        if (dto.getFilters() != null) {
            for (FilterDto filter : dto.getFilters()) {
                if (!allowedCols.contains(filter.getField())) {
                    throw new IllegalArgumentException("Campo de filtro não permitido: " + filter.getField());
                }
                if (!ALLOWED_OPERATIONS.contains(filter.getOp())) {
                    throw new IllegalArgumentException("Operação não permitida: " + filter.getOp());
                }
            }
        }

        if (dto.getLimit() != null && dto.getLimit() > MAX_LIMIT) {
            throw new IllegalArgumentException("Limite máximo permitido é " + MAX_LIMIT);
        }
    }

    private String buildQuery(InteractiveQueryDto dto) {
        StringBuilder sql = new StringBuilder("SELECT ");

        // Colunas
        String columnsStr = String.join(", ", dto.getColumns());
        sql.append(columnsStr);

        // FROM
        sql.append(" FROM ").append(dto.getTable());

        // WHERE
        sql.append(" WHERE 1=1");

        // Filtros
        if (dto.getFilters() != null && !dto.getFilters().isEmpty()) {
            int paramIndex = 1;
            for (FilterDto filter : dto.getFilters()) {
                String paramName = "p" + paramIndex++;
                sql.append(" AND ").append(filter.getField());

                switch (filter.getOp()) {
                    case "contains":
                        sql.append(" ILIKE :").append(paramName);
                        break;
                    case "equals":
                        sql.append(" = :").append(paramName);
                        break;
                    case "gte":
                        sql.append(" >= :").append(paramName);
                        break;
                    case "lte":
                        sql.append(" <= :").append(paramName);
                        break;
                }
            }
        }

        // LIMIT
        sql.append(" LIMIT :limit");

        return sql.toString();
    }

    private MapSqlParameterSource buildParameters(InteractiveQueryDto dto) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        // Parâmetros dos filtros
        if (dto.getFilters() != null && !dto.getFilters().isEmpty()) {
            int paramIndex = 1;
            for (FilterDto filter : dto.getFilters()) {
                String paramName = "p" + paramIndex++;
                String value = filter.getValue();

                if ("contains".equals(filter.getOp())) {
                    // Para ILIKE, adicionar % antes e depois
                    params.addValue(paramName, "%" + value + "%");
                } else {
                    params.addValue(paramName, value);
                }
            }
        }

        // LIMIT
        int limit = (dto.getLimit() != null) ? dto.getLimit() : DEFAULT_LIMIT;
        params.addValue("limit", limit);

        return params;
    }

    private byte[] convertToCsv(List<Map<String, Object>> rows, List<String> columns) {
        StringBuilder csv = new StringBuilder();

        csv.append(String.join(",", columns)).append("\n");

        for (Map<String, Object> row : rows) {
            List<String> values = new ArrayList<>();
            for (String col : columns) {
                Object value = row.get(col);
                String strValue = (value != null) ? value.toString() : "";
                // Escapar vírgulas e aspas
                if (strValue.contains(",") || strValue.contains("\"") || strValue.contains("\n")) {
                    strValue = "\"" + strValue.replace("\"", "\"\"") + "\"";
                }
                values.add(strValue);
            }
            csv.append(String.join(",", values)).append("\n");
        }

        return csv.toString().getBytes();
    }
}

