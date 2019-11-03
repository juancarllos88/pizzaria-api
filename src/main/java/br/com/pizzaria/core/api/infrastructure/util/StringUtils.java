package br.com.pizzaria.core.api.infrastructure.util;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    public static String interpolate(String str, Map<String, Object> parameters) {
        String interpolateStr = "";
        for (HashMap.Entry<String, Object> p : parameters.entrySet()) {
            interpolateStr = str.replace("{" + p.getKey() + "}", p.getValue().toString());
            str = interpolateStr;
        }
        return interpolateStr;

    }

    public static String convert(int arg) {
        return String.valueOf(arg);
    }
}
