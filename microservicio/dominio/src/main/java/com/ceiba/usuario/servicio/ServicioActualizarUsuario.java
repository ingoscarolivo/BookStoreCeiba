package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarUsuario {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El no usuario existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;
    private final DaoUsuario daoUsuario;

    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario, DaoUsuario daoUsuario) {
        this.repositorioUsuario = repositorioUsuario;
        this.daoUsuario = daoUsuario;
    }

    public void ejecutar(Usuario usuario) {
        validarExistenciaPrevia(usuario);
        this.repositorioUsuario.actualizar(usuario);
    }

    private void validarExistenciaPrevia(Usuario usuario) {
        boolean existe = this.daoUsuario.existePorId(usuario.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
