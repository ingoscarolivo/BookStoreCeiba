package com.ceiba.libro.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoLibro {
    private Long id; //NOSONAR
    private String titulo; //NOSONAR
    private Long unidades; //NOSONAR
    private Float precio; //NOSONAR

}
