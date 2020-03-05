package br.com.cadastro.universitario.dtos.commands;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class CursoInsertCommand {

	@NotBlank(message = "Nome do curso deve ser preenchido")
	private String nome;

	private int cargaHoraria;

	@NotBlank(message = "Nome do curso deve ser preenchido")
	private String periodo;

}
