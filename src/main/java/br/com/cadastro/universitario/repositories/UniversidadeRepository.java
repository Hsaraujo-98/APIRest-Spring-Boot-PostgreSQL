package br.com.cadastro.universitario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.universitario.domain.Universidade;

public interface UniversidadeRepository extends JpaRepository<Universidade, Long> {

	Universidade findById(long id);

}
