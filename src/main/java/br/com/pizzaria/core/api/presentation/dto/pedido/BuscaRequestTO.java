package br.com.pizzaria.core.api.presentation.dto.pedido;

import java.util.List;

import br.com.pizzaria.core.api.domain.model.Pedido;
import br.com.pizzaria.core.api.infrastructure.search.annotation.SearchEntity;
import br.com.pizzaria.core.api.infrastructure.search.annotation.SearchParam;

@SearchEntity(Pedido.class)
public class BuscaRequestTO {

	@SearchParam(property = "id")
	private List<Long> ids;


	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
