package com.ceiba.libro.servicio.testdatabuilder;

import com.ceiba.libro.modelo.entidad.Libro;


public class LibroTestDataBuilder {

    private Long id;
    private String titulo;
    private Long unidades;
    private Float precio;

    public LibroTestDataBuilder() {
        titulo = "El principito";
        unidades = Long.valueOf(5);
        precio = Float.valueOf(10000);
    }

    public LibroTestDataBuilder conUnidades(Long unidades) {
        this.unidades = unidades;
        return this;
    }

    public LibroTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public LibroTestDataBuilder conPrecio(Float precio) {
        this.precio = precio;
        return this;
    }

    public LibroTestDataBuilder conTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Libro build() {
        return new Libro(id,titulo, unidades,precio);
    }
}
