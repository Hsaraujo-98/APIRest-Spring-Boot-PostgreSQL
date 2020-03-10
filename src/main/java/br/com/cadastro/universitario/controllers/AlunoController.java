package br.com.cadastro.universitario.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.universitario.domain.Aluno;
import br.com.cadastro.universitario.dtos.commands.AlunoInsertCommand;
import br.com.cadastro.universitario.dtos.models.AlunoItemModel;
import br.com.cadastro.universitario.dtos.models.AlunoListModel;
import br.com.cadastro.universitario.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping()
	public ResponseEntity<?> cadastrarAluno(@RequestBody @Valid AlunoInsertCommand command) {

		Aluno aluno = alunoService.cadastrar(command);

		return ResponseEntity.ok(aluno);
	}

	@GetMapping()
	public ResponseEntity<?> listarAlunos() {

		List<Aluno> alunos = alunoService.listar();

		List<AlunoListModel> model = AlunoListModel.ofList(alunos);

		return ResponseEntity.ok(model);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarAluno(@PathVariable(name = "id") long id) {

		Aluno aluno = alunoService.consultar(id);

		AlunoItemModel model = new AlunoItemModel().of(aluno);

		return ResponseEntity.ok(model);
	}

}