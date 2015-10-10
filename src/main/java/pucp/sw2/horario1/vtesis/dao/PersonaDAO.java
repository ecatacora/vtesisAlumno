/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dao;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pucp.sw2.horario1.vtesis.modelos.Persona;

/**
 *
 * @author Hiroshi
 */
@Repository(value = "personaDAO")
public class PersonaDAO {
    @Autowired
    DataSource datasource;

    public boolean isValidUser(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void registrar(Persona persona){
        StringBuilder sb = new StringBuilder();
        Map params = new HashMap();
        sb.append(" insert into Persona(titulo, descripcion,idPersona,idEstado) ");
        sb.append(" values(:titulo, :descripcion,:idPersona,:idEstado) ");
    }
    
    
    
}
