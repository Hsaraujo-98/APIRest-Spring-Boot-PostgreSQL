package br.com.cadastro.universitario.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.cadastro.universitario.dtos.commands.AlunoInsertCommand;
import lombok.Getter;

@Entity
@Getter
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String email;

	private String senha;

	// private Long idCurso;

	protected Aluno() {

	}

	public Aluno(AlunoInsertCommand command) {

		this.nome = command.getNome();
		this.email = command.getEmail();
		this.senha = command.getSenha();
		// this.idCurso = command.getIdCurso();
	}

	public static Aluno cadastrar(AlunoInsertCommand command) {

		return new Aluno(command);
	}

}
