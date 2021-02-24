package br.com.projeto.cinco.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.cinco.apirest.models.entity.Turma;
import br.com.projeto.cinco.apirest.repository.TurmaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST --> CADASTRO DE TURMAS")
@CrossOrigin(origins="*")
public class TurmaController {

	@Autowired
	TurmaRepository turmaRepository;

	@GetMapping("/turmas")
	@ApiOperation(value="Lista todas as turmas")
	public List<Turma> getAllTurma() {
		return turmaRepository.findAll();

	}

	@GetMapping("turmas/{id}")
	@ApiOperation(value="Lista turma pelo ID")
	public Turma getByIdTurma(@PathVariable(value = "id") long id) {
		return turmaRepository.findById(id);
	}
	
	@RequestMapping("/turmas")
	@ApiOperation(value="Busca turma por nome/descrição")
	public List<Turma> getByNameTurma(Sort descricao) {
		Turma turma = new Turma();
		turma.getDescricao();
		return turmaRepository.findAll(descricao);
	}

	@PostMapping("/turmas")
	@ApiOperation(value="Salva turma na base dados")
	public Turma postTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}

	@DeleteMapping("/turmas")
	@ApiOperation(value="Deleta a turma")
	public void deleteTurma(@RequestBody Turma turma) {
		turmaRepository.delete(turma);
	}

	@PutMapping("/turmas")
	@ApiOperation(value="Atualiza turma")
	public Turma putTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}
}
