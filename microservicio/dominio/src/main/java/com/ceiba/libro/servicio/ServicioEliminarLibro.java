package com.ceiba.libro.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;

public class ServicioEliminarLibro {

    private static final String EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA = "El libro no existe en el sistema";

    private final RepositorioLibro repositorioLibro;
    private final DaoLibro daoLibro;

    public ServicioEliminarLibro(RepositorioLibro repositorioLibro, DaoLibro daoLibro) {
        this.repositorioLibro = repositorioLibro;
        this.daoLibro = daoLibro;
    }

    public Integer ejecutar(Long id) {
        validarExistenciaPrevia(id);
       return this.repositorioLibro.eliminar(id);
    }


    public void validarExistenciaPrevia(Long id) {
        boolean existe = this.daoLibro.existePorId(id);
        if(!existe) {
            throw new ExcepcionSinDatos(EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
