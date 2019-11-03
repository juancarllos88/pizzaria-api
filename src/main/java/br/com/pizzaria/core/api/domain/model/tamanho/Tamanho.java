package br.com.pizzaria.core.api.domain.model.tamanho;

import java.util.List;

import javax.jdo.annotations.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.pizzaria.core.api.domain.model.Pizza;
import br.com.pizzaria.core.api.domain.shared.BaseEntity;
import br.com.pizzaria.core.api.domain.shared.TempoValor;

@Entity
@Table(name = "t_tamanho", schema = "pizzaria")
public class Tamanho extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private Tipo tipo;

	@Embedded
	private TempoValor tempoValor;
	
	@OneToMany(mappedBy="tamanho")
	private List<Pizza> pizzas;

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public TempoValor getTempoValor() {
		return tempoValor;
	}

	public void setTempoValor(TempoValor tempoValor) {
		this.tempoValor = tempoValor;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	

}
