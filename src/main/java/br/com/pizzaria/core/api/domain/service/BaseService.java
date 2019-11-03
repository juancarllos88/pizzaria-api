package br.com.pizzaria.core.api.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

public interface BaseService<T> {

    public T buscar(Long id);

    public Page<T> listarTodos(Pageable pageable);

    public Page<T> listarTodos(Predicate predicate, Pageable pageable);

    public T salvar(T entidade);

    public T atualizar(Long id, T entidade);

}
