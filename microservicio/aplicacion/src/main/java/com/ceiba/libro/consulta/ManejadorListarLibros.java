package com.ceiba.libro.consulta;

import java.util.List;

import com.ceiba.libro.modelo.dto.DtoLibro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarLibros {

    private final DaoLibro daoLibro;

    public ManejadorListarLibros(DaoLibro daoLibro){
        this.daoLibro = daoLibro;
    }

    public List<DtoLibro> ejecutar(){ return this.daoLibro.listarLibro(); }
}
