/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pucp.sw2.horario1.vtesis.modelos.Avance;

/**
 *
 * @author Hiroshi
 */
public class AvanceMapper implements RowMapper<Avance> {

    @Override
    public Avance mapRow(ResultSet rs, int rowNum) throws SQLException {
        Avance avance = new Avance();
        avance.setIdAvance(rs.getInt(1));
        avance.setNombre(rs.getString(2));
        avance.setFecha_inicio(rs.getDate(3));
        avance.setFecha_fin(rs.getDate(4));
        avance.setIdRegistro(rs.getInt(5));
        avance.setIdEstado(rs.getInt(6));
        return avance;
    }
}
