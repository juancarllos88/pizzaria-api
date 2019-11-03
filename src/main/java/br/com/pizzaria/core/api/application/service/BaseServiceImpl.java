package br.com.pizzaria.core.api.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Predicate;

import br.com.pizzaria.core.api.application.service.exception.InformacaoNaoEncontradaException;
import br.com.pizzaria.core.api.domain.service.BaseService;
import br.com.pizzaria.core.api.domain.shared.BaseEntity;
import br.com.pizzaria.core.api.infrastructure.persistence.hibernate.repository.BaseRepository;
import br.com.pizzaria.core.api.infrastructure.util.BeanUtils;

@Service
public abstract class BaseServiceImpl<T extends BaseEntity<Long>> implements BaseService<T> {

	@Transactional(readOnly = true)
	@Override
	public T buscar(Long id) {
		T entidade = getRepository().getOne(id);

		if (entidade == null) {
			throw new InformacaoNaoEncontradaException();
		}

		return entidade;
	}

	@Transactional(readOnly = true)
	public Page<T> listarTodos(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Page<T> listarTodos(Predicate predicate, Pageable pageable) {
		return getRepository().findAll(predicate, pageable);
	}

	@Override
	@Transactional
	public T salvar(T entidade) {
		return getRepository().save(entidade);
	}

	@Override
	@Transactional
	public T atualizar(Long id, T entidade) {
		T entidadeSalva = buscar(id);
		BeanUtils.copyProperties(entidade, entidadeSalva);
		return salvar(entidadeSalva);
	}

	protected abstract BaseRepository<T, Long> getRepository();

}
