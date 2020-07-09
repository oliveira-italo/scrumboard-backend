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

import br.fatec.scrumboard.controller.dto.TarefaDTO;
import br.fatec.scrumboard.controller.dto.wrapper.TarefaDTOWrapper;
import br.fatec.scrumboard.controller.form.TarefaForm;
import br.fatec.scrumboard.service.TarefaService;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

	@Autowired
	private TarefaService service;

	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ResponseEntity<TarefaDTO> create(@RequestBody TarefaForm form, UriComponentsBuilder uriBuilder) {
		TarefaDTO dto = service.create(form);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@Transactional
	public ResponseEntity<TarefaDTO> update(@RequestBody TarefaForm form, @PathVariable(name = "id") Long id) {
		TarefaDTO dto = service.update(form, id);
		return ResponseEntity.ok(dto);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<TarefaDTO> read(@PathVariable(name = "id") Long id) {
		TarefaDTO dto = service.read(id);
		return ResponseEntity.ok(dto);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/sprint")
	public ResponseEntity<TarefaDTOWrapper> findTarefasBySprint(@RequestParam("idSprint") Long idSprint) {
		List<TarefaDTO> tarefas = service.findBySprint(idSprint);
		return ResponseEntity.ok(TarefaDTOWrapper.of(tarefas));

	}

}
