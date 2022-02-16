package com.ceiba.libro.modelo.entidad;


import lombok.Getter;
import lombok.Setter;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Libro {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_LIBRO = "Se debe ingresar el nombre del libro";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD = "Se debe ingresar la cantidad de libros";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO = "Se debe ingresar el precio del libro";


    private Long id;
    private String titulo;
    private Long unidades;
    private Float precio;

    public Libro(Long id,String titulo, Long unidades,Float precio) {
        validarObligatorio(titulo, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_LIBRO);
        validarObligatorio(unidades, SE_DEBE_INGRESAR_LA_CANTIDAD);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO);

        this.id = id;
        this.titulo = titulo;
        this.unidades = unidades;
        this.precio = precio;
    }

}
