package br.fatec.scrumboard.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.fatec.scrumboard.enuns.StatusProjeto;
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
@Entity(name = "projeto")
@Table(name = "sb_prj_projeto")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prj_id")
	private Long id;

	@Column(name = "prj_nome")
	private String nome;

	@Column(name = "prj_descricao")
	private String descricao;

	@Column(name = "prj_inicio_previsto")
	private LocalDate inicioPrevisto;

	@Column(name = "prj_fim_previsto")
	private LocalDate fimPrevisto;

	@Column(name = "prj_inicio_efetivo")
	private LocalDate inicioEfetivo;

	@Column(name = "prj_fim_efetivo")
	private LocalDate fimEfetivo;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "prj_fk_gerente")
	private Usuario gerente;

	@Column(name = "prj_status")
	@Enumerated(EnumType.STRING)
	private StatusProjeto status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "sb_usr_prj", joinColumns = @JoinColumn(name = "pk_prj_id"), inverseJoinColumns = @JoinColumn(name = "pk_usr_id"))
	@Builder.Default
	private List<Usuario> usuariosAlocados = new ArrayList<>();

}
