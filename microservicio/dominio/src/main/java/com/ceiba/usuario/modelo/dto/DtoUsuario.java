package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private Long id; //NOSONAR
    private String nombre; //NOSONAR
    private String email; //NOSONAR
    private LocalDateTime fechaCreacion; //NOSONAR

}
