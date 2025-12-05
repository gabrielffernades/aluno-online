package br.com.alunoonline.api.dtos;

import lombok.Data;
import java.util.List;

@Data
public class InteractiveQueryDto {
    private String table;
    private List<String> columns;
    private List<FilterDto> filters;
    private Integer limit;
}

