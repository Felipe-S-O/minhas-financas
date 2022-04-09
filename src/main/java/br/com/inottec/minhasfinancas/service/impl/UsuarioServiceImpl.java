package br.com.inottec.minhasfinancas.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inottec.minhasfinancas.exeception.ErroAutenticacao;
import br.com.inottec.minhasfinancas.exeception.RegraNegocioException;
import br.com.inottec.minhasfinancas.model.entity.Usuario;
import br.com.inottec.minhasfinancas.model.repository.UsuarioRepository;
import br.com.inottec.minhasfinancas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	

	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByEmail(email);
		
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado para o email informado.");
		}
		else if (usuario.get().getSenha().equals(senha)) {
			
			throw new ErroAutenticacao("senha inválida.");
			
		}
		return usuario.get();
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		
		boolean existe = repository.existsByEmail(email);
		
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
			
		}
	}

}
