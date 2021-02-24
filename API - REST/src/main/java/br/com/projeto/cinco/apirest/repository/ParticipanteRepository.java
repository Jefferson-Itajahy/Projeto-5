package br.com.projeto.cinco.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.cinco.apirest.models.entity.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>{
	
	Participante findById(long Id);
	 

}
