package br.com.fiap.checkpoint.service;

import br.com.fiap.checkpoint.model.Curso;
import br.com.fiap.checkpoint.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obterCursoPorId(int id) {
        return cursoRepository.findById(id);
    }
}
