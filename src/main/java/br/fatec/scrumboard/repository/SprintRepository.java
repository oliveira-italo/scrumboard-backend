package br.fatec.scrumboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.fatec.scrumboard.model.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

	/**
	 * 
	 * @param idProjeto
	 * @return
	 */
	@Query("SELECT s FROM sprint s WHERE s.projeto.id = :idProjeto ORDER BY s.id DESC")
	public List<Sprint> findByProjeto(@Param("idProjeto") Long idProjeto);

}
