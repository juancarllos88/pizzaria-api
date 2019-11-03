package br.com.pizzaria.core.api.presentation.dto.pizza;

import java.io.Serializable;
import java.util.List;

import br.com.pizzaria.core.api.presentation.dto.adicional.AdicionalResponseTO;
import br.com.pizzaria.core.api.presentation.dto.sabor.SaborResponseTO;
import br.com.pizzaria.core.api.presentation.dto.tamanho.TamanhoResponseTO;

public class PizzaCompletaResponseTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private TamanhoResponseTO tamanho;

	private SaborResponseTO sabor;

	private List<AdicionalResponseTO> adicionais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TamanhoResponseTO getTamanho() {
		return tamanho;
	}

	public void setTamanho(TamanhoResponseTO tamanho) {
		this.tamanho = tamanho;
	}

	public SaborResponseTO getSabor() {
		return sabor;
	}

	public void setSabor(SaborResponseTO sabor) {
		this.sabor = sabor;
	}

	public List<AdicionalResponseTO> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<AdicionalResponseTO> adicionais) {
		this.adicionais = adicionais;
	}

}
