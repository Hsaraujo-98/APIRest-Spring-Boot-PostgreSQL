package br.com.cadastro.universitario.dtos.models;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cadastro.universitario.domain.Curso;
import br.com.cadastro.universitario.utils.exceptions.NoContentException;
import lombok.Getter;

@Getter
public class CursoListModel {

	private Long id;

	private String nome;

	private String periodo;

	public static CursoListModel of(Curso curso) {

		CursoListModel model = new CursoListModel();

		model.id = curso.getId();
		model.nome = curso.getNome();
		model.periodo = curso.getPeriodo();

		return model;
	}

	public static List<CursoListModel> ofList(List<Curso> cursos) {

		if (cursos.isEmpty())
			throw new NoContentException();

		return cursos.stream().map(curso -> of(curso)).collect(Collectors.toList());
	}

}
