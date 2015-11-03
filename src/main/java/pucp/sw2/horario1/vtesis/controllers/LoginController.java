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

@Controller
@SessionAttributes("employeeBean")
public class LoginController {

    @Autowired
    private PersonaDAO personaDAO;

    @RequestMapping(value = {"/login.do", "/"}, method = RequestMethod.GET)
    public String showLogin(HttpSession session) {
        EmployeeBean employeeBean = (EmployeeBean) session.getAttribute("employeeBean");
        if (employeeBean != null) {
            if (employeeBean.getRole().equalsIgnoreCase("ADMIN")) {
                return "/admin/lista";
            } else {
                return "/user/index";
            }
        } else {
            return "login";
        }
    }

    @RequestMapping(value = {"/home.do"}, method = RequestMethod.GET)
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        EmployeeBean employee = personaDAO.get(email);
        model.addAttribute("employeeBean", employee);
        if (employee.getRole().equalsIgnoreCase("ADMIN")) {
            return "/admin/lista";
        } else if(employee.getRole().equalsIgnoreCase("ASESOR")){
            return "/asesor/profile";
        }
    }
    
    @RequestMapping(value = {"/accessdenied.do"}, method = RequestMethod.GET)
    public String denied() {
        return "/denied";
    }
}