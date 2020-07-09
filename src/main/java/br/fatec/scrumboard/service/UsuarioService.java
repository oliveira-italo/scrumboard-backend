package br.fatec.scrumboard.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.scrumboard.controller.dto.ProjetoDTO;
import br.fatec.scrumboard.controller.dto.UsuarioDTO;
import br.fatec.scrumboard.controller.form.UsuarioForm;
import br.fatec.scrumboard.model.Projeto;
import br.fatec.scrumboard.model.Usuario;
import br.fatec.scrumboard.repository.ProjetoRepository;
import br.fatec.scrumboard.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ProjetoRepository projetoRepository;

	public UsuarioDTO create(UsuarioForm form) {
		return UsuarioDTO.fromUsuario(repository.save(form.toUsuario()));
	}

	public UsuarioDTO update(UsuarioForm form, Long id) {
		Usuario usuario = repository.getOne(id);
		form.update(usuario);
		return UsuarioDTO.fromUsuario(usuario);
	}

	public UsuarioDTO read(Long id) {
		return UsuarioDTO.fromUsuario(repository.getOne(id));
	}

	public Optional<UsuarioDTO> findByCredentials(String email, String senha) {
		Optional<Usuario> usuario = repository.findByCredentials(email, senha);
		if (usuario.isPresent()) {
			return Optional.of(UsuarioDTO.fromUsuario(usuario.get()));
		} else {
			return Optional.empty();
		}
	}

	public List<ProjetoDTO> findAlocacao(Long idUsuario) {
		List<Projeto> projetos = projetoRepository.findAlocacao(idUsuario);
		return projetos.stream().map(projeto -> ProjetoDTO.fromProjeto(projeto)).collect(Collectors.toList());
	}

	public List<ProjetoDTO> findGerencia(Long idUsuario) {
		List<Projeto> projetos = projetoRepository.findGerencia(idUsuario);
		return projetos.stream().map(projeto -> ProjetoDTO.fromProjeto(projeto)).collect(Collectors.toList());
	}

	public List<UsuarioDTO> pesquisaUsuarios(String param) {
		List<Usuario> usuarios =  repository.findByNameOrEmail(param);
		return usuarios.stream().map(usuario -> UsuarioDTO.fromUsuario(usuario)).collect(Collectors.toList());
	}

}
