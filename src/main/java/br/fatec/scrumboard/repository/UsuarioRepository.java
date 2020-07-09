package br.fatec.scrumboard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.fatec.scrumboard.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 * 
	 * @param email
	 * @param senha
	 * @return
	 */
	@Query("SELECT u FROM usuario u WHERE u.email = :email AND u.senha = :senha")
	public Optional<Usuario> findByCredentials(@Param("email") String email, @Param("senha") String senha);

	@Query("SELECT u FROM usuario u WHERE u.email LIKE %:param% OR u.nome LIKE %:param%")
	public List<Usuario> findByNameOrEmail(@Param("param") String param);

}
