package com.ceiba.libro.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.libro.comando.ComandoLibro;
import com.ceiba.libro.comando.fabrica.FabricaLibro;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.servicio.ServicioCrearLibro;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearLibro implements ManejadorComandoRespuesta<ComandoLibro, ComandoRespuesta<Long>> {

    private final FabricaLibro fabricaLibro;
    private final ServicioCrearLibro servicioCrearLibro;

    public ManejadorCrearLibro(FabricaLibro fabricaLibro, ServicioCrearLibro servicioCrearLibro) {
        this.fabricaLibro = fabricaLibro;
        this.servicioCrearLibro = servicioCrearLibro;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoLibro comandoLibro) {
        Libro libro = this.fabricaLibro.crear(comandoLibro);
        return new ComandoRespuesta<>(this.servicioCrearLibro.ejecutar(libro));
    }
}
