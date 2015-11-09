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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pucp.sw2.horario1.vtesis.dao.AsesorDao;
import pucp.sw2.horario1.vtesis.dao.AvanceDAO;
import pucp.sw2.horario1.vtesis.dao.PersonaDAO;
import pucp.sw2.horario1.vtesis.dto.AvanceDTO;
import pucp.sw2.horario1.vtesis.dto.CicloDTO;
import pucp.sw2.horario1.vtesis.dto.PersonaDTO;
import pucp.sw2.horario1.vtesis.modelos.Avance;
import pucp.sw2.horario1.vtesis.modelos.Persona;
import pucp.sw2.horario1.vtesis.ui.AlumnoFiltro;
import pucp.sw2.horario1.vtesis.ui.AvanceFiltro;


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
    
    
    @RequestMapping(value = "/asesor/profile")
    public String profileAsesor(Model model, HttpSession session){
        

        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        CicloDTO ciclo = new CicloDTO();
        
        model.addAttribute("persona", personaDTO);
        model.addAttribute("codigo", personaDTO.getCodigo());  
        model.addAttribute("nombres", personaDTO.getNombres());  
        model.addAttribute("apellidos", personaDTO.getApellidos());  
        model.addAttribute("email", personaDTO.getEmail());  
        model.addAttribute("ciclo", ciclo);
        
        model.addAttribute("lstCiclos", asesorDao.listarCiclos(personaDTO.getIdPersona()));   
        
        return "/asesor/profile";
    }
    
    @RequestMapping(value = "/asesor/listar_alumnos")
    public String listarAlumnos(Model model, HttpSession session ,@RequestParam(required = false) String ciclo){
        
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        
        AlumnoFiltro filtros = new AlumnoFiltro();
        List<PersonaDTO> lstAlumnos;
        
        filtros.setCiclo(ciclo);
        
        lstAlumnos = asesorDao.busqueda(filtros,personaDTO.getIdPersona());
        
        model.addAttribute("persona", personaDTO);
        model.addAttribute("filtros", filtros);
        model.addAttribute("lstCiclos",asesorDao.listarCiclos(personaDTO.getIdPersona()));
        model.addAttribute("lstAlumnos", lstAlumnos);
        
        
        //model.addAttribute("lstAlumnos",asesorDao.listarAlumnos());
        return "asesor/lista_alumnos";
    }
    
    @RequestMapping(value = {"/asesor/vista_de_entregables"}, method = RequestMethod.GET)
    public String vistaEntregable(Model model,HttpSession session ,@RequestParam(value = "codigo", required = true) String codigo){
        
        AvanceFiltro filtro = new AvanceFiltro();
        List<AvanceDTO> lstAvances;
        
        filtro.setCodigo(codigo);
        
        lstAvances = asesorDao.listarAvances(filtro);
        
        model.addAttribute("filtro", filtro);
        model.addAttribute("lstAvances", lstAvances);
        
        return "asesor/vista_de_entregables";
       
    }
    
    @RequestMapping(value = "registro")
    public String Registrar(Model model){
       
        return "....";
    }
    
    @RequestMapping(value = "editarFechas")
    public String registrarFechas(Model model, @RequestParam Integer idAvance){
       Avance avance = avanceDAO.obtener(idAvance); 
       model.addAttribute("avance", avance);
       return "asesor/editarFechas";
    }
    

    
    
    
}
