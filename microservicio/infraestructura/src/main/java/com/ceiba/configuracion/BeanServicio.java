package com.ceiba.configuracion;

import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.ServicioActualizarLibro;
import com.ceiba.libro.servicio.ServicioCrearLibro;
import com.ceiba.libro.servicio.ServicioEliminarLibro;
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
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearLibro servicioCrearLibro(RepositorioLibro repositorioLibro) {
        return new ServicioCrearLibro(repositorioLibro);
    }

    @Bean
    public ServicioEliminarLibro servicioEliminarLibro(RepositorioLibro repositorioLibro) {
        return new ServicioEliminarLibro(repositorioLibro);
    }

    @Bean
    public ServicioActualizarLibro servicioActualizarLibro(RepositorioLibro repositorioLibro) {
        return new ServicioActualizarLibro(repositorioLibro);
    }

    @Bean
    public ServicioCrearVenta servicioCrearVenta(RepositorioVenta repositorioVenta) {
        return new ServicioCrearVenta(repositorioVenta);
    }

}
