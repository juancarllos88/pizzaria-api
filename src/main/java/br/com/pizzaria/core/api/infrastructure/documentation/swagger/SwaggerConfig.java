package br.com.pizzaria.core.api.infrastructure.documentation.swagger;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.pizzaria.core.api.application.configuration.ApplicationProperty;
import br.com.pizzaria.core.api.infrastructure.security.util.JwtTokenUtil;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {

    private static final String SCOPE = "global";
    private static final String HTTP_HEADER = "header";

    @Autowired
    private ApplicationProperty appProperty;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(appProperty.getApiInfo().getPacote()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(getApiKeys())
                .securityContexts(securityContext());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(appProperty.getApiInfo().getTitulo())
                .description(appProperty.getApiInfo().getDescricao())
                .version(appProperty.getApiInfo().getVersao())
                .build();
    }

    private List<ApiKey> getApiKeys() {
        return Arrays.asList(new ApiKey(JwtTokenUtil.AUTH_HEADER, JwtTokenUtil.AUTH_HEADER, HTTP_HEADER));
    }

    private List<SecurityReference> getSecurityReferences() {
        return Arrays.asList((new SecurityReference(JwtTokenUtil.AUTH_HEADER,
                (AuthorizationScope[]) Arrays.asList(new AuthorizationScope(SCOPE, SCOPE)).toArray())));
    }

    private List<SecurityContext> securityContext() {
        SecurityContext context = SecurityContext.builder()
                .securityReferences(getSecurityReferences())
                .forPaths(PathSelectors.regex(appProperty.getApiInfo().getPacote()))
                .build();
        return Arrays.asList(context);
    }
}
