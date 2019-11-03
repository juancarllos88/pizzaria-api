package br.com.pizzaria.core.api.application.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pizzaria.core.api.domain.model.Pedido;
import br.com.pizzaria.core.api.domain.service.PedidoService;
import br.com.pizzaria.core.api.domain.shared.TempoValor;
import br.com.pizzaria.core.api.infrastructure.persistence.hibernate.repository.PedidoRepository;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido> implements PedidoService {

	private static final Logger logger = LogManager.getLogger(PedidoServiceImpl.class);

	@Autowired
	protected PedidoRepository pedidoRepository;

	@Override
	protected PedidoRepository getRepository() {
		return pedidoRepository;
	}

	
	@Override
	@Transactional
	public Pedido salvar(Pedido pedido) {
		calculoPedido(pedido);
		return getRepository().save(pedido);
	}

	private void calculoPedido(Pedido pedido) {
		TempoValor tempoValorTamanho = pedido.getPizza().getTamanho().getTempoValor();
		Integer tempoSabor = pedido.getPizza().getSabor().getTempo();

		Integer tempoAdicionais = pedido.getPizza().getAdicionais().stream()
				.filter(adicional -> adicional.getTempoValor().getTempo() != null)
				.mapToInt(adicional -> adicional.getTempoValor().getTempo()).sum();

		Optional<BigDecimal> valorAdicionais = pedido.getPizza().getAdicionais().stream()
				.filter(adicional -> adicional.getTempoValor().getValor() != null)
				.map(adicional -> adicional.getTempoValor().getValor()).reduce(BigDecimal::add);
		
		BigDecimal valorTotalAdicionais = BigDecimal.ZERO;
		if(valorAdicionais.isPresent()) {
			valorTotalAdicionais = valorAdicionais.get();
		}

		TempoValor tempoValorPedido = new TempoValor();
		tempoValorPedido.setTempo(tempoValorTamanho.getTempo() + tempoSabor + tempoAdicionais);
		tempoValorPedido
				.setValor(valorTotalAdicionais.add(tempoValorTamanho.getValor()).setScale(2, BigDecimal.ROUND_HALF_UP));
		pedido.setTempoValor(tempoValorPedido);
	}

	

}
