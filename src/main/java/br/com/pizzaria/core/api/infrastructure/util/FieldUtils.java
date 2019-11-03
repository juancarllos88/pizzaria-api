package br.com.pizzaria.core.api.infrastructure.util;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import br.com.pizzaria.core.api.infrastructure.search.exception.InvalidFieldException;

public class FieldUtils {

	@SuppressWarnings("unchecked")
	public static List<Long> getLongValues(Object data, Field field) throws IllegalAccessException {
		return (List<Long>) field.get(data);
	}

	public static void setValue(Object data, Object value, String fieldName) {
		try {
			Field[] fields = data.getClass().getDeclaredFields();
			if (null != data.getClass().getSuperclass())
				fields = (Field[]) ArrayUtils.addAll(fields, data.getClass().getSuperclass().getDeclaredFields());
			for (int i = 0; i < fields.length; i++) {
				if (fieldName.equals(fields[i].getName())) {
					fields[i].setAccessible(true);
					fields[i].set(data, value);
				}
			}
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new InvalidFieldException(fieldName);
		}
	}

}
