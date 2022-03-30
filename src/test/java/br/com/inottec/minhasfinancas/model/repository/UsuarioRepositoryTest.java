package br.com.inottec.minhasfinancas.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;

import br.com.inottec.minhasfinancas.model.entity.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;

	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		// cenario
		Usuario usuario = new Usuario("usuario", "usuario@email.com");
		repository.save(usuario);

		// ação/ execução
		boolean result = repository.existsByEmail("usuario@email.com");

		// verificação
		Assertions.assertThat(result).isTrue();

	}

	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastroComEmail() {

		// cenario
		repository.deleteAll();

		// ação/ execução
		boolean result = repository.existsByEmail("usuario@email.com");

		// verificação
		Assertions.assertThat(result).isFalse();

	}

}
