package com.ceiba.venta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.ServicioActualizarLibro;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
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
    private static final Long UNIDAD_MAXIMO_LIBRO_OFERTA = 2L;
    private static final Long PORCENTAJE_OFERTA_LIBRO = 50L;
    private static final Float PRECIO_MAXIMO_OFERTA_LIBRO = 20000F;
    private static final String HORA_INICIO_OFERTA = "10:00:00.000";
    private static final String HORA_FINAL_OFERTA = "11:00:00.000";
    private static final String DESCRIPCION_CON_OFERTA = "venta con descuento";
    private static final String DESCRIPCION_SIN_OFERTA = "venta sin descuento";

    private final RepositorioVenta repositorioVenta;
    private final ServicioActualizarLibro servicioActualizarLibro;
    private final DaoLibro daoLibro;
    private final DaoUsuario daoUsuario;

    public ServicioCrearVenta(RepositorioVenta repositorioVenta, ServicioActualizarLibro servicioActualizarLibro, DaoLibro daoLibro, DaoUsuario daoUsuario) {
        this.repositorioVenta = repositorioVenta;
        this.servicioActualizarLibro = servicioActualizarLibro;
        this.daoLibro = daoLibro;
        this.daoUsuario = daoUsuario;

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
        LocalTime horaInicialOferta = LocalTime.parse(HORA_INICIO_OFERTA);
        LocalTime horaFinalOferta = LocalTime.parse(HORA_FINAL_OFERTA);
        Boolean cumplePrecio = precioLibroOferta(precio);
        Boolean diaOferta = validarDiasOferta(fechaVenta);
        venta.setDetalleVenta(aplicarOferta(unidadVenta, time, horaInicialOferta,
                horaFinalOferta) && cumplePrecio && diaOferta ? DESCRIPCION_CON_OFERTA : DESCRIPCION_SIN_OFERTA);
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

    public boolean precioLibroOferta(Float precio) {
        return precio<PRECIO_MAXIMO_OFERTA_LIBRO;
    }

    public boolean aplicarOferta(Long unidadVenta, LocalTime time, LocalTime horaInicialOferta, LocalTime horaFinalOferta) {
         return ((unidadVenta>=UNIDAD_MAXIMO_LIBRO_OFERTA) && (horaInicialOferta.isBefore(time)) && (time.isAfter(horaFinalOferta)));
    }

    public boolean validarDiasOferta(LocalDateTime fechaVenta) {
        return (!(fechaVenta.getDayOfWeek() == DayOfWeek.SATURDAY || fechaVenta.getDayOfWeek() == DayOfWeek.SUNDAY));
    }


    private float reglaEstaEnRangoOferta(Long unidadVenta, LocalTime time, LocalTime horaInicialOferta,
                                          LocalTime horaFinalOferta, Float precio, boolean cumplePrecio, boolean diaOferta){

            if(aplicarOferta(unidadVenta, time, horaInicialOferta, horaFinalOferta) && cumplePrecio && diaOferta) {
                return ((precio*PORCENTAJE_OFERTA_LIBRO)/100)*unidadVenta;
            }
            return  precio * unidadVenta;
    }



    public void validarExistenciaPreviaLibro(Long idLibro) {
        boolean existe = this.daoLibro.existePorId(idLibro);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_LIBRO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    public void validarExistenciaPreviaUsuario(Long idUsuario) {
        boolean existe = this.daoUsuario.existePorId(idUsuario);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private float obtenerPrecioLibroPorId(Long idLibro) {
        return this.daoLibro.obtenerPrecioLibroPorId(idLibro);
    }


    public Libro obtenerLibroPorId(Long idLibro) {
        return this.daoLibro.obtenerLibroPorId(idLibro);
    }


}
