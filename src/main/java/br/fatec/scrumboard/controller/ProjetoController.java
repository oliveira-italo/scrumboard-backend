package br.fatec.scrumboard.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.fatec.scrumboard.controller.dto.ProjetoDTO;
import br.fatec.scrumboard.controller.form.ProjetoForm;
import br.fatec.scrumboard.service.ProjetoService;

@RestController
@RequestMapping("projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService service;

	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ResponseEntity<ProjetoDTO> create(@RequestBody ProjetoForm form, UriComponentsBuilder uriBuilder) {
		ProjetoDTO dto = service.create(form);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@Transactional
	public ResponseEntity<ProjetoDTO> update(@RequestBody ProjetoForm form, @PathVariable(name = "id") Long id) {
		ProjetoDTO dto = service.update(form, id);
		return ResponseEntity.ok(dto);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<ProjetoDTO> read(@PathVariable(name = "id") Long id) {
		ProjetoDTO dto = service.read(id);
		return ResponseEntity.ok(dto);
	}
	
}
