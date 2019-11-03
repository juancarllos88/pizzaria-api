package br.com.pizzaria.core.api.presentation.dto.tamanho;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.pizzaria.core.api.domain.model.tamanho.Tipo;
import br.com.pizzaria.core.api.presentation.dto.shared.TempoValorResponseTO;

public class TamanhoResponseTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Tipo tipo;

	@JsonProperty("total")
	private TempoValorResponseTO tempoValor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public TempoValorResponseTO getTempoValor() {
		return tempoValor;
	}

	public void setTempoValor(TempoValorResponseTO tempoValor) {
		this.tempoValor = tempoValor;
	}

}
