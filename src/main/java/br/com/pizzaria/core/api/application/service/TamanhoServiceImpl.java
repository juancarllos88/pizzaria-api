package br.com.pizzaria.core.api.application.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.core.api.domain.model.tamanho.Tamanho;
import br.com.pizzaria.core.api.domain.service.TamanhoService;
import br.com.pizzaria.core.api.infrastructure.persistence.hibernate.repository.TamanhoRepository;

@Service
public class TamanhoServiceImpl extends BaseServiceImpl<Tamanho> implements TamanhoService {

	private static final Logger logger = LogManager.getLogger(TamanhoServiceImpl.class);
	
	@Autowired
	protected TamanhoRepository tamanhoRepository;

	@Override
	protected TamanhoRepository getRepository() {
		return tamanhoRepository;
	}



}
