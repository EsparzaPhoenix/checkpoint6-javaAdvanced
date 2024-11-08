package br.com.fiap.checkpoint.repository;

import br.com.fiap.checkpoint.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

    List<Matricula> findByCursoId(int cursoId);

    List<Matricula> findByUsuarioId(Long usuarioId);

}
