package com.ceiba.venta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.venta.modelo.dto.DtoVenta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoVenta implements RowMapper<DtoVenta>, MapperResult {

    @Override
    public DtoVenta mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idLibro = resultSet.getLong("idLibro");
        Long idUsuario = resultSet.getLong("idUsuario");
        Long unidadVenta = resultSet.getLong("unidad_Venta");
        Float precioUnidad = resultSet.getFloat("precio_Unidad");
        Float precioVenta = resultSet.getFloat("precio_Venta");
        LocalDateTime fechaVenta = extraerLocalDateTime(resultSet, "fecha_Venta");

        return new DtoVenta(id,idLibro,idUsuario,unidadVenta, precioUnidad,precioVenta,fechaVenta);
    }

}
