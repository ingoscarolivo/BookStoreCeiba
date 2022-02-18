package com.ceiba.libro.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;


public class ServicioCrearLibro {

    private static final String EL_LIBRO_YA_EXISTE_EN_EL_SISTEMA = "El libro ya existe en el sistema";

    private final RepositorioLibro repositorioLibro;
    private final DaoLibro daoLibro;

    public ServicioCrearLibro(RepositorioLibro repositorioLibro, DaoLibro daoLibro) {
        this.repositorioLibro = repositorioLibro;
        this.daoLibro = daoLibro;
    }

    public Long ejecutar(Libro libro) {
        validarExistenciaPrevia(libro);
        return this.repositorioLibro.crear(libro);
    }

    private void validarExistenciaPrevia(Libro libro) {
        boolean existe = this.daoLibro.existe(libro.getTitulo());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_LIBRO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
