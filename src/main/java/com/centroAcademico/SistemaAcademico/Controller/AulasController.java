package com.centroAcademico.SistemaAcademico.Controller;

import com.centroAcademico.SistemaAcademico.Domain.Aulas;
import com.centroAcademico.SistemaAcademico.Service.AulasService;
import com.centroAcademico.SistemaAcademico.Service.AulasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/aulas")
public class AulasController {
    
    @Autowired
    private AulasService aulasService;
    
   

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = aulasService.getAulas();
        model.addAttribute("aulas", lista);
        model.addAttribute("totalAulas", lista.size());
        
        return "/aulas/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Aulas aulas) {

        aulasService.save(aulas);
        return "redirect:/aulas/listado";
    }

    @GetMapping("/eliminar/{idAula}")
    public String eliminar(Aulas aulas) {
        aulasService.delete(aulas);
        return "redirect:/aulas/listado";
    }

    @GetMapping("/modificar/{idAula}")
    public String modificar(Aulas aula, Model model) {
        aula = aulasService.getAulas(aula);
        model.addAttribute("aula", aula);
        
        return "/aulas/modifica";
    }
}
