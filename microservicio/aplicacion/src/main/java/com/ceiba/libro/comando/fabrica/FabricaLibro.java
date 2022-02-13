package com.ceiba.libro.comando.fabrica;

import com.ceiba.libro.comando.ComandoLibro;
import com.ceiba.libro.modelo.entidad.Libro;
import org.springframework.stereotype.Component;

@Component
public class FabricaLibro {

    public Libro crear(ComandoLibro comandoLibro) {
        return new Libro(
                comandoLibro.getId(),
                comandoLibro.getTitulo(),
                comandoLibro.getUnidades(),
                comandoLibro.getPrecio()
        );
    }

}
