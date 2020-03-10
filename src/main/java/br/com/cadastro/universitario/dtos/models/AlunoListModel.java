package br.com.cadastro.universitario.dtos.models;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cadastro.universitario.domain.Aluno;
import br.com.cadastro.universitario.utils.exceptions.NoContentException;
import lombok.Getter;

@Getter
public class AlunoListModel {

	private Long id;

	private String nome;

	private String email;

	public static AlunoListModel of(Aluno aluno) {

		AlunoListModel model = new AlunoListModel();

		model.id = aluno.getId();
		model.nome = aluno.getNome();
		model.email = aluno.getEmail();

		return model;
	}

	public static List<AlunoListModel> ofList(List<Aluno> alunos) {

		if (alunos.isEmpty())
			throw new NoContentException();

		return alunos.stream().map(aluno -> of(aluno)).collect(Collectors.toList());
	}

}
