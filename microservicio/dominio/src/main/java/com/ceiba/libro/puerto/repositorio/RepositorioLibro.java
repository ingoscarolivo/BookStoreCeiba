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
    Integer eliminar(Long id);

}
