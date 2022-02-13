package com.ceiba.libro.puerto.repositorio;

import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioLibro {
    /**
     * Permite crear un usuario
     * @param libro
     * @return el id generado
     */
    Long crear(Libro libro);

    /**
     * Permite actualizar un usuario
     * @param libro
     */
    void actualizar(Libro libro);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param titulo
     * @return si existe o no
     */
    boolean existe(String titulo);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
