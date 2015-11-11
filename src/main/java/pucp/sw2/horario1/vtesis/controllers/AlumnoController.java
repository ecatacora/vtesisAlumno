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
@RequestMapping(value = "/alumno")
public class AlumnoController {

    @Autowired
    AlumnoDAO alumnoDAO;
    @Autowired
    AvanceDAO avanceDAO;


    /* se configura un log para este controlador*/
    private static final Logger log = Logger.getLogger("PersonaController");

    @RequestMapping(value = "/profile")
    public String verPerfil(HttpSession session, Model model) {

        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");

        //System.out.println("holaaaaaaaaaaaaa  naaaaaada" + personaDTO.getCodigo() );
        AlumnoDTO p = alumnoDAO.get(personaDTO.getCodigo());

        List<HistorialDTO> his = alumnoDAO.gethis(p.getCodigo());

        //System.out.println(his + "  naaaaaada" );
        model.addAttribute("historial", his);

        BusquedaFiltro busquedaFiltro = new BusquedaFiltro();
        model.addAttribute("busquedaFiltro", busquedaFiltro);
        model.addAttribute("persona", p);
        //model.addAttribute("ListaCursos", alumnoDAO.listarCursos(personaDTO.getIdPersona()));
        System.out.println(busquedaFiltro.getCiclo() + "  naaaaaada");
        model.addAttribute("ListaCiclos", alumnoDAO.listarCiclos(personaDTO.getIdPersona()));

        return "alumno/alumnoprofile";
    }

    @RequestMapping(value = "/profile_buscar")
    public String verPerfil(BusquedaFiltro busquedaFiltro, HttpSession session, Model model) {
       // System.out.println(busquedaFiltro.getCiclo() + "  naaaaaada");
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        //session.setAttribute("ciclito", busquedaFiltro.getCiclo());
        //System.out.println("holaaaaaaaaaaaaa  naaaaaada" + personaDTO.getCodigo() );
        AlumnoDTO p = alumnoDAO.get(personaDTO.getCodigo());

        List<HistorialDTO> his = alumnoDAO.gethis(p.getCodigo());

        model.addAttribute("historial", his);
        model.addAttribute("busquedaFiltro", busquedaFiltro);
         if(busquedaFiltro.getCiclo()==""){
           return "redirect:/alumno/profile";
        }else{
            
        BusquedaFiltro nuevoFiltro = new BusquedaFiltro();

        model.addAttribute("nuevoFiltro", nuevoFiltro);
        //session.setAttribute("cursito",nuevoFiltro.getIdCurso());
        model.addAttribute("persona", p);
        model.addAttribute("ListaCursos", alumnoDAO.listarCursos(personaDTO.getIdPersona(), busquedaFiltro.getCiclo()));
        //System.out.println(busquedaFiltro.getCiclo() + "  naaaaaada");
        model.addAttribute("ListaCiclos", alumnoDAO.listarCiclos(personaDTO.getIdPersona()));

        return "alumno/alumnoprofile";
        }
    }

    @RequestMapping(value = "l_entrega")
    public String listarEntregas(BusquedaFiltro nuevoFiltro, HttpSession session, Model model) {

        //Obtener todas las entregas con los criterios usados en el filtro anterior y con el id del alumno
        //Mandarlos a la vista
        //String ciclito=(String)session.getAttribute("ciclito");
        //int cursito=(int)session.getAttribute("cursito");
        System.out.println(nuevoFiltro.getCiclo() + "  naaaaaada" + nuevoFiltro.getIdCurso());
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        AlumnoDTO p = alumnoDAO.get(personaDTO.getCodigo());
        model.addAttribute("personaDTO", p);
        HistorialDTO historialDTO = alumnoDAO.getHistorial(nuevoFiltro.getCiclo(), nuevoFiltro.getIdCurso(), p.getId());
        session.setAttribute("historialDTO", historialDTO);
        List<AvanceDTO> avanceList = alumnoDAO.listarAvances(historialDTO.getIdHistorial());
        model.addAttribute("ListaAvances", avanceList);

        return "alumno/alumnocronograma";
    }

    @RequestMapping(value = "proyectoset")
    public String setProyecto(HttpSession sesion, @RequestParam Integer idProyecto) {
        sesion.setAttribute("idProyecto", idProyecto);
        return "redirect:/proyecto/ver";
    }

    @RequestMapping(value = "r_entrega")
    public String registrarEntrega(Model model, HttpSession session, Avance avances, @RequestParam Integer idavance) {

        //Obtener los datos de que entrega se va registrar, como el nombre de la entrega
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        AlumnoDTO p = alumnoDAO.get(personaDTO.getCodigo());
        AvanceDTO avance = alumnoDAO.obtenerAvance(idavance);
        model.addAttribute("avance", avance);
        model.addAttribute("personaDTO", p);
        return "alumno/alumnoentrega";
    }

    @RequestMapping(value = "inf_avance")
    public String informacionAvance(Model model, @RequestParam Integer idAvance) {

        // Conseguir los datos con un query del estado del avance, asi como la informacion del avance
        //Asi como el archivo subido por el profesor
        Avance avance = avanceDAO.obtener(idAvance);
        model.addAttribute("Avance", avance);
        return "alumno/alumnoobservaciones";
    }

}
