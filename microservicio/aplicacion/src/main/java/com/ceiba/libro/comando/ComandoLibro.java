package com.ceiba.libro.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoLibro {

    private Long id;
    private String titulo;
    private Long unidades;
    private Float precio;
}
