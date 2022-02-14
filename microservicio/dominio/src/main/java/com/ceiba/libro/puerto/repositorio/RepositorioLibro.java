package com.ceiba.libro.puerto.repositorio;

import com.ceiba.libro.modelo.entidad.Libro;

public interface RepositorioLibro {
    /**
     * Permite crear un libro
     * @param libro
     * @return el id generado
     */
    Long crear(Libro libro);

    /**
     * Permite actualizar un libro
     * @param libro
     */
    void actualizar(Libro libro);

    /**
     * Permite eliminar un libro
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un libro con un nombre
     * @param titulo
     * @return si existe o no
     */
    boolean existe(String titulo);

    /**
     * Permite validar si existe un libro con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
