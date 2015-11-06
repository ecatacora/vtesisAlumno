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
import pucp.sw2.horario1.vtesis.dto.RolDTO;

/**
 *
 * @author Hiroshi
 */
@Repository(value = "rolDAO")
public class RolDAO {
    
    @Autowired
    DataSource dataSource;
    
    public List<RolDTO> listarRol(){
        
        List<RolDTO> lstResultados = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);        
        List<Object> parametros = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        
        sql.append(" select idRol, tipo ");
        sql.append(" from rol ");
        
              
        
        lstResultados = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                        new RowMapper<RolDTO>() {
                            @Override
                            public RolDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                                RolDTO menu = new RolDTO();
                                menu.setIdRol(rs.getInt(1));
                                menu.setTipo(rs.getString(2));
                                
                                return menu;
                            }
                        });        
        
        return lstResultados;
        
    }
    
}
