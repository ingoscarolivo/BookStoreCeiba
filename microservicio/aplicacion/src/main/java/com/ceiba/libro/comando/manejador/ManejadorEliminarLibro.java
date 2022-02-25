package com.ceiba.libro.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.libro.comando.ComandoLibro;
import com.ceiba.libro.servicio.ServicioEliminarLibro;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarLibro  implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {

    private final ServicioEliminarLibro servicioEliminarLibro;

    public ManejadorEliminarLibro(ServicioEliminarLibro servicioEliminarLibro) {
        this.servicioEliminarLibro = servicioEliminarLibro;
    }

     @Override
    public ComandoRespuesta<Long> ejecutar(Long idLibro) {
        return new ComandoRespuesta<Long>(this.servicioEliminarLibro.ejecutar(idLibro).longValue());
    }
}
