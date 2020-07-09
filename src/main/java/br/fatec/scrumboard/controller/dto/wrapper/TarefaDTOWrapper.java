package br.fatec.scrumboard.controller.dto.wrapper;

import java.util.ArrayList;
import java.util.List;

import br.fatec.scrumboard.controller.dto.TarefaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTOWrapper {

	private List<TarefaDTO> tarefas = new ArrayList<>();
	
	public static TarefaDTOWrapper of(List<TarefaDTO> tarefas) {
		return new TarefaDTOWrapper(tarefas);
	}
	
}
