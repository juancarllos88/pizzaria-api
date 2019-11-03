package br.com.pizzaria.core.api.presentation.dto.adicional;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.pizzaria.core.api.presentation.dto.shared.TempoValorResponseTO;

public class AdicionalMinResponseTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;

	@JsonProperty("total")
	private TempoValorResponseTO tempoValor;


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
