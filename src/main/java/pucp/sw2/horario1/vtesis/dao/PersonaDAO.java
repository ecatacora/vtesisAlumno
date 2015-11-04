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

    public List<EmployeeBean> listemployees() {

        String query = "select e.EmployeeID, "
                + "e.Title, "
                + "e.FirstName, "
                + "e.LastName, "
                + "e.Email, "
                + "e.HomePhone, "
                + "e.Extension, "
                + "e.PostalCode, "
                + "e.Region, "
                + "e.Role, "
                + "e.Address, "
                + "e.City, "
                + "e.Country, "
                + "e.Enabled "
                + "from employees e "
                + "where e.Enabled = 1";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<EmployeeBean> employee_list = jdbcTemplate.query(query, new EmployeeMapper());
        return employee_list;

    }  
    
    public PersonaDTO get(String email) {

        String query = "select e.EmployeeID, "
                + "e.Title, "
                + "e.FirstName, "
                + "e.LastName, "
                + "e.Email, "
                + "e.HomePhone, "
                + "e.Extension, "
                + "e.PostalCode, "
                + "e.Region, "
                + "e.Role, "
                + "e.Address, "
                + "e.City, "
                + "e.Country, "
                + "e.Enabled "
                + "from employees e "
                + "where e.Email = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        EmployeeBean employee = jdbcTemplate.queryForObject(query, new Object[]{email}, new EmployeeMapper());
        return employee;
    }

    public void update(EmployeeBean employee) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE employees SET FirstName = ?,"
                + " LastName = ? ,"
                + " HomePhone = ? ,"
                + " Extension = ? ,"
                + " Address = ? ,"
                + " City = ? ,"
                + " Country = ?, "
                + " Region = ? "
                + " WHERE EmployeeID = ?");
        
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            List<Object> parametros = new ArrayList<Object>();
            parametros.add(employee.getFirstName());
            parametros.add(employee.getLastName());
            parametros.add(employee.getHomePhone());
            parametros.add(employee.getExtension());
            parametros.add(employee.getAddress());
            parametros.add(employee.getCity());
            parametros.add(employee.getCountry());
            parametros.add(employee.getRegion());
            parametros.add(employee.getEmployeeID());
            jdbcTemplate.update(sql.toString(), parametros.toArray());
        }catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    
    
    
}
