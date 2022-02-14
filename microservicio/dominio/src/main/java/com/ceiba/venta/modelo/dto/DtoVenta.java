package com.ceiba.venta.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoVenta {
    private Long id;
    private Long idLibro;
    private Long idUsuario;
    private Long unidadVenta;
    private Float precioUnidad;
    private Float precioVenta;
    private LocalDateTime fechaVenta;
}
