package com.ceiba.libro.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoLibro {
    private Long id;
    private String titulo;
    private Long unidades;
    private Float precio;

}
