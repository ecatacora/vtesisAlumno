/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.modelos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author josesuk
 */
public class Avance implements Serializable{
    
    private Integer idAvance;
    private String nombre;
    private Integer version;
    private Integer idRegistro;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Integer idEstado;
    private String obs_asesor;
    private String obs_alumno;
    private String registro_alumno;
    private String registro_asesor;

    public Integer getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(Integer idAvance) {
        this.idAvance = idAvance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getObs_asesor() {
        return obs_asesor;
    }

    public void setObs_asesor(String obs_asesor) {
        this.obs_asesor = obs_asesor;
    }

    public String getObs_alumno() {
        return obs_alumno;
    }

    public void setObs_alumno(String obs_alumno) {
        this.obs_alumno = obs_alumno;
    }

    public String getRegistro_alumno() {
        return registro_alumno;
    }

    public void setRegistro_alumno(String registro_alumno) {
        this.registro_alumno = registro_alumno;
    }

    public String getRegistro_asesor() {
        return registro_asesor;
    }

    public void setRegistro_asesor(String registro_asesor) {
        this.registro_asesor = registro_asesor;
    }

   
    
}
