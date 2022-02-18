package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearUsuario {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;
    private final DaoUsuario daoUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario, DaoUsuario daoUsuario) {
        this.repositorioUsuario = repositorioUsuario;
        this.daoUsuario = daoUsuario;
    }

    public Long ejecutar(Usuario usuario) {
        validarExistenciaPrevia(usuario);
        return this.repositorioUsuario.crear(usuario);
    }

    private void validarExistenciaPrevia(Usuario usuario) {
        boolean existe = this.daoUsuario.existe(usuario.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
