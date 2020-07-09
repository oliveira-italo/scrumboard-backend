package br.fatec.scrumboard.controller.form;

import java.util.Objects;

import br.fatec.scrumboard.enuns.StatusTarefa;
import br.fatec.scrumboard.model.Tarefa;
import br.fatec.scrumboard.repository.SprintRepository;
import br.fatec.scrumboard.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaForm {

	private String nome;
	private String descricao;
	private Integer duracaoPrevistaEmHoras;
	private Long sprintId;
	private Long usuarioId;
	private StatusTarefa status;

	public Tarefa toTarefa(SprintRepository sprintRepository, UsuarioRepository usuarioRepository) {
		return Tarefa.builder().nome(nome).descricao(descricao).duracaoPrevistaEmHoras(duracaoPrevistaEmHoras)
				.sprint(Objects.isNull(sprintId) ? null : sprintRepository.getOne(sprintId))
				.usuario(Objects.isNull(usuarioId) ? null : usuarioRepository.getOne(usuarioId)).status(status).build();
	}

	public void update(Tarefa tarefa, SprintRepository sprintRepository, UsuarioRepository usuarioRepository) {
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		tarefa.setDuracaoPrevistaEmHoras(duracaoPrevistaEmHoras);
		tarefa.setSprint(Objects.isNull(sprintId) ? null : sprintRepository.getOne(sprintId));
		tarefa.setUsuario(Objects.isNull(usuarioId) ? null : usuarioRepository.getOne(usuarioId));
		tarefa.setStatus(status);
	}

}
