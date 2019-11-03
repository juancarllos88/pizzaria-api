package br.com.pizzaria.core.api.presentation.dto.adicional;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.pizzaria.core.api.presentation.dto.shared.TempoValorRequestTO;

public class AdicionalRequestTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "{nome.notNull}")
	@NotEmpty(message = "{nome.notEmpty}")
	private String nome;

	private TempoValorRequestTO tempoValor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TempoValorRequestTO getTempoValor() {
		return tempoValor;
	}

	public void setTempoValor(TempoValorRequestTO tempoValor) {
		this.tempoValor = tempoValor;
	}

}
