package com.ceiba.libro.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.modelo.dto.DtoLibro;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoLibroMysql implements DaoLibro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="libro", value="listar")
    private static String sqlListarLibro;

    @SqlStatement(namespace="libro", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="libro", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="libro", value="obtenerPrecioLibroPorId")
    private static String sqlObtenerPrecioLibroPorId;

    @SqlStatement(namespace="libro", value="obtenerLibroPorId")
    private static String sqlObtenerLibroPorId;

    public DaoLibroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoLibro> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarLibro, new MapeoLibro());
    }

    @Override
    public boolean existe(String titulo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("titulo", titulo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }

    @Override
    public float obtenerPrecioLibroPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPrecioLibroPorId,paramSource, Float.class);
    }


    @Override
    public Libro obtenerLibroPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerLibroPorId,paramSource, new com.ceiba.libro.adaptador.repositorio.MapeoLibro());
    }


}
