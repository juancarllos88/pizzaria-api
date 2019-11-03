package br.com.pizzaria.core.api.presentation.dto.sabor;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SaborRequestTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "{nome.notNull}")
	@NotEmpty(message = "{nome.notEmpty}")
	private String nome;

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
