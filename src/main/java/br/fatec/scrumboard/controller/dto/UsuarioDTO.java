package br.fatec.scrumboard.controller.dto;

import br.fatec.scrumboard.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String senha;

	public static UsuarioDTO fromUsuario(Usuario usuario) {
		return UsuarioDTO.builder().id(usuario.getId()).nome(usuario.getNome()).email(usuario.getEmail())
				.senha(usuario.getSenha()).build();
	}

}
