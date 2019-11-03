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

import br.com.pizzaria.core.api.domain.model.Adicional;
import br.com.pizzaria.core.api.domain.service.AdicionalService;
import br.com.pizzaria.core.api.infrastructure.search.SearchBuilder;
import br.com.pizzaria.core.api.infrastructure.service.ConverterServiceImpl;
import br.com.pizzaria.core.api.infrastructure.service.ResponseServiceImpl;
import br.com.pizzaria.core.api.presentation.dto.ResponseTO;
import br.com.pizzaria.core.api.presentation.dto.adicional.AdicionalRequestTO;
import br.com.pizzaria.core.api.presentation.dto.adicional.AdicionalResponseTO;
import br.com.pizzaria.core.api.presentation.dto.adicional.BuscaRequestTO;

@RestController
@RequestMapping("/adicionais")
public class AdicionalController {

	@Autowired
	private SearchBuilder searchBuilder;

	@Autowired
	private AdicionalService adicionalService;

	@Autowired
	private ConverterServiceImpl converterService;

	@Autowired
	private ResponseServiceImpl responseService;

	@GetMapping
	public ResponseEntity<ResponseTO<Page<AdicionalResponseTO>>> listar(BuscaRequestTO buscaTO, Pageable pagina) {
		BooleanExpression predicate = searchBuilder.add(buscaTO).build();
		Page<Adicional> listarTodos = adicionalService.listarTodos(predicate, pagina);
		Page<AdicionalResponseTO> adicionaisResponseTO = converterService.convert(listarTodos,
				AdicionalResponseTO.class);
		return responseService.ok(adicionaisResponseTO);

	}

	@PostMapping
	public ResponseEntity<ResponseTO<AdicionalResponseTO>> cadastrar(@Valid @RequestBody AdicionalRequestTO adicionalRequestTO) {
		Adicional adicional = converterService.convert(adicionalRequestTO, Adicional.class);
		Adicional adicionalSalvo = adicionalService.salvar(adicional);
		AdicionalResponseTO adicionalResponseTO = converterService.convert(adicionalSalvo, AdicionalResponseTO.class);
		return responseService.create(adicionalResponseTO);

	}

}
