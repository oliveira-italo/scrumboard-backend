package br.fatec.scrumboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.scrumboard.controller.dto.ProjetoDTO;
import br.fatec.scrumboard.controller.form.ProjetoForm;
import br.fatec.scrumboard.model.Projeto;
import br.fatec.scrumboard.repository.ProjetoRepository;
import br.fatec.scrumboard.repository.UsuarioRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public ProjetoDTO create(ProjetoForm form) {
		return ProjetoDTO.fromProjeto(repository.save(form.toProjeto(usuarioRepository)));
	}

	public ProjetoDTO update(ProjetoForm form, Long id) {
		Projeto Projeto = repository.getOne(id);
		form.update(Projeto, usuarioRepository);
		return ProjetoDTO.fromProjeto(Projeto);
	}

	public ProjetoDTO read(Long id) {
		return ProjetoDTO.fromProjeto(repository.getOne(id));
	}

}
