package com.ceiba.libro.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServicioActualizarLibroTest {

    RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
    DaoLibro daoLibro = Mockito.mock(DaoLibro.class);

    @Test
    @DisplayName("Deberia validar la existencia previa del libro")
    void deberiaValidarLaExistenciaPreviaDeLibro() {
        // arrange
        Libro libro = new LibroTestDataBuilder().conId(1L).build();
        Mockito.when(daoLibro.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarLibro servicioActualizarLibro = new ServicioActualizarLibro(repositorioLibro,  daoLibro);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarLibro.ejecutar(libro), ExcepcionDuplicidad.class,"El libro no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente el libro en el repositorio")
    void deberiaActualizarCorrectamenteLibroEnElRepositorio() {
        // arrange
        Libro libro = new LibroTestDataBuilder().conId(1L).build();
        Mockito.when(daoLibro.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarLibro servicioActualizarLibro = new ServicioActualizarLibro(repositorioLibro, daoLibro);
        // act
        servicioActualizarLibro.ejecutar(libro);
        //assert
        Mockito.verify(repositorioLibro,Mockito.times(1)).actualizar(libro);
    }
}
