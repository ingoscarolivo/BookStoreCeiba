package com.ceiba.venta.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Venta {


    private static final String SE_DEBE_INGRESAR_EL_ID_LIBRO = "Se debe ingresar el id del libro a comprar";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO = "Se debe ingresar el id del usuario";
    private static final String SE_DEBE_INGRESAR_CANTIDAD_LIBROS = "Se debe ingresar la cantidad de libros a comprar";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_VENTA = "Se debe ingresar la fecha de venta";

    private Long id;
    private Long idLibro;
    private Long idUsuario;
    private Long unidadVenta;
    private Float precioUnidad;
    private Float precioVenta;
    private LocalDateTime fechaVenta;

    public Venta(Long id, Long idLibro, Long idUsuario, Long unidadVenta, Float precioUnidad, Float precioVenta, LocalDateTime fechaVenta ) {
        validarObligatorio(idLibro, SE_DEBE_INGRESAR_EL_ID_LIBRO);
        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO);
        validarObligatorio(unidadVenta, SE_DEBE_INGRESAR_CANTIDAD_LIBROS);
        validarObligatorio(fechaVenta, SE_DEBE_INGRESAR_LA_FECHA_VENTA);

        this.id = id;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.unidadVenta = unidadVenta;
        this.precioUnidad = precioUnidad;
        this.precioVenta = precioVenta;
        this.fechaVenta = fechaVenta;
    }

}
