/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.dto;

/**
 *
 * @author Eudomar
 */
public class HistorialDTO {
    
    private int idHistorial;
    private int curso_idCurso;
    private String ciclo;
    private int alumno_idPersona;
    private int asesor_idPersona;

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getCurso_idCurso() {
        return curso_idCurso;
    }

    public void setCurso_idCurso(int curso_idCurso) {
        this.curso_idCurso = curso_idCurso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getAlumno_idPersona() {
        return alumno_idPersona;
    }

    public void setAlumno_idPersona(int alumno_idPersona) {
        this.alumno_idPersona = alumno_idPersona;
    }

    public int getAsesor_idPersona() {
        return asesor_idPersona;
    }

    public void setAsesor_idPersona(int asesor_idPersona) {
        this.asesor_idPersona = asesor_idPersona;
    }
    
    
    
}
