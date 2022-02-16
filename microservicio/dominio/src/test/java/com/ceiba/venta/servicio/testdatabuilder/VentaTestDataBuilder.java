package com.ceiba.venta.servicio.testdatabuilder;

import com.ceiba.venta.modelo.entidad.Venta;

import java.time.LocalDateTime;

public class VentaTestDataBuilder {

    private Long id;
    private Long idLibro;
    private Long idUsuario;
    private Long unidadVenta;
    private Float precioUnidad;
    private Float precioVenta;
    private String detalleVenta;
    private LocalDateTime fechaVenta;


    public VentaTestDataBuilder() {
        idLibro = 1L;
        idUsuario = 1L;
        unidadVenta = 2L;
        precioUnidad = 10000F;
        precioVenta = 50000F;
        detalleVenta = "venta con descuento";;
        fechaVenta = LocalDateTime.now();
    }

    public VentaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public VentaTestDataBuilder conIdLibro(Long idLibro) {
        this.idLibro = idLibro;
        return this;
    }

    public VentaTestDataBuilder conUnidadVenta(Long unidadVenta) {
        this.unidadVenta = unidadVenta;
        return this;
    }

    public VentaTestDataBuilder conPrecioUnidad(Float precioUnidad) {
        this.precioUnidad = precioUnidad;
        return this;
    }

    public VentaTestDataBuilder conPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
        return this;
    }

    public VentaTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public VentaTestDataBuilder conDetalleVenta(String detalleVenta) {
        this.detalleVenta = detalleVenta;
        return this;
    }

    public VentaTestDataBuilder conFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
        return this;
    }


    public Venta build() {
        return new Venta(id,idLibro, idUsuario,unidadVenta,precioUnidad,precioVenta,detalleVenta, fechaVenta);
    }
}
