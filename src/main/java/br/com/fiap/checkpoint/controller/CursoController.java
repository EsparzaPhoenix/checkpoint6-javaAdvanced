package br.com.fiap.checkpoint.controller;

import br.com.fiap.checkpoint.model.Curso;
import br.com.fiap.checkpoint.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoService.listarCursos());
        return "curso/listar";
    }

    @GetMapping("/cursos/{id}")
    public String detalhesCurso(@PathVariable int id, Model model) {
        cursoService.obterCursoPorId(id).ifPresent(curso -> model.addAttribute("curso", curso));
        return "curso/detalhar";
    }
}
