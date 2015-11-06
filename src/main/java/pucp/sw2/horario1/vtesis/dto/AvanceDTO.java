/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dto;

/**
 *
 * @author josesuk
 */
public class AvanceDTO {

    private int idAvance;
    private String nombre;
    private String version;
    private String idHistorial;
    private String archivo;
    private String fecha_inicio;
    private String fecha_fin;
    private String idEstado;
    private String obs_asesor;
    private String obs_alumno;

    public int getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(int idAvance) {
        this.idAvance = idAvance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
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

    

}
