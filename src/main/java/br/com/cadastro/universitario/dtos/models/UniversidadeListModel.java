package br.com.cadastro.universitario.dtos.models;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cadastro.universitario.domain.Universidade;
import br.com.cadastro.universitario.utils.exceptions.NoContentException;
import lombok.Getter;

@Getter
public class UniversidadeListModel {

	private Long id;

	private String nome;

	private String campus;

	public static UniversidadeListModel of(Universidade universidade) {

		UniversidadeListModel model = new UniversidadeListModel();

		model.id = universidade.getId();
		model.nome = universidade.getNome();
		model.campus = universidade.getCampus();

		return model;
	}

	public static List<UniversidadeListModel> oflist(List<Universidade> universidades) {

		if (universidades.isEmpty())
			throw new NoContentException();

		return universidades.stream().map(universidade -> of(universidade)).collect(Collectors.toList());
	}

}
