package br.com.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrworker.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
