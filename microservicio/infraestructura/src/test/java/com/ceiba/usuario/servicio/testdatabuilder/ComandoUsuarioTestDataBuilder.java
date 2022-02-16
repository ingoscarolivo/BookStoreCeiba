package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String email;
    private LocalDateTime fechaCreacion;

    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        email = "test@gmail.com";
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre, email,fechaCreacion);
    }
}
