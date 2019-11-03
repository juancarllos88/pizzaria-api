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

import br.com.pizzaria.core.api.domain.model.tamanho.Tamanho;
import br.com.pizzaria.core.api.domain.service.TamanhoService;
import br.com.pizzaria.core.api.infrastructure.search.SearchBuilder;
import br.com.pizzaria.core.api.infrastructure.service.ConverterServiceImpl;
import br.com.pizzaria.core.api.infrastructure.service.ResponseServiceImpl;
import br.com.pizzaria.core.api.presentation.dto.ResponseTO;
import br.com.pizzaria.core.api.presentation.dto.tamanho.BuscaRequestTO;
import br.com.pizzaria.core.api.presentation.dto.tamanho.TamanhoRequestTO;
import br.com.pizzaria.core.api.presentation.dto.tamanho.TamanhoResponseTO;

@RestController
@RequestMapping("/tamanhos")
public class TamanhoController {

	@Autowired
	private SearchBuilder searchBuilder;

	@Autowired
	private TamanhoService tamanhoService;

	@Autowired
	private ConverterServiceImpl converterService;

	@Autowired
	private ResponseServiceImpl responseService;

	@GetMapping
	public ResponseEntity<ResponseTO<Page<TamanhoResponseTO>>> listar(BuscaRequestTO buscaTO, Pageable pagina) {
		BooleanExpression predicate = searchBuilder.add(buscaTO).build();
		Page<Tamanho> listarTodos = tamanhoService.listarTodos(predicate, pagina);
		Page<TamanhoResponseTO> tamanhosResponseTO = converterService.convert(listarTodos, TamanhoResponseTO.class);
		return responseService.ok(tamanhosResponseTO);

	}


}
