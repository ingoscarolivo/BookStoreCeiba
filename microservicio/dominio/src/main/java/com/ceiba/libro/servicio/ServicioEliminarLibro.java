package com.ceiba.libro.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;

public class ServicioEliminarLibro {

    private static final String EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA = "El libro no existe en el sistema";

    private final RepositorioLibro repositorioLibro;

    public ServicioEliminarLibro(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioLibro.eliminar(id);
    }


    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioLibro.existePorId(id);
        if(!existe) {
            throw new ExcepcionSinDatos(EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
