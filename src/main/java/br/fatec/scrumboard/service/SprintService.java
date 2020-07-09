package br.fatec.scrumboard.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.scrumboard.controller.dto.SprintDTO;
import br.fatec.scrumboard.controller.form.SprintForm;
import br.fatec.scrumboard.model.Sprint;
import br.fatec.scrumboard.repository.ProjetoRepository;
import br.fatec.scrumboard.repository.SprintRepository;

@Service
public class SprintService {

	@Autowired
	private SprintRepository repository;

	@Autowired
	private ProjetoRepository projetoRepository;

	public SprintDTO create(SprintForm form) {

		Sprint sprint = form.toSprint(projetoRepository);
		sprint.setOrdem(calculaOrdemSprint(form.getProjetoId()));

		return SprintDTO.fromSprint(repository.save(sprint));
	}

	private Integer calculaOrdemSprint(Long idProjeto) {
		List<Sprint> list = repository.findByProjeto(idProjeto);
		if (list.isEmpty()) {
			return 1;
		}

		Sprint lastSprint = list.get(0);
		if (Objects.isNull(lastSprint.getOrdem())) {
			return 1;
		}

		return (lastSprint.getOrdem() + 1);
	}

	public SprintDTO update(SprintForm form, Long id) {
		Sprint Sprint = repository.getOne(id);
		form.update(Sprint);
		return SprintDTO.fromSprint(Sprint);
	}

	public SprintDTO read(Long id) {
		return SprintDTO.fromSprint(repository.getOne(id));
	}

	public List<SprintDTO> getSprintsByProjeto(Long idProjeto) {
		return repository.findByProjeto(idProjeto).stream().map(sprint -> SprintDTO.fromSprint(sprint))
				.collect(Collectors.toList());
	}

}
