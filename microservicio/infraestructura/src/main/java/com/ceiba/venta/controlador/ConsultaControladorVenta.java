package com.ceiba.venta.controlador;

import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.venta.consulta.ManejadorListarVentas;
import com.ceiba.venta.modelo.dto.DtoVenta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@Api(tags={"Controlador consulta venta"})
public class ConsultaControladorVenta {

    private final ManejadorListarVentas manejadorListarVentas;

    public ConsultaControladorVenta(ManejadorListarVentas manejadorListarVentas) {
        this.manejadorListarVentas = manejadorListarVentas;
    }

    @GetMapping
    @ApiOperation("Listar Ventas")
    public List<DtoVenta> listar() {
        return this.manejadorListarVentas.ejecutar();
    }

}
