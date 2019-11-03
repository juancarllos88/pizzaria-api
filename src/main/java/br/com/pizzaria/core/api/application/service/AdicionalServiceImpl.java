package br.com.pizzaria.core.api.application.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.core.api.domain.model.Adicional;
import br.com.pizzaria.core.api.domain.service.AdicionalService;
import br.com.pizzaria.core.api.infrastructure.persistence.hibernate.repository.AdicionalRepository;

@Service
public class AdicionalServiceImpl extends BaseServiceImpl<Adicional> implements AdicionalService {

	private static final Logger logger = LogManager.getLogger(AdicionalServiceImpl.class);

	@Autowired
	protected AdicionalRepository adicionalRepository;

	@Override
	protected AdicionalRepository getRepository() {
		return adicionalRepository;
	}

}
