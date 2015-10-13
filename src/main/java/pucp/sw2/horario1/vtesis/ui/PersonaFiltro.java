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
    
    
    
}
