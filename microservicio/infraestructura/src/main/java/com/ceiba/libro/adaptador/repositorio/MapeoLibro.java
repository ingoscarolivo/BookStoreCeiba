package com.ceiba.libro.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.libro.modelo.dto.DtoLibro;
import com.ceiba.libro.modelo.entidad.Libro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoLibro implements RowMapper<Libro>, MapperResult {

    @Override
    public Libro mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String titulo = resultSet.getString("titulo");
        Long unidades = resultSet.getLong("unidades");
        Float precio = resultSet.getFloat( "precio");

        return new Libro(id,titulo,unidades,precio);
    }

}
