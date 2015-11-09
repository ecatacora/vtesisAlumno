/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dto;

import pucp.sw2.horario1.vtesis.modelos.Estado;

/**
 *
 * @author josesuk modified by Eudomar
 */
public class AvanceDTO {

    private int idAvances;
    private String nombre;
    private String version;
    private int idHistorial;
    private String archivo_alumno;
    private String fecha_inicio;
    private String fecha_fin;
    private Estado estado;
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

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
