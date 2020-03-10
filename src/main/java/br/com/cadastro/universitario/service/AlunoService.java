package br.com.cadastro.universitario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.universitario.domain.Aluno;
import br.com.cadastro.universitario.dtos.commands.AlunoInsertCommand;
import br.com.cadastro.universitario.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno cadastrar(AlunoInsertCommand command) {

		Aluno aluno = Aluno.cadastrar(command);

		return alunoRepository.save(aluno);
	}

	public List<Aluno> listar() {

		return alunoRepository.findAll();
	}

	public Aluno consultar(long id) {

		return alunoRepository.findById(id);
	}

	public void deletar(long id) {

		Aluno aluno = consultar(id);

		alunoRepository.delete(aluno);
	}

}
