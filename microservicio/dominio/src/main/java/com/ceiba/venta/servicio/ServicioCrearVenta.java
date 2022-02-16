package com.ceiba.venta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.ServicioActualizarLibro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class ServicioCrearVenta {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";
    private static final String EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA = "El libro no existe en el sistema";
    private static final String NO_HAY_INVENTARIO_LIBRO = "No ha inventario del libro";

    private final RepositorioVenta repositorioVenta;
    private final RepositorioLibro respositorioLibro;
    private final RepositorioUsuario repositorioUsuario;
    private final ServicioActualizarLibro servicioActualizarLibro;

    public ServicioCrearVenta(RepositorioVenta repositorioVenta, RepositorioLibro respositorioLibro,RepositorioUsuario repositorioUsuario, ServicioActualizarLibro servicioActualizarLibro) {
        this.repositorioVenta = repositorioVenta;
        this.respositorioLibro = respositorioLibro;
        this.repositorioUsuario = repositorioUsuario;
        this.servicioActualizarLibro = servicioActualizarLibro;
    }



    public Long ejecutar(Venta venta) {
        validarExistenciaPreviaUsuario(venta.getIdUsuario());
        validarExistenciaPreviaLibro(venta.getIdLibro());
        float precio = obtenerPrecioLibroPorId(venta.getIdLibro());
        venta.setPrecioUnidad(precio);
        Libro libro = obtenerLibroPorId(venta.getIdLibro());
        Long unidadVenta =  venta.getUnidadVenta();
        Long unidadLibro = libro.getUnidades();
        Long totalLibro = unidadLibro - unidadVenta;
        validarInventarioLibro(totalLibro);

        LocalDateTime fechaVenta = LocalDateTime.now();
        LocalTime time = fechaVenta.toLocalTime();
        LocalTime horaInicialOferta = LocalTime.parse("22:00:00.000");
        LocalTime horaFinalOferta = LocalTime.parse("08:00:00.000");
        Boolean cumplePrecio = precioLibroOferta(precio);
        Boolean diaOferta = validarDiasOferta(fechaVenta);
        venta.setDetalleVenta(aplicarOferta(unidadVenta, time, horaInicialOferta,
                horaFinalOferta) && cumplePrecio && diaOferta ? "venta con descuento" : "venta sin descuento");
        venta.setPrecioVenta(reglaEstaEnRangoOferta(unidadVenta, time, horaInicialOferta,
                horaFinalOferta, precio, cumplePrecio, diaOferta));
        libro.setUnidades(totalLibro);
        servicioActualizarLibro.ejecutar(libro);
        return this.repositorioVenta.crear(venta);
    }

    public void validarInventarioLibro(Long totalLibro) {
        if(totalLibro<0) {
            throw new ExcepcionValorInvalido(NO_HAY_INVENTARIO_LIBRO);
        }
    }

     private boolean precioLibroOferta(Float precio) {
        if (precio<20000){
            return true;
        }
        return false;
    }

    private boolean aplicarOferta(Long unidadVenta, LocalTime time, LocalTime horaInicialOferta, LocalTime horaFinalOferta) {
           if ((unidadVenta>=2) && (horaInicialOferta.isBefore(time)) && (time.isAfter(horaFinalOferta))){
            return true;
        }
        return false;
    }

    private boolean validarDiasOferta(LocalDateTime fechaVenta) {
        if (!(fechaVenta.getDayOfWeek() == DayOfWeek.SATURDAY || fechaVenta.getDayOfWeek() == DayOfWeek.SUNDAY)) {
           return true;
        }
        return false;
    }


    private float reglaEstaEnRangoOferta(Long unidadVenta, LocalTime time, LocalTime horaInicialOferta,
                                          LocalTime horaFinalOferta, Float precio, boolean cumplePrecio, boolean diaOferta){

            if(aplicarOferta(unidadVenta, time, horaInicialOferta, horaFinalOferta) && cumplePrecio && diaOferta) {
                float precioConOferta = ((precio*50)/100)*unidadVenta;
                return precioConOferta;
            }
            float precioSinOferta = precio * unidadVenta;
            return  precioSinOferta;
    }



    private void validarExistenciaPreviaLibro(Long idLibro) {
        boolean existe = this.respositorioLibro.existePorId(idLibro);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }




    private void validarExistenciaPreviaUsuario(Long idUsuario) {
        boolean existe = this.repositorioUsuario.existePorId(idUsuario);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private float obtenerPrecioLibroPorId(Long idLibro) {
        float precio = this.respositorioLibro.obtenerPrecioLibroPorId(idLibro);
        return precio;
    }


    public Libro obtenerLibroPorId(Long idLibro) {
        Libro libro = this.respositorioLibro.obtenerLibroPorId(idLibro);
        return libro;
    }


}
