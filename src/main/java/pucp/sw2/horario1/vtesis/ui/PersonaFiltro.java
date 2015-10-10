/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.ui;

import java.io.Serializable;

/**
 *
 * @author josesuk
 */
public class PersonaFiltro  implements Serializable{
    private String nombres;
    private String  apellidos;
    private Integer idRol;    
    private Integer todos;

    public PersonaFiltro() {
    }

    public PersonaFiltro(String nombres, String apellidos, Integer idRol, Integer todos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idRol = idRol;
        this.todos = todos;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the idRol
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the todos
     */
    public Integer getTodos() {
        return todos;
    }

    /**
     * @param todos the todos to set
     */
    public void setTodos(Integer todos) {
        this.todos = todos;
    }
    
    
    
}
