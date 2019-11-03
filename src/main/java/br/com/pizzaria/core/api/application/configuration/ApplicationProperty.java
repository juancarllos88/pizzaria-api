package br.com.pizzaria.core.api.application.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("pizzaria-core")
public class ApplicationProperty {

    public static final String QUEUE_EMAIL_NAME = "email";

    private Seguranca seguranca = new Seguranca();
    private String baseUrl;
    private ApiInfo apiInfo = new ApiInfo();

    public Seguranca getSeguranca() {
        return seguranca;
    }

    public void setSeguranca(Seguranca seguranca) {
        this.seguranca = seguranca;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public ApiInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    public static class Seguranca {
        private String usuarioSistemaToken;
        private JwtTokenConfig jwtTokenConfig;

        public String getUsuarioSistemaToken() {
            return usuarioSistemaToken;
        }

        public void setUsuarioSistemaToken(String usuarioSistemaToken) {
            this.usuarioSistemaToken = usuarioSistemaToken;
        }

        public JwtTokenConfig getJwtTokenConfig() {
            return jwtTokenConfig;
        }

        public void setJwtTokenConfig(JwtTokenConfig jwtTokenConfig) {
            this.jwtTokenConfig = jwtTokenConfig;
        }
    }

    public static class JwtTokenConfig {
        private String segredo;
        private Long expiracao;

        public String getSegredo() {
            return segredo;
        }

        public void setSegredo(String segredo) {
            this.segredo = segredo;
        }

        public Long getExpiracao() {
            return expiracao;
        }

        public void setExpiracao(Long expiracao) {
            this.expiracao = expiracao;
        }
    }

    public static class ApiInfo {
        private String titulo;
        private String descricao;
        private String versao;
        private String pacote;

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getVersao() {
            return versao;
        }

        public void setVersao(String versao) {
            this.versao = versao;
        }

        public String getPacote() {
            return pacote;
        }

        public void setPacote(String pacote) {
            this.pacote = pacote;
        }
    }
}
