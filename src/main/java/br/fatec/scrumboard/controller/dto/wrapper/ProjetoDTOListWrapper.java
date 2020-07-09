package br.fatec.scrumboard.controller.dto.wrapper;

import java.util.ArrayList;
import java.util.List;

import br.fatec.scrumboard.controller.dto.ProjetoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjetoDTOListWrapper {

	private List<ProjetoDTO> projetos = new ArrayList<>();

	public static ProjetoDTOListWrapper of(List<ProjetoDTO> dtos) {
		ProjetoDTOListWrapper wrapper = new ProjetoDTOListWrapper();
		wrapper.getProjetos().addAll(dtos);
		return wrapper;
	}

}
