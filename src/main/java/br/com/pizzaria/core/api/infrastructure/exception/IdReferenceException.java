package br.com.pizzaria.core.api.infrastructure.exception;

public class IdReferenceException extends RuntimeException {

    private static final long serialVersionUID = 2617203581306492064L;

    public IdReferenceException(Throwable cause) {
        super(cause);
    }
}
