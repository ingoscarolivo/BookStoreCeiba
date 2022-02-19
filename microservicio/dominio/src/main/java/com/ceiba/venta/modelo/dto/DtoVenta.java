package com.ceiba.venta.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoVenta {// NOSONAR
    private Long id; //NOSONAR
    private Long idLibro;
    private Long idUsuario;
    private Long unidadVenta;
    private Float precioUnidad;
    private Float precioVenta;
    private String detalleVenta;
    private LocalDateTime fechaVenta;
}
