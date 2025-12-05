package br.com.alunoonline.api.dtos;

import lombok.Data;

@Data
public class FilterDto {
    private String field;
    private String op; // contains, equals, gte, lte
    private String value;
}

