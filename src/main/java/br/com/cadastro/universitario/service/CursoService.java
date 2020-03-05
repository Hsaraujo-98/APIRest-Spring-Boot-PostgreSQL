package br.com.cadastro.universitario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.universitario.domain.Curso;
import br.com.cadastro.universitario.dtos.commands.CursoInsertCommand;
import br.com.cadastro.universitario.dtos.models.CursoListModel;
import br.com.cadastro.universitario.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepositpory;

	public Curso salvar(CursoInsertCommand command) {

		Curso curso = new Curso(command);

		return cursoRepositpory.save(curso);
	}

	public List<Curso> listar(CursoListModel model) {

		return cursoRepositpory.findAll();
	}

	public Curso consultar(long id) {

		return cursoRepositpory.findById(id);
	}

	public void deletar(long id) {

		Curso curso = consultar(id);

		cursoRepositpory.delete(curso);
	}
}
