package br.com.pizzaria.core.api.application.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.core.api.domain.model.Sabor;
import br.com.pizzaria.core.api.domain.service.SaborService;
import br.com.pizzaria.core.api.infrastructure.persistence.hibernate.repository.SaborRepository;

@Service
public class SaborServiceImpl extends BaseServiceImpl<Sabor> implements SaborService {

	private static final Logger logger = LogManager.getLogger(SaborServiceImpl.class);

	@Autowired
	protected SaborRepository saborRepository;

	@Override
	protected SaborRepository getRepository() {
		return saborRepository;
	}

}
