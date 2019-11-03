package br.com.pizzaria.core.api.infrastructure.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pizzaria.core.api.presentation.dto.ResponseTO;

@Service
public class ResponseServiceImpl {

    public <T> ResponseEntity<ResponseTO<T>> create(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseTO<T>(data));
    }

    public <T> ResponseEntity<ResponseTO<T>> ok(T data) {
        return ResponseEntity.ok(new ResponseTO<T>(data));
    }

    public <T> ResponseEntity<T> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

	public ResponseEntity<Resource> file(String tipo, String nome, byte[] arquivo) {
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(tipo))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; id=\"" + nome + "\"")
				.body(new ByteArrayResource(arquivo));
	}
}
