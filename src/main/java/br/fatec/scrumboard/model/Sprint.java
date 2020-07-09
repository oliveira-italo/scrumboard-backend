package br.fatec.scrumboard.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity(name = "sprint")
@Table(name = "sb_spr_sprint")
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "spr_id")
	private Long id;

	@Column(name = "spr_nome")
	private Integer ordem;

	@Column(name = "spr_inicio")
	private LocalDate inicio;

	@Column(name = "spr_fim")
	private LocalDate fim;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "spr_fk_projeto")
	private Projeto projeto;

}
