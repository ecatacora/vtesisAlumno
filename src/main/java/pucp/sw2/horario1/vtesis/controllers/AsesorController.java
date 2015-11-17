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
import org.springframework.web.bind.annotation.SessionAttributes;
import pucp.sw2.horario1.vtesis.dao.AsesorDao;
import pucp.sw2.horario1.vtesis.dao.AvanceDAO;
import pucp.sw2.horario1.vtesis.dto.AlumnoDTO;
import pucp.sw2.horario1.vtesis.dto.AvanceDTO;
import pucp.sw2.horario1.vtesis.dto.CicloDTO;
import pucp.sw2.horario1.vtesis.dto.PersonaDTO;
import pucp.sw2.horario1.vtesis.modelos.Avance;
import pucp.sw2.horario1.vtesis.ui.AlumnoFiltro;


/**
 *
 * @author josesuk
 */

@SessionAttributes("alumnoDTO")
@Controller(value = "asesorController")

public class AsesorController {
    
    @Autowired
    AsesorDao asesorDao;
    @Autowired
    AvanceDAO avanceDAO;
    
    
    /* se configura un log para este controlador*/
    private static final Logger log = Logger.getLogger("asesorController");
    
    //Lisseth
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
        
        return "asesor/profile";
    }
    
    //Lisseth
    @RequestMapping(value = "/asesor/listar_alumnos")
    public String listarAlumnos(Model model, HttpSession session ,@RequestParam(required = false) String ciclo){
        
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        
        //Seteando ciclo del asesor
        personaDTO.setCiclo(ciclo);
        
        List<AlumnoDTO> lstAlumnos = asesorDao.busqueda(ciclo,personaDTO.getIdPersona());
        
        model.addAttribute("persona", personaDTO);
        model.addAttribute("lstAlumnos", lstAlumnos);
        
        
        //model.addAttribute("lstAlumnos",asesorDao.listarAlumnos());
        return "asesor/lista_alumnos";
    }
    
    //Lisseth (+ Session Alumno)
    @RequestMapping(value = {"/asesor/vista_de_entregables"}, method = RequestMethod.GET)
    public String vistaEntregable(Model model,HttpSession session ,@RequestParam(value = "codigo", required = true) String codigo){
        
        
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        
        List<AvanceDTO> lstAvances = asesorDao.listarAvances(codigo);
        
        AlumnoDTO alumno = asesorDao.getInfoAlumno(codigo);
        
        //Session Alumno
        model.addAttribute("alumnoDTO", alumno);
        
        //System.out.println(personaDTO);
        //
        model.addAttribute("ciclo", personaDTO.getCiclo());
        
        model.addAttribute("nombre", alumno.getNombres());
        model.addAttribute("apellido", alumno.getApellidos());
        model.addAttribute("lstAvances", lstAvances);
        
        return "asesor/vista_de_entregables";
       
    }
    
    //Lisseth
    @RequestMapping(value = {"/asesor/entrega_avance"} , method = RequestMethod.GET)
    public String entregaAvance(Model model, HttpSession session, @RequestParam(value = "id", required = true) int id){
        
        PersonaDTO asesor = (PersonaDTO) session.getAttribute("personaDTO");
        AlumnoDTO alumno = (AlumnoDTO) session.getAttribute("alumnoDTO");
        
        //EntregaFiltro idFiltro = new EntregaFiltro();
        //idFiltro.setIdAvance(id);
        
        AvanceDTO avance = asesorDao.getAvance(id);
        
        model.addAttribute("codigo", alumno.getCodigo());
        model.addAttribute("asesor", asesor);
        model.addAttribute("alumno", alumno);
        model.addAttribute("avance", avance);
        //model.addAttribute("idFiltro", idFiltro);
       
        return "asesor/inbox";
    }
    
    //Lisseth
    @RequestMapping(value = "/asesor/observaciones")
    public String agregarObs(Model model, HttpSession session){
        
        AlumnoDTO alumno = (AlumnoDTO) session.getAttribute("alumnoDTO");
        
        return "asesor/observaciones";
    }
    
    //Lisseth
    @RequestMapping(value = "/asesor/entrega_avance_asesor")
    public String RegistrarObs(Model model, HttpSession session, @RequestParam(value = "id", required = true) int id){
        
        PersonaDTO asesor = (PersonaDTO) session.getAttribute("personaDTO");
        AlumnoDTO alumno = (AlumnoDTO) session.getAttribute("alumnoDTO");
        
        AvanceDTO avance = asesorDao.getAvance(id);
        
        model.addAttribute("codigo", alumno.getCodigo());
        model.addAttribute("asesor", asesor);
        model.addAttribute("alumno", alumno);
        model.addAttribute("avance", avance);
        
        return "asesor/Entrega_avance_comentario_asesor";
    }
    
    //Lisseth
    @RequestMapping(value = "/asesor/actualizar_obs")
    public String ActualizarObs(Model model, HttpSession session){
        
        AlumnoDTO alumno = (AlumnoDTO) session.getAttribute("alumnoDTO");
        return "asesor/observaciones";
        
    }
    
       
    
    //Henry
    @RequestMapping(value = "/asesor/llenarFechas")
    public String llenarFechas(Model model, HttpSession session){
        
        Avance avance = new Avance();
        model.addAttribute("avance", avance);
        return "asesor/llenar_calendario";
    }
    
    //Henry
    @RequestMapping(value = "/asesor/registrarFechas")
    public String registrarFechas(Model model, @RequestParam Integer idAvance){
       Avance avance = avanceDAO.obtener(idAvance);
       model.addAttribute("avance", avance);
       return "redirect:/asesor/llenarFechas";
    }
    
    //Rosario
    @RequestMapping(value = "/asesor/busqueda_avanzada")
    public String busquedaAvanzada(Model model){
        PersonaDTO persona = new PersonaDTO();
        model.addAttribute("persona", persona);
       
        return "/asesor/busqueda_avanzada";
    }


    //Rosario
    @RequestMapping(value = "/asesor/resultado_busqueda")
    public String resultadoBusqueda(Model model, HttpSession session,@RequestParam(required = false) String parametro){
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        
        AlumnoFiltro filtros = new AlumnoFiltro();
        
        
        List<PersonaDTO> lstBusqueda;
        
        lstBusqueda = asesorDao.listarAlumno(personaDTO.getIdPersona(),filtros);
       
        return "/asesor/busqueda_avanzada";
    }
    
    
    
    //Henry
    @RequestMapping(value="/asesor/agregar_entrega")
    public String agregarFecha(Model model){
        AvanceDTO aavance = new AvanceDTO();
        model.addAttribute("aavance", aavance);
        return "asesor/parametros_entregable";
    }
    //Henry
    @RequestMapping(value="/asesor/editar_entrega")
    public String editarFecha(Model model){
     //   AvanceDTO eavance = Avance.obtener(id);
        AvanceDTO favance = new AvanceDTO();
        model.addAttribute("eavance", favance);
        return "asesor/parametros_entregable";
    }
}
