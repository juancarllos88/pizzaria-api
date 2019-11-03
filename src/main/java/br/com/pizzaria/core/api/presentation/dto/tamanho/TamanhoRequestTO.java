package br.com.pizzaria.core.api.presentation.dto.tamanho;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.pizzaria.core.api.domain.model.tamanho.Tipo;
import br.com.pizzaria.core.api.presentation.dto.shared.TempoValorRequestTO;

public class TamanhoRequestTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	private Tipo tipo;

	@NotNull
	@NotEmpty
	private TempoValorRequestTO tempoValor;

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public TempoValorRequestTO getTempoValor() {
		return tempoValor;
	}

	public void setTempoValor(TempoValorRequestTO tempoValor) {
		this.tempoValor = tempoValor;
	}

}
