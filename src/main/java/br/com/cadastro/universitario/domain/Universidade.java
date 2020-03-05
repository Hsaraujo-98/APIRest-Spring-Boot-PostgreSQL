package br.com.cadastro.universitario.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.cadastro.universitario.dtos.commands.UniversidadeInsertCommand;
import lombok.Getter;

@Entity
@Getter
public class Universidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String campus;

	public Universidade() {

	}

	public Universidade(UniversidadeInsertCommand command) {

		this.nome = command.getNome();
		this.campus = command.getCampus();
	}

	public static Universidade cadastrar(UniversidadeInsertCommand command) {

		return new Universidade(command);
	}

}
