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
