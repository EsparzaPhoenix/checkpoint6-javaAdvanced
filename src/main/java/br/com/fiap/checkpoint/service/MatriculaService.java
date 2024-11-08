package br.com.fiap.checkpoint.service;

import br.com.fiap.checkpoint.model.Matricula;
import br.com.fiap.checkpoint.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Matricula> listarMatriculasPorCurso(int cursoId) {
        return matriculaRepository.findByCursoId(cursoId);
    }

    public List<Matricula> listarCursosPorUsuario(Long usuarioId) {
        return matriculaRepository.findByUsuarioId(usuarioId);
    }
}
