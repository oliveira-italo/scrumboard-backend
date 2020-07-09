package br.fatec.scrumboard.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.scrumboard.controller.dto.TarefaDTO;
import br.fatec.scrumboard.controller.form.TarefaForm;
import br.fatec.scrumboard.model.Tarefa;
import br.fatec.scrumboard.repository.SprintRepository;
import br.fatec.scrumboard.repository.TarefaRepository;
import br.fatec.scrumboard.repository.UsuarioRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;

	@Autowired
	private SprintRepository sprintRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public TarefaDTO create(TarefaForm form) {
		return TarefaDTO.fromTarefa(repository.save(form.toTarefa(sprintRepository, usuarioRepository)));
	}

	public TarefaDTO update(TarefaForm form, Long id) {
		Tarefa tarefa = repository.getOne(id);
		form.update(tarefa, sprintRepository, usuarioRepository);
		return TarefaDTO.fromTarefa(tarefa);
	}

	public TarefaDTO read(Long id) {
		return TarefaDTO.fromTarefa(repository.getOne(id));
	}

	public List<TarefaDTO> findBySprint(Long idSprint) {
		List<Tarefa> tarefas = repository.findBySprint(idSprint);
		return tarefas.stream().map(tarefa -> TarefaDTO.fromTarefa(tarefa)).collect(Collectors.toList());
	}

}
