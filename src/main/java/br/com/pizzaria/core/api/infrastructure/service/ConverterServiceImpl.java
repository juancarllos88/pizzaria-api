package br.com.pizzaria.core.api.infrastructure.service;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import br.com.pizzaria.core.api.infrastructure.converter.annotation.IdReference;
import br.com.pizzaria.core.api.infrastructure.exception.IdReferenceException;
import br.com.pizzaria.core.api.infrastructure.factory.RepositoryFactory;
import br.com.pizzaria.core.api.infrastructure.util.FieldUtils;

@Service
@RequestScope
public class ConverterServiceImpl {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RepositoryFactory repositoryFactory;

	public <T> T convert(Object data, Class<T> type) {
		T target = modelMapper.map(data, type);
		return refreshReferences(data, target);
	}

	public <T> List<T> convert(List<?> dataList, Class<T> type) {
		return dataList.stream().map(d -> convert(d, type)).collect(Collectors.toList());
	}

	public <T> Page<T> convert(Page<?> dataList, Class<T> type) {
		return dataList.map(d -> convert(d, type));
	}

	public <T> T refreshReferences(Object data, T target) {
		clearId(target);
		Field[] fields = data.getClass().getDeclaredFields();

		for (Field field : fields) {
			IdReference idReference = field.getAnnotation(IdReference.class);
			if (idReference != null) {
				field.setAccessible(true);
				try {
					SimpleJpaRepository<?, Long> repository = repositoryFactory.create(idReference.target());
					Field fieldTarget = target.getClass().getDeclaredField(idReference.property());
					fieldTarget.setAccessible(true);

					if (field.get(data) instanceof Collection) {
						fieldTarget.set(target, repository.findAllById(FieldUtils.getLongValues(data, field)));
					} else if(field.get(data)!=null) {
						fieldTarget.set(target, repository.getOne((Long) field.get(data)));
					}

				} catch (NoSuchFieldException | IllegalAccessException e) {
					throw new IdReferenceException(e);
				}
			}
		}
		return target;
	}

	public void clearId(Object target) {
		if (target.getClass().isAnnotationPresent(Entity.class))
			FieldUtils.setValue(target, null, "id");
	}
}
