/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.horario1.vtesis.controllers;

/**
 *
 * @author Hiroshi
 */
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pucp.sw2.horario1.vtesis.dao.PersonaDAO;
import pucp.sw2.horario1.vtesis.dto.PersonaDTO;

@Controller
@SessionAttributes("personaDTO")
public class LoginController {

    @Autowired
    private PersonaDAO personaDAO;

    @RequestMapping(value = {"/login.do", "/"}, method = RequestMethod.GET)
    public String showLogin(HttpSession session) {
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        if (personaDTO != null) {
            if (personaDTO.getIdRol() == 1) {
                return "redirect:/admin/lista";
            } else if (personaDTO.getIdRol() == 2) {
                return "/asesor/profile";
            } else {
                return "/alumno/profile";
            }
        } else {
            return "login";
        }
    }

    @RequestMapping(value = {"/home.do"}, method = RequestMethod.GET)
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String codigo = auth.getName();
        PersonaDTO persona = personaDAO.get(codigo);
        model.addAttribute("personaDTO", persona);
        System.out.println("entro rol " + persona.getIdRol());
        if (persona.getIdRol() == 1) {
            return "redirect:/admin/lista";
        } else if (persona.getIdRol() == 2) {
            return "redirect:/asesor/profile";
        } else {
            return "redirect:/alumno/profile";
        }
    }

    @RequestMapping(value = {"/accessdenied.do"}, method = RequestMethod.GET)
    public String denied() {
        return "/denied";
    }
}
