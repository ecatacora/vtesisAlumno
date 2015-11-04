/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dao;

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
import org.springframework.stereotype.Repository;
import pucp.sw2.horario1.vtesis.dto.PersonaDTO;
import pucp.sw2.horario1.vtesis.modelos.Persona;

/**
 *
 * @author Hiroshi
 */
@Repository(value = "personaDAO")
public class PersonaDAO {

    @Autowired
    DataSource datasource;

    public List<PersonaDTO> ListarPersona() {

        List<PersonaDTO> lstPersonas = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        StringBuilder sql = new StringBuilder();

        sql.append(" select p.idPersona, p.nombres, p.apellidos,p.codigo, p.contraseña, p.rol from persona p left join rol r ");
        sql.append(" on (p.Rol_idRol=r.idRol)");

        lstPersonas = jdbcTemplate.query(sql.toString(),
                new RowMapper<PersonaDTO>() {
                    @Override
                    public PersonaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        PersonaDTO persona = new PersonaDTO();
                        persona.setIdPersona(rs.getInt(1));
                        persona.setNombres(rs.getString(2));
                        persona.setApellidos(rs.getString(3));
                        persona.setCodigo(rs.getString(4));
                        persona.setContrasena(rs.getString(5));
                        persona.setIdRol(rs.getInt(6));
                        return persona;
                    }
                });

        return lstPersonas;
    }

    public void actualizarPersona(Persona persona) {
        StringBuilder sql = new StringBuilder();

        try {

            JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
            sql.append("UPDATE persona SET nombres = ?,"
                    + " apellidos = ? ,"
                    + " codigo = ? ,"
                    + " contraseña = ? ,"
                    + " foto = ? ,"
                    + " Rol_idRol = ? ,"
                    + " WHERE idPersona = ?");

            List<Object> parametros = new ArrayList<Object>();
            parametros.add(persona.getNombres());
            parametros.add(persona.getApellidos());
            parametros.add(persona.getCodigo());
            parametros.add(persona.getContrasena());
            parametros.add(persona.getFoto());
            parametros.add(persona.getIdRol());
            parametros.add(persona.getIdPersona());

            jdbcTemplate.update(sql.toString(), parametros.toArray());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void borrarPersona(Persona persona) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE from persona"
                + " WHERE idPersona = ?");

        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
            List<Object> parametros = new ArrayList<Object>();
            parametros.add(persona.getIdPersona());

            jdbcTemplate.update(sql.toString(), parametros.toArray());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
