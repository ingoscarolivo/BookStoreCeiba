package com.ceiba.libro.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.venta.servicio.ServicioCrearVenta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class ServicioEliminarLibroTest {

    RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
    DaoLibro daoLibro = Mockito.mock(DaoLibro.class);

    @Test
    @DisplayName("Deberia eliminar el libro llamando al repositorio")
    void deberiaEliminarElLibroLlamandoAlRepositorio() {

        Mockito.when(daoLibro.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarLibro servicioEliminarLibro = new ServicioEliminarLibro(repositorioLibro, daoLibro);
        servicioEliminarLibro.ejecutar(1l);
        Mockito.verify(repositorioLibro, Mockito.times(1)).eliminar(1l);

    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia previa del libro")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaPreviaDelLibro() {
        // arrange
        ServicioEliminarLibro servicioEliminarLibro =  spy(new ServicioEliminarLibro(repositorioLibro, daoLibro));
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarLibro.validarExistenciaPrevia(1L), ExcepcionSinDatos.class,"El libro no existe en el sistema");
    }

}
