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
import pucp.sw2.horario1.vtesis.dto.*;
import pucp.sw2.horario1.vtesis.modelos.Avance;

/**
 *
 * @author Eudomar
 */
@Repository(value = "alumnoDAO")

public class AlumnoDAO {

    @Autowired
    DataSource datasource;

    public HistorialDTO getHistorial(String ciclo, Integer idCurso, Integer idAlumno) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idHistorial,ciclo,idCurso,alumno_idPersona,asesor_idPersona1");
        sql.append(" FROM historial ");
        sql.append(" where ciclo = ?,idCurso=?,alumno_idPersona=? ");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        HistorialDTO resultado = jdbcTemplate.queryForObject(sql.toString(), new Object[]{ciclo,idCurso,idAlumno}, new RowMapper<HistorialDTO>() {
            @Override
            public HistorialDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                HistorialDTO h = new HistorialDTO();
                h.setIdHistorial(rs.getInt("idHistorial"));
                h.setCiclo(rs.getString("ciclo"));
                h.setCurso_idCurso(rs.getInt("idCurso"));
                h.setAlumno_idPersona(rs.getInt("alumno_idPersona"));
                h.setAsesor_idPersona(rs.getInt("asesor_idPersona1"));                

                return h;
            }
        });
        return resultado;
    }

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
    public List<CursoDTO> listarCursos(Integer idPersona) {
        List<CursoDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        sql.append("select c.idCurso, c.nombre ");
        sql.append("FROM historial h ");
        sql.append("inner join curso c on (c.idCurso = h.idCurso) ");
        sql.append("where h.alumno_idPersona = ? ");
        parametros.add(idPersona);

        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                new RowMapper<CursoDTO>() {
                    @Override
                    public CursoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        
                        CursoDTO m = new CursoDTO();
                        m.setIdCurso(rs.getInt(1));
                        m.setNombre(rs.getString(2));
                        return m;
                    }
                });

        return lstResultados;
    }

    //Ciclos de un alumno
    public List<CicloDTO> listarCiclos(Integer idPersona) {
        List<CicloDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT ciclo ");
        sql.append("FROM historial ");
        sql.append("where alumno_idPersona = ? ");        
        parametros.add(idPersona);
        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                new RowMapper<CicloDTO>() {
                    @Override
                    public CicloDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        
                        CicloDTO c = new CicloDTO();
                        c.setCiclo(rs.getString("ciclo"));
                        return c;
                    }
                });

        return lstResultados;
    }

}
