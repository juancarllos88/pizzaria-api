package br.com.pizzaria.core.api.infrastructure.persistence.hibernate.listener;

import javax.persistence.PrePersist;

import br.com.pizzaria.core.api.domain.model.Sabor;

public class SaborEntityListener {

    @PrePersist
    public void saborPrePersist(Sabor sabor) {
    	if(sabor.getTempo() == null)
    		sabor.setTempo(0);
    }

}
