package br.fatec.scrumboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.fatec.scrumboard.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
	/**
	 * 
	 * @param idSprint
	 * @return
	 */
	@Query("SELECT t FROM tarefa t WHERE t.sprint.id = :idSprint")
	public List<Tarefa> findBySprint(@Param("idSprint") Long idSprint);

}
