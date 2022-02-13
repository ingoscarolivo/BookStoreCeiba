package com.ceiba.libro.comando.manejador;

import com.ceiba.libro.comando.ComandoLibro;
import com.ceiba.libro.comando.fabrica.FabricaLibro;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.servicio.ServicioActualizarLibro;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;

@Component
public class ManejadorActualizarLibro implements ManejadorComando<ComandoLibro> {

    private final FabricaLibro fabricaLibro;
    private final ServicioActualizarLibro servicioActualizarLibro;

    public ManejadorActualizarLibro(FabricaLibro fabricaLibro, ServicioActualizarLibro servicioActualizarLibro) {
        this.fabricaLibro = fabricaLibro;
        this.servicioActualizarLibro = servicioActualizarLibro;
    }

    public void ejecutar(ComandoLibro comandoLibro) {
        Libro libro = this.fabricaLibro.crear(comandoLibro);
        this.servicioActualizarLibro.ejecutar(libro);
    }
}
