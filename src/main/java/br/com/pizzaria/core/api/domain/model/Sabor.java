package br.com.pizzaria.core.api.domain.model;

import java.util.List;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.pizzaria.core.api.domain.shared.BaseEntity;
import br.com.pizzaria.core.api.infrastructure.persistence.hibernate.listener.SaborEntityListener;

@Entity
@EntityListeners(SaborEntityListener.class)
@Table(name = "t_sabor", schema = "pizzaria")
public class Sabor extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome")
	private String nome;

	@Column(name = "tempo")
	private Integer tempo;

	@OneToMany(mappedBy = "sabor")
	private List<Pizza> pizzas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

}
