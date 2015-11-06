/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.controllers;

import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pucp.sw2.horario1.vtesis.dao.*;
import pucp.sw2.horario1.vtesis.dto.*;
import pucp.sw2.horario1.vtesis.modelos.*;
import pucp.sw2.horario1.vtesis.ui.BusquedaFiltro;

/**
 *
 * @author josesuk
 */
@Controller(value = "alumnoController")
@RequestMapping(value = "alumno")
public class AlumnoController {

    @Autowired
    AlumnoDAO alumnoDAO;
    @Autowired
    AvanceDAO avanceDAO;

    /* se configura un log para este controlador*/
    private static final Logger log = Logger.getLogger("PersonaController");
    
    @RequestMapping(value = "alumno/profile")
    public String verPerfil(HttpSession session, Model model) {

        
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        
        model.addAttribute("ListaCursos", alumnoDAO.listarCursos(personaDTO.getIdPersona()));
        model.addAttribute("ListaCiclos", alumnoDAO.listarCiclos(personaDTO.getIdPersona()));        
        
        return "alumno/alumnoprofile";
    }
    
    @RequestMapping(value = "l_entrega")
    public String listarEntregas(BusquedaFiltro busquedaFiltro, HttpSession session, Model model) {

        //Obtener todas las entregas con los criterios usados en el filtro anterior y con el id del alumno
        //Mandarlos a la vista
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        HistorialDTO historialDTO = alumnoDAO.getHistorial(busquedaFiltro.getCiclo(), busquedaFiltro.getIdCurso(), personaDTO.getIdPersona());
        session.setAttribute("historialDTO", historialDTO);
        List<Avance> avanceList = alumnoDAO.listarAvances(historialDTO.getIdHistorial());
        model.addAttribute("ListaAvances", avanceList);

        return "alumno/alumnocronograma";
    }

    @RequestMapping(value = "r_entrega")
    public String registrarEntrega(Model model, @RequestParam Integer idAvance, HttpSession session) {
        
        //Obtener los datos de que entrega se va registrar, como el nombre de la entrega
        Avance avance= avanceDAO.obtener(idAvance);
        
        model.addAttribute("Avance", avance);
        return "alumno/alumnoentrega";
    }

    @RequestMapping(value = "inf_avance")
    public String informacionAvance(Model model,@RequestParam Integer idAvance) {

        // Conseguir los datos con un query del estado del avance, asi como la informacion del avance
        //Asi como el archivo subido por el profesor
        Avance avance= avanceDAO.obtener(idAvance);
        model.addAttribute("Avance", avance);
        return "alumno/alumnoobservaciones";
    }

}
