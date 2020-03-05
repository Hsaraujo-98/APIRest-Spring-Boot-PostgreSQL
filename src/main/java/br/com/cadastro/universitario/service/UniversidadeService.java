package br.com.cadastro.universitario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.universitario.domain.Universidade;
import br.com.cadastro.universitario.dtos.commands.UniversidadeInsertCommand;
import br.com.cadastro.universitario.repositories.UniversidadeRepository;

@Service
public class UniversidadeService {

	@Autowired
	private UniversidadeRepository universidadeRepository;

	public Universidade salvar(UniversidadeInsertCommand command) {

		Universidade universidade = new Universidade(command);

		return universidadeRepository.save(universidade);
	}

	public List<Universidade> listar() {

		return universidadeRepository.findAll();
	}

	public Universidade consultar(long id) {

		return universidadeRepository.findById(id);
	}

	public void deletar(long id) {

		Universidade universidade = consultar(id);

		universidadeRepository.delete(universidade);
	}

}
