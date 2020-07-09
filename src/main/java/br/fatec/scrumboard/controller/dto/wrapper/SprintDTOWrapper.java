package br.fatec.scrumboard.controller.dto.wrapper;

import java.util.ArrayList;
import java.util.List;

import br.fatec.scrumboard.controller.dto.SprintDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SprintDTOWrapper {

	private List<SprintDTO> sprints = new ArrayList<>();

	public static SprintDTOWrapper of(List<SprintDTO> sprints) {
		return new SprintDTOWrapper(sprints);
	}
}
