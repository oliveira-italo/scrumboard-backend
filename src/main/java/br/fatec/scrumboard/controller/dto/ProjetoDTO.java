package br.fatec.scrumboard.controller.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.fatec.scrumboard.enuns.StatusProjeto;
import br.fatec.scrumboard.model.Projeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {

	private Long id;
	private String nome;
	private String descricao;
	private LocalDate inicioPrevisto;
	private LocalDate fimPrevisto;
	private LocalDate inicioEfetivo;
	private LocalDate fimEfetivo;
	private UsuarioDTO gerente;
	private StatusProjeto status;

	@Builder.Default
	private List<UsuarioDTO> usuariosAlocados = new ArrayList<>();

	public static ProjetoDTO fromProjeto(Projeto projeto) {
		return ProjetoDTO.builder()

				.id(projeto.getId())

				.nome(projeto.getNome())

				.descricao(projeto.getDescricao())

				.inicioPrevisto(projeto.getInicioPrevisto())

				.fimPrevisto(projeto.getFimPrevisto())

				.inicioEfetivo(projeto.getInicioEfetivo())

				.fimEfetivo(projeto.getFimEfetivo())

				.gerente(UsuarioDTO.fromUsuario(projeto.getGerente()))

				.status(projeto.getStatus())

				.usuariosAlocados(projeto.getUsuariosAlocados().stream().map(usuario -> UsuarioDTO.fromUsuario(usuario))
						.collect(Collectors.toList()))

				.build();

	}

}
