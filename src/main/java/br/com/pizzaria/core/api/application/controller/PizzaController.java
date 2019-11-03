package br.com.pizzaria.core.api.application.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.dsl.BooleanExpression;

import br.com.pizzaria.core.api.domain.model.Pizza;
import br.com.pizzaria.core.api.domain.service.PizzaService;
import br.com.pizzaria.core.api.infrastructure.search.SearchBuilder;
import br.com.pizzaria.core.api.infrastructure.service.ConverterServiceImpl;
import br.com.pizzaria.core.api.infrastructure.service.ResponseServiceImpl;
import br.com.pizzaria.core.api.presentation.dto.ResponseTO;
import br.com.pizzaria.core.api.presentation.dto.pizza.BuscaRequestTO;
import br.com.pizzaria.core.api.presentation.dto.pizza.PizzaAdicionaisRequestTO;
import br.com.pizzaria.core.api.presentation.dto.pizza.PizzaCompletaResponseTO;
import br.com.pizzaria.core.api.presentation.dto.pizza.PizzaRequestTO;
import br.com.pizzaria.core.api.presentation.dto.pizza.PizzaResponseTO;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private SearchBuilder searchBuilder;

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private ConverterServiceImpl converterService;

	@Autowired
	private ResponseServiceImpl responseService;

	@GetMapping
	public ResponseEntity<ResponseTO<Page<PizzaCompletaResponseTO>>> listar(BuscaRequestTO buscaTO, Pageable pagina) {
		BooleanExpression predicate = searchBuilder.add(buscaTO).build();
		Page<Pizza> listarTodos = pizzaService.listarTodos(predicate, pagina);
		Page<PizzaCompletaResponseTO> pizzasResponseTO = converterService.convert(listarTodos, PizzaCompletaResponseTO.class);
		return responseService.ok(pizzasResponseTO);

	}

	@PostMapping
	public ResponseEntity<ResponseTO<PizzaResponseTO>> cadastrar(@Valid @RequestBody PizzaRequestTO pizzaRequestTO) {
		Pizza pizza = converterService.convert(pizzaRequestTO, Pizza.class);
		Pizza pizzaSalva = pizzaService.salvar(pizza);
		PizzaResponseTO pizzaResponseTO = converterService.convert(pizzaSalva, PizzaResponseTO.class);
		return responseService.create(pizzaResponseTO);
		
	}
	
	@PatchMapping("/{id}/adicionais")
	public ResponseEntity<ResponseTO<PizzaCompletaResponseTO>> adicionarExtras(@PathVariable Long id, @RequestBody PizzaAdicionaisRequestTO pizzaAdicionaisRequestTO) {
		Pizza pizza = converterService.convert(pizzaAdicionaisRequestTO, Pizza.class);
		Pizza pizzaSalva = pizzaService.atualizar(id, pizza);
		PizzaCompletaResponseTO pizzaResponseTO = converterService.convert(pizzaSalva, PizzaCompletaResponseTO.class);
		return responseService.ok(pizzaResponseTO);
		
	}

}
