package br.com.fiap.checkpoint.controller;

import br.com.fiap.checkpoint.model.Usuario;
import br.com.fiap.checkpoint.service.MatriculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/cursos/{cursoId}/alunos")
    public String listarAlunosPorCurso(@PathVariable int cursoId, Model model) {
        model.addAttribute("matriculas", matriculaService.listarMatriculasPorCurso(cursoId));
        return "matricula/alunos-por-curso";
    }

    @GetMapping("/matriculas/meus-cursos")
    public String listarCursosDoUsuario(Model model, @AuthenticationPrincipal Usuario usuario) {
        Long usuarioId = usuario.getId();  // Obtenha o ID do usuário logado
        model.addAttribute("matriculas", matriculaService.listarCursosPorUsuario(usuarioId));
        return "matricula/cursos-por-aluno";
    }
}
