/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.controllers;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pucp.sw2.horario1.vtesis.dao.AlumnoDAO;

/**
 *
 * @author josesuk
 */
@Controller(value = "alumnoController")
@RequestMapping(value = "alumno")
public class AlumnoController {

    @Autowired
    AlumnoDAO alumnoDAO;

    /* se configura un log para este controlador*/
    private static final Logger log = Logger.getLogger("PersonaController");

    @RequestMapping(value = "alumnoperfil")
    public String informacionProfile(Model model) {
        
        
        //Objeto AlumnoDAO se recibe y lo mando a la vista
        //Tambien obtener todos los historiales en los cuales se encuentra el alumno
        
        return "alumno/alumnoprofile";
    }

    @RequestMapping(value = "l_entrega")
    public String listarEntregas(Model model) {
        
        //Obtener todas las entregas con los criterios usados en el filtro anterior y con el id del alumno
        //Mandarlos a la vista
        
        return "alumno/alumnocronograma";
    }

    @RequestMapping(value = "r_entrega")
    public String registrarEntrega(Model model) {
        
        //Obtener los datos de que entrega se va registrar, como el nombre de la entrega
       
       
        return "alumno/alumnoentrega";
    }

    @RequestMapping(value = "avance")
    public String informacionAvance(Model model) {
        
        // Conseguir los datos con un query del estado del avance, asi como la informacion del avance
        //Asi como el archivo subido por el profesor
        
        
        return "alumno/alumnoobservaciones";
    }

}
