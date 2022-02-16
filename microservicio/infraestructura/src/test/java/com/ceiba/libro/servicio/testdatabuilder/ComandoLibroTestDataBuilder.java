package com.ceiba.libro.servicio.testdatabuilder;

import com.ceiba.libro.comando.ComandoLibro;

public class ComandoLibroTestDataBuilder {

    private Long id;
    private String titulo;
    private Long unidades;
    private Float precio;

    public ComandoLibroTestDataBuilder() {
        titulo = "El principito";
        unidades = Long.valueOf(5);
        precio = Float.valueOf(10000);
    }

    public ComandoLibroTestDataBuilder conUnidades(Long unidades) {
        this.unidades = unidades;
        return this;
    }


    public ComandoLibroTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoLibroTestDataBuilder conPrecio(Float precio) {
        this.precio = precio;
        return this;
    }

    public ComandoLibroTestDataBuilder conTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ComandoLibro build() {
        return new ComandoLibro(id,titulo, unidades,precio);
    }
}
