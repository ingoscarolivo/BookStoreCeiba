package com.ceiba.venta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.ServicioCrearLibro;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;


public class ServicioCrearVenta {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en la venta";
    private static final String LA_LIBRO_YA_EXISTE_EN_EL_SISTEMA = "El libro ya existe en la venta";
    private static final String LA_VENTA_YA_EXISTE_EN_EL_SISTEMA = "La venta ya existe en el sistema";

    private final RepositorioVenta repositorioVenta;

    public ServicioCrearVenta(RepositorioVenta repositorioVenta) {
        this.repositorioVenta = repositorioVenta;
    }

    public Long ejecutar(Venta venta) {
        return this.repositorioVenta.crear(venta);
    }

    private void validarExistenciaPrevia(Venta venta) {
        boolean existe = this.repositorioVenta.existePorId(venta.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_LIBRO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

  /*  private void validarExistenciaPrevia(Libro libro) {
        boolean existe = this.repositorioLibro.existePorId(libro.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_LIBRO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarCantidadLibros(Libro libro) {
        boolean existe = this.repositorioUsuario.existePorId(libro.getUnidades());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarPrecioLibros(Libro libro) {
        boolean existe = this.repositorioUsuario.existePorId(libro.getUnidades());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPrevia(Usuario usuario) {
        boolean existe = this.repositorioUsuario.existePorId(usuario.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }*/

}
