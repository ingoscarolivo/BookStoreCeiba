package com.ceiba.venta.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Venta {


    private static final String SE_DEBE_INGRESAR_EL_ID_LIBRO = "Se debe ingresar el id del libro a comprar";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO = "Se debe ingresar el id del usuario";
    private static final String SE_DEBE_INGRESAR_CANTIDAD_LIBROS = "Se debe ingresar la cantidad de libros a comprar";

    private Long id; //NOSONAR
    private Long idLibro; //NOSONAR
    private Long idUsuario; //NOSONAR
    private Long unidadVenta; //NOSONAR
    private Float precioUnidad; //NOSONAR
    private Float precioVenta; //NOSONAR
    private String detalleVenta; //NOSONAR
    private LocalDateTime fechaVenta; //NOSONAR

    public Venta(Long id, Long idLibro, Long idUsuario, Long unidadVenta, Float precioUnidad, Float precioVenta, String detalleVenta) {
        validarObligatorio(idLibro, SE_DEBE_INGRESAR_EL_ID_LIBRO);
        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO);
        validarObligatorio(unidadVenta, SE_DEBE_INGRESAR_CANTIDAD_LIBROS);

        this.id = id;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.unidadVenta = unidadVenta;
        this.precioUnidad = precioUnidad;
        this.precioVenta = precioVenta;
        this.detalleVenta = detalleVenta;
        this.fechaVenta = LocalDateTime.now();
    }

}
