package com.ceiba.libro.modelo.dto;

import com.ceiba.libro.modelo.entidad.Libro;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoLibro {
    private Long id;
    private String titulo;
    private Long unidades;
    private Float precio;

/*    public Libro devuelveLibro(){
        return new Libro(this.getId(), this.getTitulo(), this.getUnidades(), this.getPrecio());
    }*/

}
