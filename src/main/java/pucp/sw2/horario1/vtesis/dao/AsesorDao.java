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
import pucp.sw2.horario1.vtesis.dto.PersonaDTO;
import pucp.sw2.horario1.vtesis.modelos.Avance;
import pucp.sw2.horario1.vtesis.modelos.Curso;

/**
 *
 * @author Lisseth
 */

@Repository(value = "asesorDao")

public class AsesorDao {

    @Autowired
    DataSource datasource;
    
    public List<PersonaDTO> listarAlumnos(){
        List<PersonaDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);        
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        
        sql.append("select p.codigo, p.nombres, p.apellidos from persona p where Rol_idRol=3;");
                    //Listando todos los alumnos, falta restringir los alumnos de cada profe y especificar
                    //cursos, entregable y fecha de actualizacion.              
        
        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                        new RowMapper<PersonaDTO>() {
                            @Override
                            public PersonaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                                PersonaDTO p = new PersonaDTO();
                                p.setCodigo(rs.getString(1));
                                p.setNombres(rs.getString(2));
                                p.setApellidos(rs.getString(3));
                                
                                Curso curso = new Curso();
                                curso.setNombre(rs.getString(4));
                                p.setCurso(curso);
                                
                                Avance avance = new Avance();
                                avance.setNombre(rs.getString(5));
                                p.setAvance(avance);
                                
                                return p;
                            }
                        });        
        
        return lstResultados;
    }
    
    public PersonaDTO getInfo(int id) {

        String query = "select p.idPersona, "
                + "p.nombres, "
                + "p.apellidos, "
                + "p.codigo, "
                + "p.contraseña "
                + "p.foto, "
                + "p.Rol_idRol, "
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
    
    
}
