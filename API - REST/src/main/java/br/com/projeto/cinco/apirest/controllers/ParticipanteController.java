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

import br.com.projeto.cinco.apirest.models.entity.Participante;
import br.com.projeto.cinco.apirest.repository.ParticipanteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST --> CADASTRO DE PARTICIPANTES")
@CrossOrigin(origins="*")
public class ParticipanteController {

	@Autowired
	ParticipanteRepository participanteRepository;

	@GetMapping("/participantes")
	@ApiOperation(value="Lista participantes")
	public List<Participante> getAllParticipante() {
		return participanteRepository.findAll();

	}

	@GetMapping("participantes/{id}")
	@ApiOperation(value="Lista participante pelo ID")
	public Participante getByIdParticipante(@PathVariable(value = "id") long id) {
		return participanteRepository.findById(id);
	}
	
	@RequestMapping("/participantes")
	@ApiOperation(value="Busca participante por nome/descrição")
	public List<Participante> getByNameParticipante(Sort nome) {
		Participante participante = new Participante();
		participante.getNome();
		return participanteRepository.findAll(nome);
	}

	@PostMapping("/participantes")
	@ApiOperation(value="Salva participante")
	public Participante postParticipante(@RequestBody Participante participante) {
		return participanteRepository.save(participante);
	}

	@DeleteMapping("/participantes")
	@ApiOperation(value="Deleta participante")
	public void deleteParticipante(@RequestBody Participante participante) {
		participanteRepository.delete(participante);
	}

	@PutMapping("/participantes")
	@ApiOperation(value="Atualiza participante")
	public Participante putTurma(@RequestBody Participante participante) {
		return participanteRepository.save(participante);
	}

}
