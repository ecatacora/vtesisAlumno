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
import pucp.sw2.horario1.vtesis.ui.AvanceFiltro;

/**
 *
 * @author Lisseth
 */

@Repository(value = "asesorDao")

public class AsesorDao {

    @Autowired
    DataSource datasource;
    
    public List<CicloDTO> listarCiclos(Integer idPersona) {
        List<CicloDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT h.ciclo ");
        sql.append("FROM historial h ");
        sql.append("inner join persona p on (p.idPersona=h.asesor_idPersona1) ");
        sql.append("where idPersona = ? ");
        parametros.add(idPersona);
        
        sql.append("group by h.ciclo order by h.ciclo desc");
        
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
    
    public List<PersonaDTO> busqueda(AlumnoFiltro filtros, Integer idAsesor){
        List<PersonaDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);        
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        
        sql.append(" select p.codigo, concat(p.nombres,' ',p.apellidos), c.nombre, p.idPersona");
        sql.append(" from persona p");
        sql.append(" inner join historial h on (p.idPersona = h.alumno_idPersona)");
        sql.append(" inner join curso c on (h.idCurso = c.idCurso)");
        sql.append(" where idRol=3 "); 
        
               
        sql.append(" AND h.ciclo = ?");
        parametros.add(filtros.getCiclo());
        
        sql.append(" AND h.asesor_idPersona1 = ?");
        parametros.add(idAsesor);
                
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
                                persona.setIdPersona(rs.getInt(4));
                                /*falta avance y fecha actualizacion
                                Avance avance = new Avance();
                                avance.setNombre(rs.getString(4));
                                persona.setAvance(avance);*/
                                return persona;
                            }
                        });        
        
        return lstResultados;
    }
    
    
        public List<AvanceDTO> listarAvances(AvanceFiltro filtros){
        List<AvanceDTO> resultado = null;
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);  
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        
        sql.append(" select a.idAvances, a.nombre, a.fecha_fin, e.descripcion ");      
        sql.append(" from avances a ");
        sql.append(" inner join historial h on (a.idHistorial = h.idHistorial) ");
        sql.append(" inner join persona p on (h.alumno_idPersona = p.idPersona) ");
        sql.append(" inner join estado e on (a.idEstado = e.idEstado) ");
        
        sql.append(" where p.codigo = ? ");
        parametros.add(filtros.getCodigo());
        
        
        
        resultado = jdbcTemplate.query(sql.toString(), parametros.toArray(),
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
        
        return resultado;
    }

    
    
    
}
