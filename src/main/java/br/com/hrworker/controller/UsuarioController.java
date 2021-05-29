package br.com.hrworker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrworker.entities.Usuario;
import br.com.hrworker.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService service;

	@GetMapping
	public List<Usuario> buscaTodosUsuarios() {
		return service.buscaTodosUsuarios();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscaUsuario(@PathVariable Long id) {
		return service.buscaUsuario(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario criaUsuario(@RequestBody @Valid Usuario usuario) {

		return service.criaUsuario(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizaUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
		return service.atualizaUsuario(id, usuario);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Usuario> deletaUsuario(@PathVariable Long id) {
		return service.deletaUsuario(id);
	}
}
