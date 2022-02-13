package com.ceiba.libro.controlador;

import com.ceiba.libro.consulta.ManejadorListarLibros;
import com.ceiba.libro.modelo.dto.DtoLibro;
import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libros")
@Api(tags={"Controlador consulta libro"})
public class ConsultaControladorLibro {

    private final ManejadorListarLibros manejadorListarLibros;

    public ConsultaControladorLibro(ManejadorListarLibros manejadorListarLibros) {
        this.manejadorListarLibros = manejadorListarLibros;
    }

    @GetMapping
    @ApiOperation("Listar Libros")
    public List<DtoLibro> listar() {
        return this.manejadorListarLibros.ejecutar();
    }

}
