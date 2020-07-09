package br.fatec.scrumboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.fatec.scrumboard.enuns.StatusTarefa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tarefa")
@Table(name = "sb_trf_tarefa")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trf_id")
	private Long id;

	@Column(name = "trf_nome")
	private String nome;

	@Column(name = "trf_descricao")
	private String descricao;

	@Column(name = "trf_duracao_prevista")
	private Integer duracaoPrevistaEmHoras;

	@Column(name = "trf_status")
	@Enumerated(EnumType.STRING)
	private StatusTarefa status;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "trf_pk_sprint")
	private Sprint sprint;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "trf_pk_usuario")
	private Usuario usuario;

}
