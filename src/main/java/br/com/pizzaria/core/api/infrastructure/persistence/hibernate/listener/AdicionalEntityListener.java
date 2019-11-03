package br.com.pizzaria.core.api.infrastructure.persistence.hibernate.listener;

import java.math.BigDecimal;

import javax.persistence.PrePersist;

import br.com.pizzaria.core.api.domain.model.Adicional;
import br.com.pizzaria.core.api.domain.shared.TempoValor;

public class AdicionalEntityListener {

	@PrePersist
	public void adicionalPrePersist(Adicional adicional) {
		if (adicional.getTempoValor() == null) {
			adicional.setTempoValor(new TempoValor(BigDecimal.ZERO, 0));
		} else {
			if (adicional.getTempoValor().getValor() == null) {
				adicional.getTempoValor().setValor(BigDecimal.ZERO);
			}
			if (adicional.getTempoValor().getTempo() == null) {
				adicional.getTempoValor().setTempo(0);
			}
		}
	}

}
