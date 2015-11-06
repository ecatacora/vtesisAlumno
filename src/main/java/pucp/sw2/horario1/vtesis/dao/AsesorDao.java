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
import pucp.sw2.horario1.vtesis.dto.AvanceDTO;
import pucp.sw2.horario1.vtesis.dto.CicloDTO;
import pucp.sw2.horario1.vtesis.dto.CursoDTO;
import pucp.sw2.horario1.vtesis.dto.PersonaDTO;
import pucp.sw2.horario1.vtesis.modelos.Avance;
import pucp.sw2.horario1.vtesis.modelos.Curso;
import pucp.sw2.horario1.vtesis.modelos.Estado;
import pucp.sw2.horario1.vtesis.modelos.Persona;
import pucp.sw2.horario1.vtesis.ui.AlumnoFiltro;

/**
 *
 * @author Lisseth
 */

@Repository(value = "asesorDao")

public class AsesorDao {

    @Autowired
    DataSource datasource;
    
    public PersonaDTO getInfo(int id) {

        String query = "select p.idPersona, "
                + "p.nombres, "
                + "p.apellidos, "
                + "p.codigo, "
                + "p.password, "
                + "p.email,"
                + "p.foto, "
                + "p.idRol, "
                + "from persona p "
                + "where p.idPersona = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        PersonaDTO persona = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<PersonaDTO>() {
            @Override
            public PersonaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        return persona;
    }
    
    
        
    public List<CicloDTO> listarCiclos(Integer idPersona) {
        List<CicloDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT h.ciclo ");
        sql.append("FROM historial h ");
        sql.append("where asesor_idPersona = ? ");
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
    
    public List<PersonaDTO> busqueda(AlumnoFiltro filtros){
        List<PersonaDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);        
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        
        sql.append(" select p.codigo, concat(p.nombres,' ',p.apellidos), c.nombre");
        sql.append(" from persona p");
        sql.append(" inner join historial h on (p.idPersona = h.alumno_idPersona)");
        sql.append(" inner join curso c on (h.idCurso = c.idCurso)");
        sql.append(" where idRol=3 "); 
        
        if (filtros.getIdCiclo()!= null){        
            sql.append(" AND c.idCiclo = ?");
            parametros.add(filtros.getIdCiclo());
        }
        
        sql.append(" order by p.codigo asc");
              
        
        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                        new RowMapper<PersonaDTO>() {
                            @Override
                            public PersonaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                                PersonaDTO persona = new PersonaDTO();
                                persona.setCodigo(rs.getString(1));
                                persona.setNombres(rs.getString(2));
                                Curso curso = new Curso();
                                curso.setNombre(rs.getString(3));
                                persona.setCurso(curso);
                                /*falta avance y fecha actualizacion
                                Avance avance = new Avance();
                                avance.setNombre(rs.getString(4));
                                persona.setAvance(avance);*/
                                return persona;
                            }
                        });        
        
        return lstResultados;
    }
    
    
        public List<AvanceDTO> listarAvances(Persona alumno){
        List<AvanceDTO> lstAvances = null;
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);  
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        
        sql.append(" select a.idAvances, a.nombre, a.fecha_fin, e.descripcion");      
        sql.append(" from avances a, historial h, persona p, estado e");
        sql.append(" where a.idHistorial=h.idHistorial and a.idEstado = e.idEstado ");
        sql.append(" and h.alumno_idPersona=? ");
        
        parametros.add(alumno.getIdPersona());
        
        lstAvances = jdbcTemplate.query(sql.toString(),
                        new RowMapper<AvanceDTO>() {
                            @Override
                            public AvanceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                                AvanceDTO avance = new AvanceDTO();
                                avance.setIdAvances(rs.getInt(1));
                                avance.setNombre(rs.getString(2));
                                avance.setFecha_fin(rs.getString(3));
                                Estado estado = new Estado();
                                estado.setDescripcion(rs.getString(4));
                                avance.setEstado(estado);
                               
                                return avance;
                            }
                        });        
        
        return lstAvances;
    }

    
    
    
}
