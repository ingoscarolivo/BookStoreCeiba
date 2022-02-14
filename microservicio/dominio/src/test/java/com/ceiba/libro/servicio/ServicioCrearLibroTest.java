package com.ceiba.libro.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearLibroTest {


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
    @DisplayName("Deberia Crear el libro de manera correcta")
    void deberiaCrearElLibroDeManeraCorrecta() {
        // arrange
        Libro libro = new LibroTestDataBuilder().build();
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioLibro.crear(libro)).thenReturn(10L);
        ServicioCrearLibro servicioCrearLibro = new ServicioCrearLibro(repositorioLibro);
        // act
        Long idLibro = servicioCrearLibro.ejecutar(libro);
        //- assert
        assertEquals(10L,idLibro);
        Mockito.verify(repositorioLibro, Mockito.times(1)).crear(libro);
    }
}
