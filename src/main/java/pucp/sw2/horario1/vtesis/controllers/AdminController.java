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
@Controller
public class AdminController {
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    RolDAO rolDAO;
    
    @RequestMapping(value="/admin/lista")
    public String lista(Model model){
        List<PersonaDTO> lstpersonas = personaDAO.listarPersona();
        model.addAttribute("lstpersonas", lstpersonas);
        return "admin/lista";
    }
    
    @RequestMapping(value="/admin/registro")
    public String registroPersona(Model model){
        PersonaDTO persona = new PersonaDTO();
        model.addAttribute("persona", persona);
        model.addAttribute("lstRol", rolDAO.listarRol());
        return "admin/registro_persona";
    }
}
