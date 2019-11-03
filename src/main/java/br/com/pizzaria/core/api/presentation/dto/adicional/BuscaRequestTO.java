package br.com.pizzaria.core.api.presentation.dto.adicional;

import java.io.Serializable;
import java.util.List;

import br.com.pizzaria.core.api.domain.model.Adicional;
import br.com.pizzaria.core.api.infrastructure.search.Operation;
import br.com.pizzaria.core.api.infrastructure.search.annotation.SearchEntity;
import br.com.pizzaria.core.api.infrastructure.search.annotation.SearchParam;

@SearchEntity(Adicional.class)
public class BuscaRequestTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SearchParam(property = "id")
	private List<Long> ids;

	@SearchParam(property = "nome", operation = Operation.ILIKE)
	private String nome;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
