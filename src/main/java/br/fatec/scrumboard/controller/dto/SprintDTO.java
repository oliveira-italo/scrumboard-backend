package br.fatec.scrumboard.controller.dto;

import java.time.LocalDate;

import br.fatec.scrumboard.model.Sprint;
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
public class SprintDTO {

	private Long id;
	private Integer ordem;
	private String nome;
	private LocalDate inicio;
	private LocalDate fim;

	public static SprintDTO fromSprint(Sprint sprint) {
		return SprintDTO.builder()

				.id(sprint.getId())

				.ordem(sprint.getOrdem())

				.nome("Sprint " + sprint.getOrdem())

				.inicio(sprint.getInicio())

				.fim(sprint.getFim())

				.build();
	}

}
