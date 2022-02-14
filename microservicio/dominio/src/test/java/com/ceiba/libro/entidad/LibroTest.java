package com.ceiba.libro.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibroTest {

    @Test
    @DisplayName("Deberia crear correctamente el libro")
    void deberiaCrearCorrectamenteElLibro() {
        //act
        Libro libro = new LibroTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, libro.getId());
        assertEquals("El principito", libro.getTitulo());
        assertEquals(5, libro.getUnidades());
        assertEquals(10000, libro.getPrecio());
    }

    @Test
    void deberiaFallarSinTitulo() {

        //Arrange
        LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().conTitulo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    libroTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del libro");
    }

    @Test
    void deberiaFallarSinCantidadLibros() {

        //Arrange
        LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().conUnidades(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    libroTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad de libros");
    }

    @Test
    void deberiaFallarSinPrecioLibro() {

        //Arrange
        LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().conPrecio(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    libroTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el precio del libro");
    }


}
