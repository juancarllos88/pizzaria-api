package br.com.pizzaria.core.api.presentation.dto.pedido;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.pizzaria.core.api.presentation.dto.adicional.AdicionalMinResponseTO;
import br.com.pizzaria.core.api.presentation.dto.sabor.SaborMinResponseTO;
import br.com.pizzaria.core.api.presentation.dto.shared.TempoValorResponseTO;
import br.com.pizzaria.core.api.presentation.dto.tamanho.TamanhoMinResponseTO;

public class PedidoDetalhadoResponseTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("pedido")
	private Long id;

	@JsonProperty("tamanho")
	private TamanhoMinResponseTO pizzaTamanho;

	@JsonProperty("sabor")
	private SaborMinResponseTO pizzaSabor;

	@JsonProperty("adicionais")
	private List<AdicionalMinResponseTO> pizzaAdicionais;

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

	public TamanhoMinResponseTO getPizzaTamanho() {
		return pizzaTamanho;
	}

	public void setPizzaTamanho(TamanhoMinResponseTO pizzaTamanho) {
		this.pizzaTamanho = pizzaTamanho;
	}

	public SaborMinResponseTO getPizzaSabor() {
		return pizzaSabor;
	}

	public void setPizzaSabor(SaborMinResponseTO pizzaSabor) {
		this.pizzaSabor = pizzaSabor;
	}

	public List<AdicionalMinResponseTO> getPizzaAdicionais() {
		return pizzaAdicionais;
	}

	public void setPizzaAdicionais(List<AdicionalMinResponseTO> pizzaAdicionais) {
		this.pizzaAdicionais = pizzaAdicionais;
	}

}
