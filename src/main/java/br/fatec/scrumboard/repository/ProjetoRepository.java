package br.fatec.scrumboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.fatec.scrumboard.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	@Query("SELECT p FROM projeto p JOIN p.usuariosAlocados u WHERE u.id = :id ORDER BY p.id DESC")
	public List<Projeto> findAlocacao(@Param("id") Long idUsuario);
	
	@Query("SELECT p FROM projeto p WHERE p.gerente.id = :id ORDER BY p.id DESC")
	public List<Projeto> findGerencia(@Param("id") Long idUsuario);

}
