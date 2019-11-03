package br.com.pizzaria.core.api.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.pizzaria.core.api.domain.model.tamanho.Tamanho;
import br.com.pizzaria.core.api.domain.shared.BaseEntity;

@Entity
@Table(name = "t_pizza", schema = "pizzaria")
public class Pizza extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_tamanho")
	private Tamanho tamanho;

	@ManyToOne
	@JoinColumn(name = "id_sabor")
	private Sabor sabor;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinTable(
	name = "t_pizza_adicional",
	schema = "pizzaria",
	joinColumns=@JoinColumn(name = "id_pizza"),
	inverseJoinColumns=@JoinColumn(name = "id_adicional")
	)
	private List<Adicional> adicionais;

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public List<Adicional> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<Adicional> adicionais) {
		this.adicionais = adicionais;
	}

}
