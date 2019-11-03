package br.com.pizzaria.core.api.presentation.dto.sabor;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaborMinResponseTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;

	@JsonProperty("tempoAdicional")
	private Integer tempo;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

}
