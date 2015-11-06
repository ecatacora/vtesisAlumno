/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.controllers;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pucp.sw2.horario1.vtesis.dao.AsesorDao;
import pucp.sw2.horario1.vtesis.dao.AvanceDAO;
import pucp.sw2.horario1.vtesis.dao.PersonaDAO;
import pucp.sw2.horario1.vtesis.dto.PersonaDTO;
import pucp.sw2.horario1.vtesis.modelos.Avance;

/**
 *
 * @author josesuk
 */

@Controller(value = "asesorController")

public class AsesorController {
    
    @Autowired
    AsesorDao asesorDao;
    @Autowired
    AvanceDAO avanceDAO;
    
    
    /* se configura un log para este controlador*/
    private static final Logger log = Logger.getLogger("asesorController");
    
    
    @RequestMapping(value = "asesor/profile")
    public String profileAsesor(Model model){
        
        //PersonaDTO persona = asesorDao.getInfo(id);
        //model.addAttribute("personaDatos", persona);
        return "asesor/profile";
    }
    
    @RequestMapping(value = "asesor/lista_alumnos")
    public String listarAlumnos(Model model){
        
        model.addAttribute("lstAlumnos",asesorDao.listarAlumnos());
        return "asesor/lista_alumnos";
    }
    
    @RequestMapping(value = "asesor/vistaEntregables")
    public String vistaEntregable(Model model){
        
        return "asesor/vista_de_entregables";
    }
    
    @RequestMapping(value = "asesor/registro")
    public String Registrar(Model model){
       
        return "....";
    }
    
    @RequestMapping(value = "asesor/editarFechas")
    public String registrarFechas(Model model, @RequestParam Integer idAvance){
       Avance avance = avanceDAO.obtener(idAvance); 
       model.addAttribute("avance", avance);
       return "asesor/editarFechas?idAvance=34";
    }
    
    
    
    
}
