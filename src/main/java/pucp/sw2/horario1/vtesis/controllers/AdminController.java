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
import pucp.sw2.horario1.vtesis.dao.PersonaDAO;
import pucp.sw2.horario1.vtesis.dao.RolDAO;
import pucp.sw2.horario1.vtesis.dto.PersonaDTO;

/**
 *
 * @author josesuk
 */
@Controller(value = "adminController")

public class AdminController {
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    RolDAO rolDAO;
    
    private static final Logger log = Logger.getLogger("AdminController");
    
    @RequestMapping(value="/admin/lista")
    public String lista(Model model, HttpSession session){
        PersonaDTO persona = (PersonaDTO)session.getAttribute("personaDTO");
        List<PersonaDTO> lstpersonas = personaDAO.listarPersona();
        System.out.println(lstpersonas.size());
        model.addAttribute("persona", persona);
        model.addAttribute("lstpersonas", lstpersonas);
        return "admin/lista";
    }
    
    @RequestMapping(value="/admin/registro")
    public String registroPersona(Model model){
        PersonaDTO persona = new PersonaDTO();
        model.addAttribute("persona", persona);
        model.addAttribute("lstRol", rolDAO.listarRol());
        return "admin/registro";
    }
    
    @RequestMapping(value="/admin/edit")
    public String editarPersona(Model model, @RequestParam String codigo){
        PersonaDTO persona = personaDAO.get(codigo);
        model.addAttribute("persona", persona);
        model.addAttribute("lstRol", rolDAO.listarRol());
        return "admin/registro";
    }
    
     @RequestMapping(value = "/admin/save")
    public String grabarProyecto(PersonaDTO persona, Model model, HttpSession sesion){
        try{                                                      
            if (persona.getIdPersona()== null){                
                personaDAO.registrarPersona(persona);
                model.addAttribute("mensaje", "Persona código: "+persona.getCodigo()+" agregada!");
                model.addAttribute("nuevo", true);
            }else{
                personaDAO.update(persona);
                model.addAttribute("mensaje", "Persona código "+persona.getCodigo()+" actualizada");
                model.addAttribute("nuevo", false);
            }
            model.addAttribute("idPersona", persona.getIdPersona());
            sesion.setAttribute("idPersona",persona.getIdPersona());
            return "redirect:/admin/lista";
        }catch(Exception ex){
            log.warning(ex.getMessage());
            model.addAttribute("error", true);            
            return "redirect:/admin/registro";
        }
    }
}
