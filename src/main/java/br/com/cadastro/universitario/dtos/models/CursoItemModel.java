package br.com.cadastro.universitario.dtos.models;

import br.com.cadastro.universitario.domain.Curso;
import lombok.Getter;

@Getter
public class CursoItemModel {

	private String nome;

	private Integer cargaHoraria;

	private String periodo;

	public CursoItemModel of(Curso curso) {

		CursoItemModel model = new CursoItemModel();

		model.nome = curso.getNome();
		model.periodo = curso.getPeriodo();
		model.cargaHoraria = curso.getCargaHoraria();

		return model;
	}

}
