/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.modelos;

import java.io.Serializable;

/**
 *
 * @author josesuk
 */
public class Registro implements Serializable{
    
    private Integer idRegistro;
    private Integer idCurso;
    private String ciclo;
    private Integer alumno_idPersona;
    private Integer asesor_idPersona;

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

    public Integer getAlumno_idPersona() {
        return alumno_idPersona;
    }

    public void setAlumno_idPersona(Integer alumno_idPersona) {
        this.alumno_idPersona = alumno_idPersona;
    }

    public Integer getAsesor_idPersona() {
        return asesor_idPersona;
    }

    public void setAsesor_idPersona(Integer asesor_idPersona) {
        this.asesor_idPersona = asesor_idPersona;
    }
    
}
