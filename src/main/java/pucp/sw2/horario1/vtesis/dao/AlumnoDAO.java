/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josesuk
 */
@Repository(value = "alumnoDAO")
public class AlumnoDAO extends PersonaDAO{
    @Autowired
    DataSource datasource;
    
   //Metodos del alumno
    
    
}
