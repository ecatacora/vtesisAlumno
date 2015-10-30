/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.ui;

/**
 *
 * @author josesuk
 */
public class AvanceFiltro {
  private String nombre;
  private Integer fecha_inicio;
    private Integer fecha_fin;
    private Integer idEstado;
  private Integer todos;

    public AvanceFiltro(String nombre, Integer fecha_inicio, Integer fecha_fin, Integer idEstado, Integer todos) {
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.idEstado = idEstado;
        this.todos = todos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Integer fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Integer getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Integer fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getTodos() {
        return todos;
    }

    public void setTodos(Integer todos) {
        this.todos = todos;
    }

    

}
