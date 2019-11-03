package br.com.pizzaria.core.api.infrastructure.search;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

import br.com.pizzaria.core.api.infrastructure.search.annotation.SearchEntity;
import br.com.pizzaria.core.api.infrastructure.search.annotation.SearchParam;
import br.com.pizzaria.core.api.infrastructure.search.exception.InvalidFieldException;

@Component
public class SearchBuilder {

    private List<BooleanExpression> predicates = new ArrayList<>();

    public SearchBuilder add(Object object) {
        SearchEntity entity = object.getClass().getAnnotation(SearchEntity.class);
        PathBuilder<?> entityPath = new PathBuilder<>(entity.value(), entity.value().getSimpleName().toLowerCase());
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value == null) {
                    continue;
                }
                add(field, field.get(object), entityPath);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new InvalidFieldException(field.toString());
            }
        }
        return this;
    }

    public BooleanExpression build() {
        BooleanExpression result = predicates.isEmpty() ? null : predicates.get(0);

        for (int i = 1; i < predicates.size(); i++) {
            result = result.and(predicates.get(i));
        }

        predicates.clear();
        return result;
    }

    private void add(Field field, Object value, PathBuilder<?> entityPath) {
        if (field.isAnnotationPresent(SearchParam.class)) {
            BooleanExpression predicate = null;
            SearchParam param = field.getAnnotation(SearchParam.class);
            String property = param.property() == null ? field.getName() : param.property();
            Operation operation = param.operation();

            if (value instanceof Number) {
                predicate = getPredicate(property, operation, entityPath, Integer.parseInt(value.toString()));
            } else if (value instanceof LocalDateTime) {
                predicate = getPredicate(property, operation, entityPath, LocalDateTime.parse(value.toString()));
            } else if (value instanceof Enum<?>) {
                predicate = getPredicate(property, entityPath, (Enum<?>) value);
            } else if (value instanceof Boolean) {
                predicate = getPredicate(property, entityPath, (Boolean) value);
            } else if (value instanceof List) {
                predicate = getPredicate(property, entityPath, (List<?>) value);
            } else {
                predicate = getPredicate(property, operation, entityPath, value.toString());
            }

            predicates.add(predicate);
        }
    }

    private BooleanExpression getPredicate(String property, PathBuilder<?> pathBuilder, List<?> value) {
        List<Long> ids = value.stream().map(t -> Long.parseLong(t.toString())).collect(Collectors.toList());
        return pathBuilder.getNumber(property, Long.class).in(ids);
    }

    private BooleanExpression getPredicate(String property, Operation operation, PathBuilder<?> pathBuilder,
            Integer value) {
        NumberPath<Integer> path = pathBuilder.getNumber(property, Integer.class);
        switch (operation) {
            case EQUALS:
                return path.eq(value);
            case MAJOR_EQUALS:
                return path.goe(value);
            case MINOR_EQUALS:
                return path.loe(value);
            default:
                return path.eq(value);
        }
    }

    private BooleanExpression getPredicate(String property, Operation operation, PathBuilder<?> pathBuilder,
            String value) {
        StringPath path = pathBuilder.getString(property);
        switch (operation) {
            case EQUALS:
                return path.eq(value);
            case ILIKE:
                return path.containsIgnoreCase(value);
            default:
                return path.eq(value);
        }
    }

    private BooleanExpression getPredicate(String property, PathBuilder<?> pathBuilder, Boolean value) {
        return pathBuilder.getBoolean(property).eq(value);
    }

    private BooleanExpression getPredicate(String property, Operation operation, PathBuilder<?> pathBuilder,
            LocalDateTime value) {
        DatePath<LocalDateTime> path = pathBuilder.getDate(property, LocalDateTime.class);
        switch (operation) {
            case EQUALS:
                return path.eq(value);
            case MAJOR_EQUALS:
                return path.goe(value);
            case MINOR_EQUALS:
                return path.loe(value);
            default:
                return path.eq(value);
        }
    }

    @SuppressWarnings("unchecked")
    private BooleanExpression getPredicate(String property, PathBuilder<?> pathBuilder, Enum<?> value) {
        return pathBuilder.getEnum(property, Enum.class).eq(value);
    }

}
