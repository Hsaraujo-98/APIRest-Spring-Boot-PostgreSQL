package br.com.cadastro.universitario.dtos.commands;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class AlunoInsertCommand {

	@NotBlank(message = "Nome deve ser preenchido")
	private String nome;

	@NotBlank(message = "E-mail deve ser preenchido")
	private String email;

	@NotBlank(message = "Senha deve ser preenchida")
	private String senha;

}
