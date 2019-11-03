package br.com.pizzaria.core.api.presentation.dto.adicional;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.pizzaria.core.api.presentation.dto.shared.TempoValorResponseTO;

public class AdicionalResponseTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	@JsonProperty("total")
	private TempoValorResponseTO tempoValor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TempoValorResponseTO getTempoValor() {
		return tempoValor;
	}

	public void setTempoValor(TempoValorResponseTO tempoValor) {
		this.tempoValor = tempoValor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
