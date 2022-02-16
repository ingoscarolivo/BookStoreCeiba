package com.ceiba.venta.puerto.repositorio;

import com.ceiba.venta.modelo.entidad.Venta;

public interface RepositorioVenta {
    /**
     * Permite crear una venta
     * @param venta
     * @return el id generado
     */
    Long crear(Venta venta);

    /**
     * Permite actualizar un venta
     * @param venta
     *//*
    void actualizar(Venta venta);

    *//**
     * Permite eliminar una venta
     * @param id
     *//*
    void eliminar(Long id);

    *//**
     * Permite validar si existe un usuario con un nombre
     * @param titulo
     * @return si existe o no
     */
    //boolean existe(String titulo);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
