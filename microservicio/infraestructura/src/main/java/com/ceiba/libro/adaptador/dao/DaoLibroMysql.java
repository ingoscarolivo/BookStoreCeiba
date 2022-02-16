package com.ceiba.libro.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.modelo.dto.DtoLibro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoLibroMysql implements DaoLibro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="libro", value="listar")
    private static String sqlListarLibro;

    public DaoLibroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoLibro> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarLibro, new MapeoLibro());
    }

}
