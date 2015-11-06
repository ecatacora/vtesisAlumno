/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dto;

/**
 *
 * @author josesuk
 * modified by Eudomar
 */
public class AvanceDTO {
    
    private int idAvances;
    private String nombre;
    private String version;
    private int historial_idHistorial;
    private String archivo_alumno;
    private String fecha_inicio;
    private String fecha_fin;
    private String Estado_idEstado;
    private String obs_asesor;
    private String obs_alumno;
    private String archivo_asesor;

    public int getIdAvances() {
        return idAvances;
    }

    public void setIdAvances(int idAvances) {
        this.idAvances = idAvances;
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

    public int getHistorial_idHistorial() {
        return historial_idHistorial;
    }

    public void setHistorial_idHistorial(int historial_idHistorial) {
        this.historial_idHistorial = historial_idHistorial;
    }

    public String getArchivo_alumno() {
        return archivo_alumno;
    }

    public void setArchivo_alumno(String archivo_alumno) {
        this.archivo_alumno = archivo_alumno;
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

    public String getEstado_idEstado() {
        return Estado_idEstado;
    }

    public void setEstado_idEstado(String Estado_idEstado) {
        this.Estado_idEstado = Estado_idEstado;
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

    public String getArchivo_asesor() {
        return archivo_asesor;
    }

    public void setArchivo_asesor(String archivo_asesor) {
        this.archivo_asesor = archivo_asesor;
    }   
    
}
