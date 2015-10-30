/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dao;

/**
 *
 * @author josesuk
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pucp.sw2.horario1.vtesis.modelos.Avance;


@Repository(value = "avanceDao")
public class AvanceDAO {
 
    @Autowired
    DataSource datasource;
    
    public void registrar(Avance avance){
        StringBuilder sb = new StringBuilder();
        Map params = new HashMap();
        sb.append(" insert into proyecto(titulo, descripcion,idPersona,idEstado) ");
        sb.append(" values(:titulo, :descripcion,:idPersona,:idEstado) ");
        params.put("nombre",avance.getNombre());
        params.put("version",avance.getVersion());
        params.put("idRegistro",avance.getIdRegistro());
        params.put("fecha_inicio",avance.getFecha_inicio());
        params.put("idEstado",avance.getIdEstado());
        params.put("obs_asesor",avance.getObs_asesor());
        params.put("obs_alumno",avance.getObs_alumno());
        params.put("registro_alumno",avance.getRegistro_alumno());
        params.put("registro_asesor",avance.getRegistro_asesor());
        
        
        
     
        NamedParameterJdbcTemplate  jdbcTemplate = new NamedParameterJdbcTemplate (datasource);
        SqlParameterSource paramSource = new MapSqlParameterSource(params);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(sb.toString(),paramSource,keyHolder);

        avance.setIdAvance(keyHolder.getKey().intValue());        
    }
    
    public void actualizar(Avance avance){
        
        StringBuilder sb = new StringBuilder();
        sb.append(" update avance ");
        sb.append(" fecha_inicio = ? ");
        sb.append(" fecha_fin = ? ");
        sb.append(" obs_asesor = ? ");
        sb.append(" obs_alumno = ? ");
        sb.append(" registro_alumno = ? ");
        sb.append(" registro_asesor = ? ");
                
        sb.append(" where idAvance = ? ");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        jdbcTemplate.update(sb.toString(),new Object[]{avance.getNombre(),avance.getIdAvance(), avance.getFecha_inicio(),avance.getFecha_fin(),avance.getObs_asesor(),avance.getObs_alumno(), avance.getRegistro_alumno(), avance.getRegistro_asesor()});
        
    }
}

