package com.ceiba.venta.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.servicio.testdatabuilder.VentaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VentaTest {

    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteLaVenta() {
        // arrange
        LocalDateTime fechaVenta = LocalDateTime.now();
        //act
        Venta venta = new VentaTestDataBuilder().conFechaVenta(fechaVenta).conId(1L).build();
        //assert
        assertEquals(1, venta.getId());
        assertEquals(1, venta.getIdUsuario());
        assertEquals(1, venta.getIdLibro());
        assertEquals(2, venta.getUnidadVenta());
        assertEquals(10000, venta.getPrecioUnidad());
        assertEquals(50000, venta.getPrecioVenta());
        assertEquals("venta con descuento", venta.getDetalleVenta());
        assertEquals(fechaVenta.format(DateTimeFormatter.ofPattern("YYYY/MM/ddEHH:mm:ss")), venta.getFechaVenta().format(DateTimeFormatter.ofPattern("YYYY/MM/ddEHH:mm:ss")));
    }

    @Test
    void deberiaFallarSinIdDeUsuario() {

        //Arrange
        VentaTestDataBuilder ventaTestDataBuilder = new VentaTestDataBuilder().conIdUsuario(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    ventaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id del usuario");
    }

    @Test
    void deberiaFallarSinIdLibro() {

        //Arrange
        VentaTestDataBuilder ventaTestDataBuilder = new VentaTestDataBuilder().conIdLibro(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    ventaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id del libro a comprar");
    }

    @Test
    void deberiaFallarSinCantidadLibro() {

        //Arrange
        VentaTestDataBuilder ventaTestDataBuilder = new VentaTestDataBuilder().conUnidadVenta(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    ventaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad de libros a comprar");
    }

}
