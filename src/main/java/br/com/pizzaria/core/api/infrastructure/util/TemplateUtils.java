package br.com.pizzaria.core.api.infrastructure.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class TemplateUtils {

    public static String getContent(String fileName) {
        String content = null;
        try {
            InputStream inputStream = TemplateUtils.class.getClassLoader()
                    .getResourceAsStream("template/" + fileName);
            content = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            throw new IllegalArgumentException("invalid file " + fileName);
        }
        return content;
    }

    public static String generate(String uri, Map<String, Object> data) {
        return StringUtils.interpolate(getContent(uri), data);
    }

}
