package br.com.pizzaria.core.api.application.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.core.api.domain.model.Pizza;
import br.com.pizzaria.core.api.domain.service.PizzaService;
import br.com.pizzaria.core.api.infrastructure.persistence.hibernate.repository.PizzaRepository;

@Service
public class PizzaServiceImpl extends BaseServiceImpl<Pizza> implements PizzaService {

	private static final Logger logger = LogManager.getLogger(PizzaServiceImpl.class);

	@Autowired
	protected PizzaRepository pizzaRepository;

	@Override
	protected PizzaRepository getRepository() {
		return pizzaRepository;
	}

}
