package br.fatec.scrumboard.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.fatec.scrumboard.controller.dto.SprintDTO;
import br.fatec.scrumboard.controller.dto.wrapper.SprintDTOWrapper;
import br.fatec.scrumboard.controller.form.SprintForm;
import br.fatec.scrumboard.service.SprintService;

@RestController
@RequestMapping("sprint")
public class SprintController {

	@Autowired
	private SprintService service;

	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ResponseEntity<SprintDTO> create(@RequestBody SprintForm form, UriComponentsBuilder uriBuilder) {
		SprintDTO dto = service.create(form);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@Transactional
	public ResponseEntity<SprintDTO> update(@RequestBody SprintForm form, @PathVariable(name = "id") Long id) {
		SprintDTO dto = service.update(form, id);
		return ResponseEntity.ok(dto);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<SprintDTO> read(@PathVariable(name = "id") Long id) {
		SprintDTO dto = service.read(id);
		return ResponseEntity.ok(dto);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/projeto")
	public ResponseEntity<SprintDTOWrapper> getSprintsByProjeto(@RequestParam("idProjeto") Long idProjeto) {
		List<SprintDTO> sprints = service.getSprintsByProjeto(idProjeto);
		return ResponseEntity.ok(SprintDTOWrapper.of(sprints));
	}

}
