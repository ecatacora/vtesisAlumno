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
import pucp.sw2.horario1.vtesis.modelos.Estado;

/**
 *
 * @author Eudomar
 */
@Repository(value = "alumnoDAO")

public class AlumnoDAO {

    @Autowired
    DataSource datasource;

    public AlumnoDTO get(String codigo) {

        String query = "select e.idPersona, "
                + "e.nombres, "
                + "e.apellidos, "
                + "e.codigo, "
                + "e.password, "
                + "e.foto, "
                + "e.email, "
                + "e.enabled, "
                + "e.idRol "
                + "from persona e "
                + "where e.codigo = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        AlumnoDTO employee = jdbcTemplate.queryForObject(query, new Object[]{codigo}, new RowMapper<AlumnoDTO>() {
            @Override
            public AlumnoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AlumnoDTO p = new AlumnoDTO();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setApellidos(rs.getString(3));
                p.setCodigo(rs.getString(4));
                p.setContrasena(rs.getString(5));
                p.setFoto(rs.getString(6));
                p.setCorreo(rs.getString(7));
                p.setEnabled(rs.getInt(8));
                p.setIdRol(rs.getInt(9));
                return p;
            }
        });
        return employee;
    }

    public List<HistorialDTO> gethis(String codigo) {
        List<HistorialDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT p.idPersona, h.idHistorial ,h.ciclo ,h.idCurso ");
        sql.append("from historial h, persona p ");
        sql.append("where p.idPersona =h.alumno_idPersona and p.codigo=?");
        parametros.add(codigo);
        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                new RowMapper<HistorialDTO>() {
                    @Override
                    public HistorialDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        HistorialDTO p = new HistorialDTO();
                        p.setAsesor_idPersona(rs.getInt(1));
                        p.setIdHistorial(rs.getInt(2));
                        p.setCiclo(rs.getString(3));
                        p.setCurso_idCurso(rs.getInt(4));

                        return p;

                    }
                });
        return lstResultados;
    }

    public HistorialDTO getHistorial(String ciclo, Integer idCurso, Integer idAlumno) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT idHistorial,ciclo,idCurso,alumno_idPersona,asesor_idPersona1");
        sql.append(" FROM historial ");
        sql.append(" where ciclo = ? AND idCurso=? AND alumno_idPersona=? ");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        HistorialDTO resultado = jdbcTemplate.queryForObject(sql.toString(), new Object[]{ciclo, idCurso, idAlumno}, new RowMapper<HistorialDTO>() {
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

    public List<AvanceDTO> listarAvances(Integer id) {
        List<AvanceDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT av.idAvances, av.nombre,av.version, av.idHistorial, av.fecha_inicio, av.fecha_fin, av.idEstado, av.obs_asesor, av.obs_alumno, av.archivo_alumno, av.archivo_asesor, e.descripcion ");
        sql.append(" FROM avances av, estado e ");
        sql.append(" where av.idEstado = e.idEstado AND av.idHistorial = ? ");
        parametros.add(id);
        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                new RowMapper<AvanceDTO>() {
                    @Override
                    public AvanceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        AvanceDTO avance = new AvanceDTO();
                        avance.setIdAvances(rs.getInt("av.idAvances"));
                        avance.setNombre(rs.getString("av.nombre"));
                        avance.setVersion(rs.getString("av.version"));
                        avance.setIdHistorial(rs.getInt("av.idHistorial"));
                        avance.setFecha_inicio(rs.getString("av.fecha_inicio"));
                        avance.setFecha_fin(rs.getString("av.fecha_fin"));
                        Estado e = new Estado();
                        e.setDescripcion(rs.getString("e.descripcion"));
                        avance.setEstado(e);
                        avance.setObs_asesor(rs.getString("av.obs_asesor"));
                        avance.setObs_alumno(rs.getString("av.obs_alumno"));
                        avance.setArchivo_alumno(rs.getString("av.archivo_alumno"));
                        avance.setArchivo_asesor(rs.getString("av.archivo_asesor"));

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
    
    public AvanceDTO obtenerAvance(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT av.idAvances, av.nombre,av.version, av.idHistorial, av.fecha_inicio, av.fecha_fin, av.idEstado, av.obs_asesor, av.obs_alumno, av.archivo_alumno, av.archivo_asesor ");
        sql.append(" FROM avances av ");
        sql.append(" where av.idAvances = ? ");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        AvanceDTO resultado = jdbcTemplate.queryForObject(sql.toString(), new Object[]{id}, new RowMapper<AvanceDTO>() {
            @Override
            public AvanceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AvanceDTO avance = new AvanceDTO();
                        avance.setIdAvances(rs.getInt("av.idAvances"));
                        avance.setNombre(rs.getString("av.nombre"));
                        avance.setVersion(rs.getString("av.version"));
                        avance.setIdHistorial(rs.getInt("av.idHistorial"));
                        avance.setFecha_inicio(rs.getString("av.fecha_inicio"));
                        avance.setFecha_fin(rs.getString("av.fecha_fin"));
                        Estado e = new Estado();
                        e.setId(rs.getInt("av.idEstado"));
                        avance.setEstado(e);
                        avance.setObs_asesor(rs.getString("av.obs_asesor"));
                        avance.setObs_alumno(rs.getString("av.obs_alumno"));
                        avance.setArchivo_alumno(rs.getString("av.archivo_alumno"));
                        avance.setArchivo_asesor(rs.getString("av.archivo_asesor"));

                        return avance;
            }
        });
        return resultado;
    }

}
