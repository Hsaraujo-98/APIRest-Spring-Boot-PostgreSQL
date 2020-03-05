package br.com.cadastro.universitario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.universitario.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	Aluno findById(long id);

}
