package com.ceiba.libro.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarLibro {

    private static final String EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA = "El libro no existe en el sistema";

    private final RepositorioLibro repositorioLibro;

    public ServicioActualizarLibro(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public void ejecutar(Libro libro) {
        validarExistenciaPrevia(libro);
        this.repositorioLibro.actualizar(libro);
    }

    private void validarExistenciaPrevia(Libro libro) {
        boolean existe = this.repositorioLibro.existePorId(libro.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
