package br.com.projeto.cinco.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.cinco.apirest.models.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	Turma findById(long Id);

}
