package br.com.pizzaria.core.api.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.dsl.BooleanExpression;

import br.com.pizzaria.core.api.domain.model.Sabor;
import br.com.pizzaria.core.api.domain.service.SaborService;
import br.com.pizzaria.core.api.infrastructure.search.SearchBuilder;
import br.com.pizzaria.core.api.infrastructure.service.ConverterServiceImpl;
import br.com.pizzaria.core.api.infrastructure.service.ResponseServiceImpl;
import br.com.pizzaria.core.api.presentation.dto.ResponseTO;
import br.com.pizzaria.core.api.presentation.dto.sabor.BuscaRequestTO;
import br.com.pizzaria.core.api.presentation.dto.sabor.SaborRequestTO;
import br.com.pizzaria.core.api.presentation.dto.sabor.SaborResponseTO;


@RestController
@RequestMapping("/sabores")
public class SaborController {

	@Autowired
	private SearchBuilder searchBuilder;

	@Autowired
	private SaborService saborService;

	@Autowired
	private ConverterServiceImpl converterService;

	@Autowired
	private ResponseServiceImpl responseService;

	@GetMapping
	public ResponseEntity<ResponseTO<Page<SaborResponseTO>>> listar(BuscaRequestTO buscaTO, Pageable pagina) {
		BooleanExpression predicate = searchBuilder.add(buscaTO).build();
		Page<Sabor> listarTodos = saborService.listarTodos(predicate, pagina);
		Page<SaborResponseTO> saboresResponseTO = converterService.convert(listarTodos, SaborResponseTO.class);
		return responseService.ok(saboresResponseTO);

	}

	@PostMapping
	public ResponseEntity<ResponseTO<SaborResponseTO>> cadastrar(@Valid @RequestBody SaborRequestTO saborRequestTO) {
		Sabor sabor = converterService.convert(saborRequestTO, Sabor.class);
		Sabor saborSalvo = saborService.salvar(sabor);
		SaborResponseTO saborResponseTO = converterService.convert(saborSalvo, SaborResponseTO.class);
		return responseService.create(saborResponseTO);

	}

}
