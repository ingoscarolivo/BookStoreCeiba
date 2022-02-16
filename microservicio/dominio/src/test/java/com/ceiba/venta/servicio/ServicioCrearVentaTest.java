package com.ceiba.venta.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.ServicioActualizarLibro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.venta.servicio.testdatabuilder.VentaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearVentaTest {

    private RepositorioVenta repositorioVenta = Mockito.mock(RepositorioVenta.class);;
    private RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
    private RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
    private ServicioActualizarLibro servicioActualizarLibro = Mockito.mock(ServicioActualizarLibro.class);

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del libro")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelLibro() {
        ServicioCrearVenta servicioCrearVenta =  spy(new ServicioCrearVenta(repositorioVenta, repositorioLibro, repositorioUsuario, servicioActualizarLibro));
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearVenta.validarExistenciaPreviaLibro(1L), ExcepcionValorInvalido.class,"El libro no existe en el sistema");
    }


    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide inventario del libro")
    void deberiaLanzarUnaExepcionCuandoSeValideInventarioDelLibro() {
        ServicioCrearVenta servicioCrearVenta =  spy(new ServicioCrearVenta(repositorioVenta, repositorioLibro, repositorioUsuario, servicioActualizarLibro));
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearVenta.validarInventarioLibro(-1L), ExcepcionValorInvalido.class,"No ha inventario del libro");
    }


    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        ServicioCrearVenta servicioCrearVenta =  spy(new ServicioCrearVenta(repositorioVenta, repositorioLibro, repositorioUsuario, servicioActualizarLibro));
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearVenta.validarExistenciaPreviaUsuario(1L), ExcepcionValorInvalido.class,"El usuario no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia retornar true si el precio del libro es menor o False si el precio del libro es mayor")
    void deberiaRetornarTrueSIPrecioLibroMenorOrFalseSiPrecioLibroMayor() {
        ServicioCrearVenta servicioCrearVenta =  spy(new ServicioCrearVenta(repositorioVenta, repositorioLibro, repositorioUsuario, servicioActualizarLibro));
        // act - assert
        assertEquals(servicioCrearVenta.precioLibroOferta(10000F), true);
        assertEquals(servicioCrearVenta.precioLibroOferta(30000F), false);
    }

    @Test
    @DisplayName("Deberia retornar true si aplica la condicion cantidad, hora 10PM a 8AM o False si no esta en el rango de la hora")
    void deberiaRetornarTrueSiCantidadRangoHoraOrFalseSiNotieneCantidadMinRangoHora() {
        ServicioCrearVenta servicioCrearVenta =  spy(new ServicioCrearVenta(repositorioVenta, repositorioLibro, repositorioUsuario, servicioActualizarLibro));
        // act - assert
        LocalTime horaActualNoAplica=LocalTime.parse("18:00:00.000");
        LocalTime horaActualAplica=LocalTime.parse("23:00:00.000");
        LocalTime horaInicial=LocalTime.parse("22:00:00.000");
        LocalTime horaFinal=LocalTime.parse("08:00:00.000");
        assertEquals(servicioCrearVenta.aplicarOferta(2L,horaActualNoAplica, horaInicial, horaFinal), false);
        assertEquals(servicioCrearVenta.aplicarOferta(2L,horaActualAplica, horaInicial, horaFinal), true);
        assertEquals(servicioCrearVenta.aplicarOferta(3L,horaActualNoAplica, horaInicial, horaFinal), false);
        assertEquals(servicioCrearVenta.aplicarOferta(3L,horaActualAplica, horaInicial, horaFinal), true);
        assertEquals(servicioCrearVenta.aplicarOferta(1L,horaActualNoAplica, horaInicial, horaFinal), false);
        assertEquals(servicioCrearVenta.aplicarOferta(1L,horaActualAplica, horaInicial, horaFinal), false);
    }

    @Test
    @DisplayName("Deberia retornar true si aplica fecha oferta o False si no aplica la fecha oferta")
    void deberiaRetornarTrueFechaOfertaAplicaOrFalseSiNoAplicaFechaOferta() {
        ServicioCrearVenta servicioCrearVenta =  spy(new ServicioCrearVenta(repositorioVenta, repositorioLibro, repositorioUsuario, servicioActualizarLibro));
        // act - assert
        LocalDateTime fecha=LocalDateTime.parse("2022-02-16T11:25");
        LocalDateTime fechaSabado=LocalDateTime.parse("2022-02-19T11:25");
        LocalDateTime fechaDomingo=LocalDateTime.parse("2022-02-20T11:25");
        assertEquals(servicioCrearVenta.validarDiasOferta(fecha), true);
        assertEquals(servicioCrearVenta.validarDiasOferta(fechaSabado), false);
        assertEquals(servicioCrearVenta.validarDiasOferta(fechaDomingo), false);
    }

    @Test
    @DisplayName("Deberia Crear venta de manera correcta")
    void deberiaCrearVentaDeManeraCorrecta() {
        // arrange
        Venta venta = new VentaTestDataBuilder().build();
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
