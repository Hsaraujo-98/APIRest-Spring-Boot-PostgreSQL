package br.com.cadastro.universitario.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.universitario.domain.Universidade;
import br.com.cadastro.universitario.dtos.commands.UniversidadeInsertCommand;
import br.com.cadastro.universitario.service.UniversidadeService;

@RestController
@RequestMapping("/universidades")
public class UniversidadeController {

	@Autowired
	private UniversidadeService universidadeService;

	@PostMapping()
	public ResponseEntity<?> cadastrarUniversidade(@RequestBody @Valid UniversidadeInsertCommand command) {

		Universidade universidade = universidadeService.salvar(command);

		return ResponseEntity.ok(universidade);
	}

	@GetMapping()
	public ResponseEntity<?> listarUniversidade() {

		List<Universidade> universidade = universidadeService.listar();

		return ResponseEntity.ok(universidade);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarUniversidade(@PathVariable(name = "id") long id) {

		universidadeService.deletar(id);

		return ResponseEntity.ok().build();
	}

}
