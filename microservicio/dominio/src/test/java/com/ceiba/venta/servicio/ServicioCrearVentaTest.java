package com.ceiba.venta.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.ServicioActualizarLibro;
import com.ceiba.libro.servicio.ServicioCrearLibro;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.venta.servicio.testdatabuilder.VentaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

public class ServicioCrearVentaTest {


    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del libro")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelLibro() {
        // arrange
        Libro libro = new LibroTestDataBuilder().build();
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearLibro servicioCrearLibro = new ServicioCrearLibro(repositorioLibro);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearLibro.ejecutar(libro), ExcepcionDuplicidad.class,"El libro ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear venta de manera correcta")
    void deberiaCrearVentaDeManeraCorrecta() {
        // arrange
        Venta venta = new VentaTestDataBuilder().build();
        RepositorioVenta repositorioVenta = Mockito.mock(RepositorioVenta.class);
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        ServicioActualizarLibro servicioActualizarLibro = Mockito.mock(ServicioActualizarLibro.class);
        Mockito.when(repositorioUsuario.existePorId(1L)).thenReturn(true);
        Mockito.when(repositorioLibro.existePorId(1L)).thenReturn(true);
        Libro libro = new Libro(1L,"java",10L,25000F);
        Mockito.when(repositorioVenta.crear(venta)).thenReturn(1L);
        ServicioCrearVenta servicioCrearVenta =  spy(new ServicioCrearVenta(repositorioVenta, repositorioLibro, repositorioUsuario, servicioActualizarLibro));
        Mockito.when(repositorioLibro.obtenerLibroPorId(1L)).thenReturn(libro);
        // act
        Long idLibro = servicioCrearVenta.ejecutar(venta);
        //- assert
        assertEquals(1L,idLibro);
        Mockito.verify(repositorioVenta, Mockito.times(1)).crear(venta);
    }
}