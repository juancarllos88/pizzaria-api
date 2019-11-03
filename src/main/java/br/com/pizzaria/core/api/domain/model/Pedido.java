package br.com.pizzaria.core.api.domain.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.pizzaria.core.api.domain.shared.BaseEntity;
import br.com.pizzaria.core.api.domain.shared.TempoValor;

@Entity
@Table(name = "t_pedido", schema = "pizzaria")
public class Pedido extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "id_pizza")
	private Pizza pizza;

	@Embedded
	private TempoValor tempoValor;

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public TempoValor getTempoValor() {
		return tempoValor;
	}

	public void setTempoValor(TempoValor tempoValor) {
		this.tempoValor = tempoValor;
	}
	
	
	
	

}
