package br.fatec.scrumboard.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import br.fatec.scrumboard.controller.dto.ProjetoDTO;
import br.fatec.scrumboard.controller.dto.UsuarioDTO;
import br.fatec.scrumboard.controller.dto.wrapper.ProjetoDTOListWrapper;
import br.fatec.scrumboard.controller.dto.wrapper.UsuarioDTOWrapper;
import br.fatec.scrumboard.controller.form.UsuarioForm;
import br.fatec.scrumboard.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder) {
		UsuarioDTO dto = service.create(form);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@Transactional
	public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioForm form, @PathVariable(name = "id") Long id) {
		UsuarioDTO dto = service.update(form, id);
		return ResponseEntity.ok(dto);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<UsuarioDTO> read(@PathVariable(name = "id") Long id) {
		UsuarioDTO dto = service.read(id);
		return ResponseEntity.ok(dto);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public ResponseEntity<UsuarioDTO> login(@RequestParam("email") String email, @RequestParam("senha") String senha) {
		Optional<UsuarioDTO> dto = service.findByCredentials(email, senha);
		if (dto.isPresent()) {
			return ResponseEntity.ok(dto.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}/alocacao")
	public ResponseEntity<ProjetoDTOListWrapper> getProjetosUsuarioAlocacao(@PathVariable(name = "id") Long idUsuario) {
		List<ProjetoDTO> alocacao = service.findAlocacao(idUsuario);
		return ResponseEntity.ok(ProjetoDTOListWrapper.of(alocacao));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}/gerencia")
	public ResponseEntity<ProjetoDTOListWrapper> getProjetosUsuarioGerencia(@PathVariable(name = "id") Long idUsuario) {
		List<ProjetoDTO> gerencia = service.findGerencia(idUsuario);
		return ResponseEntity.ok(ProjetoDTOListWrapper.of(gerencia));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/pesquisa")
	public ResponseEntity<UsuarioDTOWrapper> pesquisaUsuario(@RequestParam("param") String param) {

		List<UsuarioDTO> result = service.pesquisaUsuarios(param);
		return ResponseEntity.ok(UsuarioDTOWrapper.of(result));

	}

}
