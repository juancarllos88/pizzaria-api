package br.com.pizzaria.core.api.domain.shared;

import java.math.BigDecimal;

import javax.jdo.annotations.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TempoValor {

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "tempo")
	private Integer tempo;

	public TempoValor() {
	}

	public TempoValor(BigDecimal valor, Integer tempo) {
		this.valor = valor;
		this.tempo = tempo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

}
