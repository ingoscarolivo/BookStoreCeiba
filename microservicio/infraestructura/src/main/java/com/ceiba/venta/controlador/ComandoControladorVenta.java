package com.ceiba.venta.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import com.ceiba.venta.comando.ComandoVenta;
import com.ceiba.venta.comando.manejador.ManejadorCrearVenta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
@Api(tags = { "Controlador comando venta"})
public class ComandoControladorVenta {

    private final ManejadorCrearVenta manejadorCrearVenta;
	//private final ManejadorEliminarVenta manejadorEliminarVenta;
	//private final ManejadorActualizarVenta manejadorActualizarVenta;

    @Autowired
    public ComandoControladorVenta(ManejadorCrearVenta manejadorCrearVenta){/*,
                                   ManejadorEliminarUsuario manejadorEliminarUsuario,
                                   ManejadorActualizarUsuario manejadorActualizarUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
		this.manejadorEliminarUsuario = manejadorEliminarUsuario;
		this.manejadorActualizarUsuario = manejadorActualizarUsuario;*/
		this.manejadorCrearVenta = manejadorCrearVenta;
	}

    @PostMapping
    @ApiOperation("Crear Venta")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoVenta comandoVenta) {
        return manejadorCrearVenta.ejecutar(comandoVenta);
    }

   /* @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Venta")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarUsuario.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Venta")
	public void actualizar(@RequestBody ComandoUsuario comandoUsuario,@PathVariable Long id) {
		comandoUsuario.setId(id);
		manejadorActualizarUsuario.ejecutar(comandoUsuario);
	}*/
}
