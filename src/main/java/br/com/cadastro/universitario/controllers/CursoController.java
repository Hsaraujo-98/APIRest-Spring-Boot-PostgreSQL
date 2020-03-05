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

import br.com.cadastro.universitario.domain.Curso;
import br.com.cadastro.universitario.dtos.commands.CursoInsertCommand;
import br.com.cadastro.universitario.dtos.models.CursoListModel;
import br.com.cadastro.universitario.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@PostMapping()
	public ResponseEntity<?> cadastrarCurso(@RequestBody @Valid CursoInsertCommand command) {

		Curso curso = cursoService.salvar(command);

		return ResponseEntity.ok(curso);
	}

	@GetMapping()
	public ResponseEntity<?> listarCursos(CursoListModel model) {

		List<Curso> cursos = cursoService.listar(model);

		return ResponseEntity.ok(cursos);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarCurso(@PathVariable(name = "id") long id) {

		cursoService.deletar(id);

		return ResponseEntity.ok().build();
	}
}
