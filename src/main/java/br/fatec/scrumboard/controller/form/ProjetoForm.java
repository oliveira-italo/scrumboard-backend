package br.fatec.scrumboard.controller.form;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.fatec.scrumboard.enuns.StatusProjeto;
import br.fatec.scrumboard.model.Projeto;
import br.fatec.scrumboard.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjetoForm {

	private String nome;
	private String descricao;
	private LocalDate inicioPrevisto;
	private LocalDate fimPrevisto;
	private LocalDate inicioEfetivo;
	private LocalDate fimEfetivo;
	private Long gerenteId;
	private StatusProjeto status;
	private List<Long> usuariosAlocadosIds = new ArrayList<>();

	public Projeto toProjeto(UsuarioRepository usuarioRepository) {
		return Projeto.builder().nome(nome).descricao(descricao).inicioPrevisto(inicioPrevisto).fimPrevisto(fimPrevisto)
				.inicioEfetivo(inicioEfetivo).fimEfetivo(fimEfetivo).gerente(usuarioRepository.getOne(gerenteId))
				.status(status).usuariosAlocados(usuariosAlocadosIds.stream().map(id -> usuarioRepository.getOne(id))
						.collect(Collectors.toList()))
				.build();
	}

	public void update(Projeto projeto, UsuarioRepository usuarioRepository) {
		projeto.setNome(nome);
		projeto.setDescricao(descricao);
		projeto.setInicioPrevisto(inicioPrevisto);
		projeto.setFimPrevisto(fimPrevisto);
		projeto.setInicioEfetivo(inicioEfetivo);
		projeto.setFimEfetivo(fimEfetivo);
		projeto.setStatus(status);
		projeto.setUsuariosAlocados(
				usuariosAlocadosIds.stream().map(id -> usuarioRepository.getOne(id)).collect(Collectors.toList()));
	}

}
