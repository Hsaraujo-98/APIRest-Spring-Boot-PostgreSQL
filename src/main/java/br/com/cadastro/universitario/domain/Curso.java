package br.com.cadastro.universitario.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.cadastro.universitario.dtos.commands.CursoInsertCommand;
import lombok.Getter;

@Entity
@Getter
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Integer cargaHoraria;

	private String periodo;

	protected Curso() {

	}

	public Curso(CursoInsertCommand command) {

		this.nome = command.getNome();
		this.cargaHoraria = command.getCargaHoraria();
		this.periodo = command.getPeriodo();
	}

	public static Curso cadastrar(CursoInsertCommand command) {

		return new Curso(command);
	}
}
