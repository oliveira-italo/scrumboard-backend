package br.fatec.scrumboard.controller.form;

import java.time.LocalDate;

import br.fatec.scrumboard.model.Sprint;
import br.fatec.scrumboard.repository.ProjetoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SprintForm {

	private LocalDate inicio;
	private LocalDate fim;
	private Long projetoId;

	public Sprint toSprint(ProjetoRepository projetoRepository) {
		return Sprint.builder().inicio(inicio).fim(fim).projeto(projetoRepository.getOne(projetoId)).build();
	}

	public void update(Sprint sprint) {
		sprint.setInicio(inicio);
		sprint.setFim(fim);
	}

}
