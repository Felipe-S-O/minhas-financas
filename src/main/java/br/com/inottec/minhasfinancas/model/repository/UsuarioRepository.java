package br.com.inottec.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inottec.minhasfinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}
