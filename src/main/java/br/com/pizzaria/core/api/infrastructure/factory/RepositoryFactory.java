package br.com.pizzaria.core.api.infrastructure.factory;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFactory {

    @Autowired
    private EntityManager em;

    public <T> SimpleJpaRepository<T, Long> create(Class<T> domainClass) {
        return new SimpleJpaRepository<>(domainClass, em);
    }

}
