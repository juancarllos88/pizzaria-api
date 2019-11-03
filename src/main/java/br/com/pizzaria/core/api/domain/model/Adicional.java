package br.com.pizzaria.core.api.domain.model;

import javax.jdo.annotations.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import br.com.pizzaria.core.api.domain.shared.BaseEntity;
import br.com.pizzaria.core.api.domain.shared.TempoValor;
import br.com.pizzaria.core.api.infrastructure.persistence.hibernate.listener.AdicionalEntityListener;

@Entity
@EntityListeners(AdicionalEntityListener.class)
@Table(name = "t_adicional", schema = "pizzaria")
public class Adicional extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome")
	private String nome;

	@Embedded
	private TempoValor tempoValor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TempoValor getTempoValor() {
		return tempoValor;
	}

	public void setTempoValor(TempoValor tempoValor) {
		this.tempoValor = tempoValor;
	}

}
