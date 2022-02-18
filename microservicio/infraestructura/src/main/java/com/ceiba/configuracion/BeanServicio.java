package com.ceiba.configuracion;

import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.ServicioActualizarLibro;
import com.ceiba.libro.servicio.ServicioCrearLibro;
import com.ceiba.libro.servicio.ServicioEliminarLibro;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.venta.servicio.ServicioCrearVenta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario, DaoUsuario daoUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario, daoUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario, DaoUsuario daoUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario, daoUsuario);
    }

    @Bean
    public ServicioCrearLibro servicioCrearLibro(RepositorioLibro repositorioLibro, DaoLibro daoLibro) {
        return new ServicioCrearLibro(repositorioLibro, daoLibro);
    }

    @Bean
    public ServicioEliminarLibro servicioEliminarLibro(RepositorioLibro repositorioLibro, DaoLibro daoLibro) {
        return new ServicioEliminarLibro(repositorioLibro, daoLibro);
    }

    @Bean
    public ServicioActualizarLibro servicioActualizarLibro(RepositorioLibro repositorioLibro, DaoLibro daoLibro) {
        return new ServicioActualizarLibro(repositorioLibro, daoLibro);
    }

    @Bean
    public ServicioCrearVenta servicioCrearVenta(RepositorioVenta repositorioVenta, RepositorioLibro repositorioLibro, RepositorioUsuario repositorioUsuario, ServicioActualizarLibro servicioActualizarLibro, DaoLibro daoLibro, DaoUsuario daoUsuario) {
        return new ServicioCrearVenta(repositorioVenta, repositorioLibro, repositorioUsuario, servicioActualizarLibro, daoLibro, daoUsuario);
    }

}
