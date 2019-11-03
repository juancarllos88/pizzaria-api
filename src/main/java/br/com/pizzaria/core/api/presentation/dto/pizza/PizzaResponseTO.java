package br.com.pizzaria.core.api.presentation.dto.pizza;

import java.io.Serializable;

import br.com.pizzaria.core.api.presentation.dto.sabor.SaborResponseTO;
import br.com.pizzaria.core.api.presentation.dto.tamanho.TamanhoResponseTO;

public class PizzaResponseTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private TamanhoResponseTO tamanho;

	private SaborResponseTO sabor;

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

}
