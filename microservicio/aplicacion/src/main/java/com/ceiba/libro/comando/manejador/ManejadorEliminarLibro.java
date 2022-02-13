package com.ceiba.libro.comando.manejador;

import com.ceiba.libro.servicio.ServicioEliminarLibro;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarLibro implements ManejadorComando<Long> {

    private final ServicioEliminarLibro servicioEliminarLibro;

    public ManejadorEliminarLibro(ServicioEliminarLibro servicioEliminarLibro) {
        this.servicioEliminarLibro = servicioEliminarLibro;
    }

    public void ejecutar(Long idLibro) {
        this.servicioEliminarLibro.ejecutar(idLibro);
    }
}
