package br.com.pizzaria.core.api.presentation.dto.pizza;

import java.io.Serializable;
import java.util.List;

import br.com.pizzaria.core.api.domain.model.Adicional;
import br.com.pizzaria.core.api.infrastructure.converter.annotation.IdReference;

public class PizzaAdicionaisRequestTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@IdReference(target = Adicional.class, property = "adicionais")
	private List<Long> idsAdicionais;


	public List<Long> getIdsAdicionais() {
		return idsAdicionais;
	}


	public void setIdsAdicionais(List<Long> idsAdicionais) {
		this.idsAdicionais = idsAdicionais;
	}



	
	

}
