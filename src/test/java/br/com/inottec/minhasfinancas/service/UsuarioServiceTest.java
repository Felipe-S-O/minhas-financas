package br.com.inottec.minhasfinancas.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.inottec.minhasfinancas.model.entity.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@Autowired
	private UsuarioService service;

	public Usuario autenticar(String email, String senha) {
		return service.autenticar(email, senha);
	}

	public Usuario salvarUsuario(Usuario usuario) {
		return service.salvarUsuario(usuario);
	}

	public void validarEmail(String email) {
		service.validarEmail(email);
	}

}
