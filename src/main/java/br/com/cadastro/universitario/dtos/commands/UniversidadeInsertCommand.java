package br.com.cadastro.universitario.dtos.commands;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class UniversidadeInsertCommand {

	@NotBlank(message = "Nome da Universidade deve ser preenchido")
	private String nome;

	@NotBlank(message = "Campus deve ser preenchido")
	private String campus;

}
