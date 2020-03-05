package br.com.cadastro.universitario.dtos.models;

import br.com.cadastro.universitario.domain.Aluno;
import lombok.Getter;

@Getter
public class AlunoItemModel {

	private String nome;

	private String email;

	public static AlunoItemModel of(Aluno aluno) {

		AlunoItemModel model = new AlunoItemModel();

		model.nome = aluno.getNome();
		model.email = aluno.getEmail();

		return model;
	}
}
