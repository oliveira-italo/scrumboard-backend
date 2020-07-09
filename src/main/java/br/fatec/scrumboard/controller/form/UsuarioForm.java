package br.fatec.scrumboard.controller.form;

import br.fatec.scrumboard.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioForm {

	private String nome;
	private String email;
	private String senha;

	public Usuario toUsuario() {
		return Usuario.builder().email(email).senha(senha).nome(nome).build();
	}

	public void update(Usuario usuario) {
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setNome(nome);
	}

}
