package br.com.hrworker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.hrworker.entities.Usuario;
import br.com.hrworker.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repository;

	public List<Usuario> buscaTodosUsuarios() {
		return repository.findAll();
	}

	public ResponseEntity<Usuario> buscaUsuario(Long codigo) {
		Optional<Usuario> list = repository.findById(codigo);
		return list.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
	}

	public Usuario criaUsuario(Usuario usuario) {
		return repository.save(usuario);
	}

	public ResponseEntity<Usuario> deletaUsuario(Long codigo) {
		Optional<Usuario> buscaUsuario = repository.findById(codigo);
		if (buscaUsuario.isPresent()) {
			repository.deleteById(codigo);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Usuario> atualizaUsuario(Long codigo, Usuario usuario) {
//		Optional<Usuario> buscaUsuario = repository.findById(codigo);
//		if (buscaUsuario.isPresent()) {
//			BeanUtils.copyProperties(usuario, buscaUsuario.get(), "codigo");
//			Usuario salvaUsuario = repository.save(buscaUsuario.get());
//			

//			return ResponseEntity.ok(salvaUsuario);
		Usuario usuarioToSalve = repository.findById(codigo)
				.orElseThrow(() -> new NullPointerException("Usuario não encontrado" + codigo));

		if (usuarioToSalve.getId() == null) {
			return ResponseEntity.notFound().build();

		}
		usuarioToSalve.setDataNascimento(usuario.getDataNascimento());
		usuarioToSalve.setImage(usuario.getImage());
		usuarioToSalve.setNome(usuario.getNome());
		final Usuario usuarioAtualizado = repository.save(usuarioToSalve);
		return ResponseEntity.ok(usuarioAtualizado);
	}
}
