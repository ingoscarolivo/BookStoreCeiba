package com.ceiba.libro.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;

public class ServicioActualizarLibro {

    private static final String EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA = "El libro no existe en el sistema";

    private final RepositorioLibro repositorioLibro;
    private final DaoLibro daoLibro;

    public ServicioActualizarLibro(RepositorioLibro repositorioLibro, DaoLibro daoLibro) {
        this.repositorioLibro = repositorioLibro;
        this.daoLibro = daoLibro;
    }

    public void ejecutar(Libro libro) {
        validarExistenciaPrevia(libro);
        this.repositorioLibro.actualizar(libro);
    }

    private void validarExistenciaPrevia(Libro libro) {
        boolean existe = this.daoLibro.existePorId(libro.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
