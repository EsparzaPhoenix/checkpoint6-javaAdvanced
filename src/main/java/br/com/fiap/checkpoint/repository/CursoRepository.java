package br.com.fiap.checkpoint.repository;

import br.com.fiap.checkpoint.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
