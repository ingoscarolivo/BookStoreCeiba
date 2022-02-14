package com.ceiba.libro.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.libro.modelo.dto.DtoLibro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoLibro implements RowMapper<DtoLibro>, MapperResult {

    @Override
    public DtoLibro mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String titulo = resultSet.getString("titulo");
        Long unidades = resultSet.getLong("unidades");
        Float precio = resultSet.getFloat( "precio");

        return new DtoLibro(id,titulo,unidades,precio);
    }

}
