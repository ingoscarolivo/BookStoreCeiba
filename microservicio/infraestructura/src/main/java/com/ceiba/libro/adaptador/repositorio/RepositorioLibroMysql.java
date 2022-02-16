package com.ceiba.libro.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioLibroMysql implements RepositorioLibro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="libro", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="libro", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="libro", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="libro", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="libro", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="libro", value="obtenerPrecioLibroPorId")
    private static String sqlObtenerPrecioLibroPorId;

    @SqlStatement(namespace="libro", value="obtenerLibroPorId")
    private static String sqlObtenerLibroPorId;

    public RepositorioLibroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Libro libro) {
        return this.customNamedParameterJdbcTemplate.crear(libro, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String titulo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("titulo", titulo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Libro libro) {
        this.customNamedParameterJdbcTemplate.actualizar(libro, sqlActualizar);
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

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerLibroPorId,paramSource, new MapeoLibro());
    }

}
