package com.ceiba.libro.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.libro.comando.ComandoLibro;
import com.ceiba.libro.comando.manejador.ManejadorActualizarLibro;
import com.ceiba.libro.comando.manejador.ManejadorCrearLibro;
import com.ceiba.libro.comando.manejador.ManejadorEliminarLibro;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
@Api(tags = { "Controlador comando libro"})
public class ComandoControladorLibro {

    private final ManejadorCrearLibro manejadorCrearLibro;
	private final ManejadorEliminarLibro manejadorEliminarLibro;
	private final ManejadorActualizarLibro manejadorActualizarLibro;

    @Autowired
    public ComandoControladorLibro(ManejadorCrearLibro manejadorCrearLibro,
								   ManejadorEliminarLibro manejadorEliminarLibro,
								   ManejadorActualizarLibro manejadorActualizarLibro) {
        this.manejadorCrearLibro = manejadorCrearLibro;
		this.manejadorEliminarLibro = manejadorEliminarLibro;
		this.manejadorActualizarLibro = manejadorActualizarLibro;
    }

    @PostMapping
    @ApiOperation("Crear Libros")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoLibro comandoLibro) {
        return manejadorCrearLibro.ejecutar(comandoLibro);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Libro")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarLibro.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Libro")
	public void actualizar(@RequestBody ComandoLibro comandoLibro,@PathVariable Long id) {
		comandoLibro.setId(id);
		manejadorActualizarLibro.ejecutar(comandoLibro);
	}
}
