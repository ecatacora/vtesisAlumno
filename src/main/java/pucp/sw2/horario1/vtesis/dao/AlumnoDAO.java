/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pucp.sw2.horario1.vtesis.dto.AlumnoDTO;
import pucp.sw2.horario1.vtesis.dto.CursoDTO;
import pucp.sw2.horario1.vtesis.dto.HistorialDTO;
import pucp.sw2.horario1.vtesis.modelos.Avance;

/**
 *
 * @author Eudomar 
 */

@Repository(value = "alumnoDAO")

public class AlumnoDAO {
    
    @Autowired
    DataSource datasource;
    
    public List<Avance> listarAvances(Integer id) {
        List<Avance> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);        
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT av.idAvances, av.nombre,av.version, av.historial_idHistorial, av.fecha_inicio, av.fecha_fin, av.Estado_idEstado, av.obs_asesor, av.obs_alumno, av.archivo_alumno, av.archivo_asesor");
        sql.append(" FROM Avances av ");
        sql.append(" where av.historial_idHistorial = ? ");
        parametros.add(id);
        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                        new RowMapper<Avance>() {
                            @Override
                            public Avance mapRow(ResultSet rs, int rowNum) throws SQLException {
                                Avance avance = new Avance();    
                                avance.setIdAvance(rs.getInt("av.idAvances"));
                                avance.setNombre(rs.getString("av.nombre"));
                                avance.setVersion(rs.getInt("av.version"));
                                avance.setIdRegistro(rs.getInt("av.historial_idHistorial"));
                                avance.setFecha_inicio(rs.getInt("av.fecha_inicio"));
                                avance.setFecha_fin(rs.getInt("av.fecha_fin"));
                                avance.setIdEstado(rs.getInt("av.Estado_idEstado"));
                                avance.setObs_asesor(rs.getString("av.obs_asesor"));
                                avance.setObs_alumno(rs.getString("av.obs_alumno"));
                                avance.setRegistro_alumno(rs.getString("av.archivo_alumno"));
                                avance.setRegistro_asesor(rs.getString("av.archivo_asesor"));
                
                return avance;
            }
        });
        return lstResultados;
    }

    //Cursos de un alumno
    public List<CursoDTO> listarCursos() {
        List<CursoDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        sql.append("select c.idCurso, c.nombre ");
        sql.append("from curso c ");
        sql.append("inner join historial h on (c.idCurso = h.idHistorial) ");
        sql.append("inner join persona p on (h.alumno_idPersona = p.idPersona) ");

        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                new RowMapper<CursoDTO>() {
                    @Override
                    public CursoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        /*
                            private int idCurso;
                            private String nombre;
                        */
                        CursoDTO m = new CursoDTO();
                        m.setIdCurso(rs.getInt(1));
                        m.setNombre(rs.getString(2));
                        return m;
                    }
                });

        return lstResultados;
    } 
    
    //Ciclos de un alumno

        public List<HistorialDTO> listarCiclos() {
        List<HistorialDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        sql.append("select c.idCurso, c.nombre ");
        sql.append("from curso c ");
        sql.append("inner join historial h on (c.idCurso = h.idHistorial) ");
        sql.append("inner join persona p on (h.alumno_idPersona = p.idPersona) ");

        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                new RowMapper<HistorialDTO>() {
                    @Override
                    public HistorialDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        /*
                                private int idHistorial;
                                private int curso_idCurso;
                                private String ciclo;
                                private int alumno_idPersona;
                                private int asesor_idPersona;
                        */
                        HistorialDTO m = new HistorialDTO();
                        m.setIdHistorial(rs.getInt(1));
                        m.setCurso_idCurso(rs.getInt(2));
                        m.setCiclo(rs.getString(3));
                        m.setAlumno_idPersona(rs.getInt(4));
                        m.setAsesor_idPersona(rs.getInt(5));
                        return m;
                    }
                });

        return lstResultados;
    }       
    
}
