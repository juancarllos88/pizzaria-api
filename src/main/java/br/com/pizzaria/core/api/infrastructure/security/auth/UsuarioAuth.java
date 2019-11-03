package br.com.pizzaria.core.api.infrastructure.security.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsuarioAuth extends User {

    private static final long serialVersionUID = 1L;

    private String token;
    private Long id;

    public UsuarioAuth(String username, String password, Collection<? extends GrantedAuthority> permissoes, Long id,
            String token) {
        super(username, password, permissoes);
        this.token = token;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return getUsername();
    }

}
