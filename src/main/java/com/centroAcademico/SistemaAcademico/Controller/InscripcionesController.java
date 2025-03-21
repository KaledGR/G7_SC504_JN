package com.centroAcademico.SistemaAcademico.Controller;

import com.centroAcademico.SistemaAcademico.Domain.Inscripciones;
import com.centroAcademico.SistemaAcademico.Service.EstudianteService;
import com.centroAcademico.SistemaAcademico.Service.InscripcionesService;
import com.centroAcademico.SistemaAcademico.Service.MateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/inscripciones")
public class InscripcionesController {
    
    @Autowired
    private InscripcionesService inscripcionesService;
    
    @Autowired
    private MateriasService materiasService;
    
    @Autowired
    private EstudianteService estudiantesService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = inscripcionesService.getInscripciones();
        model.addAttribute("inscripciones", lista);
        model.addAttribute("totalInscripciones", lista.size());

        var materias = materiasService.getMaterias();
        model.addAttribute("materias", materias);
        
        var estudiantes = estudiantesService.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);

        return "/inscripciones/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Inscripciones inscripciones) {

        inscripcionesService.save(inscripciones);
        return "redirect:/clases/listado";
    }

    @GetMapping("/eliminar/{idInscripciones}")
    public String eliminar(Inscripciones inscripciones) {
        inscripcionesService.delete(inscripciones);
        return "redirect:/inscripciones/listado";
    }

    @GetMapping("/modificar/{idInscripciones}")
    public String modificar(Inscripciones inscripciones, Model model) {
        inscripciones = inscripcionesService.getInscripciones(inscripciones);
        model.addAttribute("inscripciones", inscripciones);
        
        var materias = materiasService.getMaterias();
        model.addAttribute("materias", materias);
        
        var estudiantes = estudiantesService.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        
        return "/clases/modifica";
    }
    
}
