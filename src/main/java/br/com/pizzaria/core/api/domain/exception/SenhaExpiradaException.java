package br.com.pizzaria.core.api.domain.exception;

public class SenhaExpiradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
