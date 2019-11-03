package br.com.pizzaria.core.api.infrastructure.security.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import br.com.pizzaria.core.api.infrastructure.service.MessageServiceImpl;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Autowired
	private MessageServiceImpl mensagemService;

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e)
			throws IOException {
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED, mensagemService.getMessage("seguranca.acesso-negado"));
	}

}