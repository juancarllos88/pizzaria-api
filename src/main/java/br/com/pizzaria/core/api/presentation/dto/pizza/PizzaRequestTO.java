package br.com.pizzaria.core.api.presentation.dto.pizza;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.pizzaria.core.api.domain.model.Sabor;
import br.com.pizzaria.core.api.domain.model.tamanho.Tamanho;
import br.com.pizzaria.core.api.infrastructure.converter.annotation.IdReference;

public class PizzaRequestTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{quantidade.notNull}")
	@Max(value= 1, message = "{quantidade.MaxMin}")
	@Min(value= 1, message = "{quantidade.MaxMin}")
	private Integer quantidade;

	@NotNull(message = "{tamanho.notNull}")
	@IdReference(target = Tamanho.class, property = "tamanho")
	private Long idTamanho;

	@NotNull(message = "{sabor.notNull}")
	@IdReference(target = Sabor.class, property = "sabor")
	private Long idSabor;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdTamanho() {
		return idTamanho;
	}

	public void setIdTamanho(Long idTamanho) {
		this.idTamanho = idTamanho;
	}

	public Long getIdSabor() {
		return idSabor;
	}

	public void setIdSabor(Long idSabor) {
		this.idSabor = idSabor;
	}

	
	

}
