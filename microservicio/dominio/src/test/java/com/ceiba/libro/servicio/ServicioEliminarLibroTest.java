package com.ceiba.libro.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.venta.servicio.ServicioCrearVenta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.spy;

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

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia previa del libro")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaPreviaDelLibro() {
        // arrange
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        ServicioEliminarLibro servicioEliminarLibro =  spy(new ServicioEliminarLibro(repositorioLibro));
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarLibro.validarExistenciaPrevia(1L), ExcepcionSinDatos.class,"El libro no existe en el sistema");
    }

}
