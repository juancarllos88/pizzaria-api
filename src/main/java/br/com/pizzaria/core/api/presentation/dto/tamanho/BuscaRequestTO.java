package br.com.pizzaria.core.api.presentation.dto.tamanho;

import java.io.Serializable;
import java.util.List;

import br.com.pizzaria.core.api.domain.model.tamanho.Tamanho;
import br.com.pizzaria.core.api.domain.model.tamanho.Tipo;
import br.com.pizzaria.core.api.infrastructure.search.Operation;
import br.com.pizzaria.core.api.infrastructure.search.annotation.SearchEntity;
import br.com.pizzaria.core.api.infrastructure.search.annotation.SearchParam;

@SearchEntity(Tamanho.class)
public class BuscaRequestTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SearchParam(property = "id")
	private List<Long> ids;

	@SearchParam(property = "tipo", operation = Operation.ILIKE)
	private Tipo tipo;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
