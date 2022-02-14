package com.ceiba.libro.servicio;

import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarLibroTest {

    @Test
    @DisplayName("Deberia eliminar el libro llamando al repositorio")
    void deberiaEliminarElLibroLlamandoAlRepositorio() {
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarLibro servicioEliminarLibro = new ServicioEliminarLibro(repositorioLibro);

        servicioEliminarLibro.ejecutar(1l);

        Mockito.verify(repositorioLibro, Mockito.times(1)).eliminar(1l);

    }

}
