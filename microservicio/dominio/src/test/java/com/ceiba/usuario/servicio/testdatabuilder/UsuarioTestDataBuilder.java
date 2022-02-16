package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
    private String email;
    private LocalDateTime fechaCreacion;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        email = "test@gmail.com";
        fechaCreacion = LocalDateTime.now();
    }

    public UsuarioTestDataBuilder conEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombreUsuario, email,fechaCreacion);
    }
}
