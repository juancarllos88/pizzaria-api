package br.com.pizzaria.core.api.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.dsl.BooleanExpression;

import br.com.pizzaria.core.api.domain.model.Pedido;
import br.com.pizzaria.core.api.domain.service.PedidoService;
import br.com.pizzaria.core.api.infrastructure.search.SearchBuilder;
import br.com.pizzaria.core.api.infrastructure.service.ConverterServiceImpl;
import br.com.pizzaria.core.api.infrastructure.service.ResponseServiceImpl;
import br.com.pizzaria.core.api.presentation.dto.ResponseTO;
import br.com.pizzaria.core.api.presentation.dto.pedido.BuscaRequestTO;
import br.com.pizzaria.core.api.presentation.dto.pedido.PedidoDetalhadoResponseTO;
import br.com.pizzaria.core.api.presentation.dto.pedido.PedidoRequestTO;
import br.com.pizzaria.core.api.presentation.dto.pedido.PedidoResponseTO;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private SearchBuilder searchBuilder;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private ConverterServiceImpl converterService;

	@Autowired
	private ResponseServiceImpl responseService;

	@GetMapping
	public ResponseEntity<ResponseTO<Page<PedidoResponseTO>>> listar(BuscaRequestTO buscaTO, Pageable pagina) {
		BooleanExpression predicate = searchBuilder.add(buscaTO).build();
		Page<Pedido> listarTodos = pedidoService.listarTodos(predicate, pagina);
		Page<PedidoResponseTO> pedidosResponseTO = converterService.convert(listarTodos, PedidoResponseTO.class);
		return responseService.ok(pedidosResponseTO);

	}

	@PostMapping
	public ResponseEntity<ResponseTO<PedidoResponseTO>> cadastrar(@Valid @RequestBody PedidoRequestTO pedidoRequestTO) {
		Pedido pedido = converterService.convert(pedidoRequestTO, Pedido.class);
		Pedido pedidoSalvo = pedidoService.salvar(pedido);
		PedidoResponseTO pedidoResponseTO = converterService.convert(pedidoSalvo, PedidoResponseTO.class);
		return responseService.create(pedidoResponseTO);

	}

	@GetMapping("/{id}/detalhado")
	public ResponseEntity<ResponseTO<PedidoDetalhadoResponseTO>> detalhar(@PathVariable Long id) {
		Pedido pedido = pedidoService.buscar(id);
		PedidoDetalhadoResponseTO pedidoDetalhadoResponseTO = converterService.convert(pedido,
				PedidoDetalhadoResponseTO.class);
		return responseService.ok(pedidoDetalhadoResponseTO);

	}

}
