package br.fatec.scrumboard.controller.dto.wrapper;

import java.util.ArrayList;
import java.util.List;

import br.fatec.scrumboard.controller.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTOWrapper {

	private List<UsuarioDTO> usuarios = new ArrayList<>();

	public static UsuarioDTOWrapper of(List<UsuarioDTO> dtoList) {
		return new UsuarioDTOWrapper(dtoList);
	}

}
