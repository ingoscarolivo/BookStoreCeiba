package com.ceiba.usuario.modelo.entidad;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_UN_EMAIL = "Se debe ingresar un email";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String EL_EMAIL_NO_ES_VALIDO = "El email no es valido";
    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    private Long id;
    private String nombre;
    private String email;
    private LocalDateTime fechaCreacion;

    public Usuario(Long id,String nombre, String email,LocalDateTime fechaCreacion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(email, SE_DEBE_INGRESAR_UN_EMAIL);
        validarRegex(email, String.valueOf(pattern),EL_EMAIL_NO_ES_VALIDO);
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
    }

}
