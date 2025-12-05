package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.InteractiveQueryDto;
import br.com.alunoonline.api.service.InteractiveSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/interactive-search")
public class InteractiveSearchController {

    @Autowired
    private InteractiveSearchService interactiveSearchService;

    @GetMapping("/tables")
    public ResponseEntity<List<String>> getTables() {
        try {
            List<String> tables = interactiveSearchService.getAllowedTables();
            return ResponseEntity.ok(tables);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{table}/columns")
    public ResponseEntity<?> getColumns(@PathVariable String table) {
        try {
            List<String> columns = interactiveSearchService.getAllowedColumns(table);
            return ResponseEntity.ok(columns);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Erro ao buscar colunas"));
        }
    }

    @PostMapping("/query")
    public ResponseEntity<?> query(@RequestBody InteractiveQueryDto dto) {
        try {
            List<Map<String, Object>> rows = interactiveSearchService.query(dto);
            return ResponseEntity.ok(Map.of("rows", rows));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Erro ao executar query: " + e.getMessage()));
        }
    }

    @PostMapping("/export-csv")
    public ResponseEntity<?> exportCsv(@RequestBody InteractiveQueryDto dto) {
        try {
            byte[] csvBytes = interactiveSearchService.exportCsv(dto);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("text/csv"));
            headers.setContentDispositionFormData("attachment", 
                    "export_" + dto.getTable() + "_" + System.currentTimeMillis() + ".csv");
            
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(csvBytes);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Erro ao exportar CSV: " + e.getMessage()));
        }
    }
}

