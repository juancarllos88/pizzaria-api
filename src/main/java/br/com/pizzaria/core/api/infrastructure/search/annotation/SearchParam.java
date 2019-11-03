package br.com.pizzaria.core.api.infrastructure.search.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.pizzaria.core.api.infrastructure.search.Operation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchParam {

    public String property() default "";

    public Operation operation() default Operation.EQUALS;

    public String group() default "default";

}
