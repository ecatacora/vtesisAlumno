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

/**
 *
 * @author Eudomar 
 */

@Repository(value = "alumnoDAO")

public class AlumnoDAO {
    
    @Autowired
    DataSource datasource;
    
    //Avances de alumno    
    public List<AlumnoDTO> listarAvances() {
        List<AlumnoDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        sql.append("select a.idAvances, a.nombre, a.version, a.historial_idHistorial, a.archivo_alumno, a.fecha_inicio, a.fecha_fin,  a.Estado_idEstado, a.obs_asesor, a.obs_alumno, a.archivo_asesor ");
        sql.append("from avances a ");
        sql.append("inner join historial h on (a.historial_idHistorial = h.idHistorial) ");
        sql.append("inner join persona p on (h.alumno_idPersona = p.idPersona) ");

        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                new RowMapper<AlumnoDTO>() {
                    @Override
                    public AlumnoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        
                        /*
                            private Integer idPersona;
                            private String  nombres;
                            private String apellidos;
                            private String codigo;
                            private String correo;
                            private String contrasena;
                            private String foto;
                            private int enabled;
                            private Integer Rol_idRol;
                        */
                        AlumnoDTO m = new AlumnoDTO();
                        m.setIdPersona(rs.getInt(1));
                        m.setNombres(rs.getString(2));
                        m.setApellidos(rs.getString(3));
                        m.setCodigo(rs.getString(4));
                        m.setCorreo(rs.getString(5));
                        m.setContrasena(rs.getString(6));
                        m.setFoto(rs.getString(7));
                        m.setEnabled(rs.getInt(8));
                        m.setRol_idRol(rs.getInt(9));
                        return m;
                    }
                });

        return lstResultados;
    }
    
    //Cursos de un alumno
    
    
    
    
    //Ciclos de un alumno
    
}
