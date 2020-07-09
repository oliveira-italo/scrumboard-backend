package br.fatec.scrumboard.controller.dto;

import java.util.Objects;

import br.fatec.scrumboard.enuns.StatusTarefa;
import br.fatec.scrumboard.model.Tarefa;
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
public class TarefaDTO {

	private Long id;
	private String nome;
	private String descricao;
	private Integer duracaoPrevistaEmHoras;
	private StatusTarefa status;
	private SprintDTO sprint;
	private UsuarioDTO usuario;

	public static TarefaDTO fromTarefa(Tarefa tarefa) {
		return TarefaDTO.builder().id(tarefa.getId()).nome(tarefa.getNome()).descricao(tarefa.getDescricao())
				.duracaoPrevistaEmHoras(tarefa.getDuracaoPrevistaEmHoras()).status(tarefa.getStatus())
				.sprint(Objects.isNull(tarefa.getSprint()) ? null : SprintDTO.fromSprint(tarefa.getSprint()))
				.usuario(Objects.isNull(tarefa.getUsuario()) ? null : UsuarioDTO.fromUsuario(tarefa.getUsuario()))
				.build();
	}
}
