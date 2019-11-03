package br.com.pizzaria.core.api.presentation.dto.pedido;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.pizzaria.core.api.domain.model.Pizza;
import br.com.pizzaria.core.api.infrastructure.converter.annotation.IdReference;

public class PedidoRequestTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "{pizza.notNull}")
	@IdReference(target = Pizza.class, property = "pizza")
	private Long idPizza;

	public Long getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(Long idPizza) {
		this.idPizza = idPizza;
	}

}
