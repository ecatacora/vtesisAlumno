/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dao;

/**
 *
 * @author josesuk
 */
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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pucp.sw2.horario1.vtesis.dto.AvanceDTO;
import pucp.sw2.horario1.vtesis.modelos.Avance;

@Repository(value = "avanceDao")
public class AvanceDAO {

    @Autowired
    DataSource datasource;

    public void registrar(Avance avance) {
        StringBuilder sb = new StringBuilder();
        Map params = new HashMap();
        sb.append(" insert into proyecto(titulo, descripcion,idPersona,idEstado) ");
        sb.append(" values(:titulo, :descripcion,:idPersona,:idEstado) ");
        params.put("nombre", avance.getNombre());
        params.put("version", avance.getVersion());
        params.put("idRegistro", avance.getIdRegistro());
        params.put("fecha_inicio", avance.getFecha_inicio());
        params.put("idEstado", avance.getIdEstado());
        params.put("obs_asesor", avance.getObs_asesor());
        params.put("obs_alumno", avance.getObs_alumno());
        params.put("registro_alumno", avance.getRegistro_alumno());
        params.put("registro_asesor", avance.getRegistro_asesor());

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(datasource);
        SqlParameterSource paramSource = new MapSqlParameterSource(params);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sb.toString(), paramSource, keyHolder);

        avance.setIdAvance(keyHolder.getKey().intValue());
    }

    public void actualizar(AvanceDTO avance) {

        StringBuilder sb = new StringBuilder();
        sb.append(" update avances ");
        //sb.append(" fecha_inicio = ? ");
        //sb.append(" fecha_fin = ? ");
       // sb.append(" obs_asesor = ? ");
        sb.append(" set obs_alumno = ? ");
        //sb.append(" registro_alumno = ? ");
        //sb.append(" registro_asesor = ? ");

        sb.append(" where idAvances = ? ");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        jdbcTemplate.update(sb.toString(), new Object[]{ avance.getObs_alumno(),avance.getIdAvances()});
        

    }

    public Avance obtener(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT av.idAvances, av.nombre,av.version, av.historial_idHistorial, av.fecha_inicio, av.fecha_fin, av.Estado_idEstado, av.obs_asesor, av.obs_alumno, av.archivo_alumno, av.archivo_asesor");
        sql.append(" FROM Avances av ");
        sql.append(" where av.idAvances = ? ");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        Avance resultado = jdbcTemplate.queryForObject(sql.toString(), new Object[]{id}, new RowMapper<Avance>() {
            @Override
            public Avance mapRow(ResultSet rs, int rowNum) throws SQLException {
                Avance avance = new Avance();
                avance.setIdAvance(rs.getInt("av.idAvances"));
                avance.setNombre(rs.getString("av.nombre"));
                avance.setVersion(rs.getInt("av.version"));
                avance.setIdRegistro(rs.getInt("av.historial_idHistorial"));
                avance.setFecha_inicio(rs.getDate("av.fecha_inicio"));
                avance.setFecha_fin(rs.getDate("av.fecha_fin"));
                avance.setIdEstado(rs.getInt("av.Estado_idEstado"));
                avance.setObs_asesor(rs.getString("av.obs_asesor"));
                avance.setObs_alumno(rs.getString("av.obs_alumno"));
                avance.setRegistro_alumno(rs.getString("av.archivo_alumno"));
                avance.setRegistro_asesor(rs.getString("av.archivo_asesor"));

                return avance;
            }
        });
        return resultado;
    }

    public void actualizarEstado(Avance avance) {
        if (avance != null) {
            List<Object> parametros = new ArrayList<Object>();
            JdbcTemplate jdbc = new JdbcTemplate(datasource);
            StringBuilder sql = new StringBuilder();

            sql.append("UPDATE avance SET ");
            if (avance.getRegistro_alumno() == null && avance.getObs_alumno() == null) {
                sql.append("idestado = 2");
                parametros.add(avance.getIdEstado());
            }
            if ((avance.getRegistro_alumno() != null || avance.getObs_alumno() != null) && (avance.getRegistro_asesor() != null || avance.getObs_asesor() == null)) {
                sql.append("idestado = 3");
                parametros.add(avance.getIdEstado());
            }
            if ((avance.getRegistro_alumno() != null || avance.getObs_alumno() != null) && (avance.getRegistro_asesor() != null || avance.getObs_asesor() != null)) {
                sql.append("idestado = 1");
                parametros.add(avance.getIdEstado());
            }

            sql.append("WHERE idAvances= ? ");
            parametros.add(avance.getIdAvance());

            jdbc.update(sql.toString(), parametros.toArray());
        }
    }

    public List<Avance> listarAvancesByDate() {
        List<Avance> avances = new ArrayList<Avance>();
        JdbcTemplate jdbc = new JdbcTemplate(datasource);
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT idAvances, nombre, fecha_inicio, fecha_fin, idHistorial, idEstado ");
        sql.append("FROM avances ");
        
        
        
        
        return avances;
    }

}
