package com.ceiba.libro.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearLibroTest {

    RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
    DaoLibro daoLibro = Mockito.mock(DaoLibro.class);

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del libro")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelLibro() {
        // arrange
        Libro libro = new LibroTestDataBuilder().build();
        Mockito.when(daoLibro.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearLibro servicioCrearLibro = new ServicioCrearLibro(repositorioLibro, daoLibro);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearLibro.ejecutar(libro), ExcepcionDuplicidad.class,"El libro ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el libro de manera correcta")
    void deberiaCrearElLibroDeManeraCorrecta() {
        // arrange
        Libro libro = new LibroTestDataBuilder().build();
        Mockito.when(daoLibro.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioLibro.crear(libro)).thenReturn(10L);
        ServicioCrearLibro servicioCrearLibro = new ServicioCrearLibro(repositorioLibro, daoLibro);
        // act
        Long idLibro = servicioCrearLibro.ejecutar(libro);
        //- assert
        assertEquals(10L,idLibro);
        Mockito.verify(repositorioLibro, Mockito.times(1)).crear(libro);
    }
}
