package com.ceiba.libro.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoLibro {
    private Long id;
    private String titulo;
    private Long unidades;
    private Float precio;

}
