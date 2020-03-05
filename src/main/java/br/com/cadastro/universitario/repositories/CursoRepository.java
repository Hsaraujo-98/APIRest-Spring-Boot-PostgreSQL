package br.com.cadastro.universitario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.universitario.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findById(long id);

}
