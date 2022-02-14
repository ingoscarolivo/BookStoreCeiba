package com.ceiba.libro.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;


public class ServicioCrearLibro {

    private static final String EL_LIBRO_YA_EXISTE_EN_EL_SISTEMA = "El libro ya existe en el sistema";

    private final RepositorioLibro repositorioLibro;

    public ServicioCrearLibro(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public Long ejecutar(Libro libro) {
        validarExistenciaPrevia(libro);
        return this.repositorioLibro.crear(libro);
    }

    private void validarExistenciaPrevia(Libro libro) {
        boolean existe = this.repositorioLibro.existe(libro.getTitulo());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_LIBRO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
