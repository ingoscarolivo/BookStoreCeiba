package com.ceiba.libro.puerto.dao;

import com.ceiba.libro.modelo.dto.DtoLibro;

import java.util.List;

public interface DaoLibro {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoLibro> listarLibro();
}
