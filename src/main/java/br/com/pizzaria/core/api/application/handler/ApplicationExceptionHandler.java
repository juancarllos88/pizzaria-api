package br.com.pizzaria.core.api.application.handler;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.pizzaria.core.api.application.service.exception.InformacaoNaoEncontradaException;
import br.com.pizzaria.core.api.application.service.exception.PermissaoNegadaException;
import br.com.pizzaria.core.api.domain.exception.SenhaExpiradaException;
import br.com.pizzaria.core.api.infrastructure.exception.TokenInvalidoException;
import br.com.pizzaria.core.api.infrastructure.service.MessageServiceImpl;
import br.com.pizzaria.core.api.presentation.dto.ResponseTO;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected MessageServiceImpl mensagemService;

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
		log.warn(ex.getMessage());
		return handleException(ex, HttpStatus.BAD_REQUEST, request, "recurso.operacao-invalida");
	}

	@ExceptionHandler({ InformacaoNaoEncontradaException.class })
	public ResponseEntity<Object> handleInformacaoNaoEncontradaException(InformacaoNaoEncontradaException ex,
			WebRequest request) {
		return handleException(ex, HttpStatus.NOT_FOUND, request, "recurso.informacao-nao-encontrada");
	}

	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
		return handleException(ex, HttpStatus.BAD_REQUEST, request, "seguranca.permisao-negada");
	}

	@ExceptionHandler({ SenhaExpiradaException.class })
	public ResponseEntity<Object> handleSenhaExpiradaException(SenhaExpiradaException ex, WebRequest request) {
		ResponseTO<String> response = new ResponseTO<>(ex.getToken());
		response.setErrors(Arrays.asList((mensagemService.getMessage("seguranca.senha-expirada"))));
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ TokenInvalidoException.class })
	public ResponseEntity<Object> handleTokenInvalidoException(TokenInvalidoException ex, WebRequest request) {
		return handleException(ex, HttpStatus.BAD_REQUEST, request, "seguranca.token-invalido");
	}

	@ExceptionHandler({ UsernameNotFoundException.class })
	public ResponseEntity<Object> handleUsernameNotFoundException(RuntimeException ex, WebRequest request) {
		return handleException(ex, HttpStatus.BAD_REQUEST, request, "recurso.usuario-nao-encontrado");
	}

	@ExceptionHandler({ PermissaoNegadaException.class })
	public ResponseEntity<Object> handlePermissaoNegadaException(PermissaoNegadaException ex, WebRequest request) {
		return handleException(ex, HttpStatus.BAD_REQUEST, request, "seguranca.permisao-negada");
	}

	@ExceptionHandler({ BadCredentialsException.class })
	public ResponseEntity<Object> handleBadCredentialsException(RuntimeException ex, WebRequest request) {
		return handleException(ex, HttpStatus.BAD_REQUEST, request, "recurso.usuario.credenciais-invalidas");
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {
		ResponseTO<String> responseTO = new ResponseTO<>();
		ex.getConstraintViolations()
				.forEach(e -> responseTO.getErrors().add(MessageFormat.format(e.getMessage(), e.getPropertyPath())));

		return handleExceptionInternal(ex, responseTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ResponseTO<List<String>> response = new ResponseTO<>();
		List<String> erros = obterListaErros(ex.getBindingResult());
		response.setErrors(erros);
		return handleExceptionInternal(ex, response, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest request) {
		return handleException(ex, HttpStatus.BAD_REQUEST, request, "recurso.operacao-invalida");
	}

	protected ResponseEntity<Object> handleException(Exception ex, HttpStatus status, WebRequest req, String chave) {
		ResponseTO<List<String>> response = new ResponseTO<>();
		response.setErrors(Arrays.asList((mensagemService.getMessage(chave))));
		return handleExceptionInternal(ex, response, new HttpHeaders(), status, req);
	}

	protected List<String> obterListaErros(BindingResult bindingResult) {
		List<String> erros = new ArrayList<>();
		bindingResult.getFieldErrors().forEach(e -> erros.add(mensagemService.getMessage(e)));
		return erros;
	}
}
