package com.ceiba.venta.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoVenta {// NOSONAR
    private Long id; //NOSONAR
    private Long idLibro; //NOSONAR
    private Long idUsuario; //NOSONAR
    private Long unidadVenta; //NOSONAR
    private Float precioUnidad; //NOSONAR
    private Float precioVenta; //NOSONAR
    private String detalleVenta; //NOSONAR
    private LocalDateTime fechaVenta; //NOSONAR
}
