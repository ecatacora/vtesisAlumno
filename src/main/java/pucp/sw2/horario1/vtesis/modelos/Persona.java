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
public class Persona implements Serializable {
    private Integer idPersona;
    private String  nombres;
    private String apellidos;
    private Integer codigo;
    private Integer contrasena;
    private String foto;
    private Integer idRol;

    public Persona() {
    }

    public Persona(Integer idPersona, String nombres, String apellidos, Integer codigo, Integer contrasena, String foto, Integer idRol) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.contrasena = contrasena;
        this.foto = foto;
        this.idRol = idRol;
    }

   

    /**
     * @return the idPersona
     */
    public Integer getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
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
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the contraseña
     */
    public Integer getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contraseña to set
     */
    public void setContrasena(Integer contrasena) {
        this.contrasena = contrasena;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    
}
