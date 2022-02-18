package com.ceiba.libro.puerto.dao;

import com.ceiba.libro.modelo.dto.DtoLibro;
import com.ceiba.libro.modelo.entidad.Libro;

import java.util.List;

public interface DaoLibro {

    /**
     * Permite listar libros
     * @return los libros
     */
    List<DtoLibro> listar();

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


    /**
     * Obtener precio por idLibro
     * @return precio
     */
    float obtenerPrecioLibroPorId(Long id);


    /**
     * Obtener precio por idLibro
     * @return libro
     */
    Libro obtenerLibroPorId(Long id);
}
