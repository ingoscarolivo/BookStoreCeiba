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


    public RepositorioLibroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Libro libro) {
        return this.customNamedParameterJdbcTemplate.crear(libro, sqlCrear);
    }

    @Override
    public Integer eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

       return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }


    @Override
    public void actualizar(Libro libro) {
        this.customNamedParameterJdbcTemplate.actualizar(libro, sqlActualizar);
    }


}
