/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dto;

import pucp.sw2.horario1.vtesis.modelos.Persona;

/**
 *
 * @author josesuk
 */
public class RegistroDTO {
    
    private Integer idRegistro;
    private Integer idCurso;
    private String ciclo;
    private Persona alumno;
    private Persona asesor;

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Persona getAlumno() {
        return alumno;
    }

    public void setAlumno(Persona alumno) {
        this.alumno = alumno;
    }

    public Persona getAsesor() {
        return asesor;
    }

    public void setAsesor(Persona asesor) {
        this.asesor = asesor;
    }

    
    
    
    
    
    
}
