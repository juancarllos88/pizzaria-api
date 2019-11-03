package br.com.pizzaria.core.api.presentation.dto.shared;

import java.math.BigDecimal;

import javax.jdo.annotations.Column;
import javax.persistence.Embeddable;

public class TempoValorResponseTO {

	private BigDecimal valor;

	private Integer tempo;

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
