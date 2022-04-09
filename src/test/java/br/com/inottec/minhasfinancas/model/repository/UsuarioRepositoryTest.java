package br.com.inottec.minhasfinancas.model.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.expression.spel.ast.OpInc;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;

import br.com.inottec.minhasfinancas.model.entity.Usuario;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		
		
		// cenario
		Usuario usuario = criaUsuario();
		entityManager.persist(usuario);

		// ação/ execução
		boolean result = repository.existsByEmail("usuario@email.com");

		// verificação
		Assertions.assertThat(result).isTrue();

	}

	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastroComEmail() {

		// ação/ execução
		boolean result = repository.existsByEmail("usuario@email.com");

		// verificação
		Assertions.assertThat(result).isFalse();

	}

	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {

		// cenario
		Usuario usuario = criaUsuario();
		entityManager.persist(usuario);

		// ação/ execução
		Usuario usuarioSalvo = repository.save(usuario);

		// verificação
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();

	}
	
	@Test
	public void deveBuscarUmUsuarioPorEmail() {
		
		// cenario
		Usuario usuario = criaUsuario();
		entityManager.persist(usuario);
		
		//verificação
		Optional<Usuario> result = repository.findByEmail("usuario@email.com");
		
		Assertions.assertThat(result.isPresent()).isTrue();
		
	}
	
	@Test
	public void deveRetornarVazioAoBuscarUsuarioPorEmailQuandoNaoExisteNaBase() {
		//verificação
		Optional<Usuario> result = repository.findByEmail("usuario@email.com");
		
		Assertions.assertThat(result.isPresent()).isFalse();
	}
	
	public static Usuario criaUsuario() {
		
		// cenario
		Usuario usuario = new Usuario("usuario", "usuario@email.com", "senha");

		return  usuario;
	}
}
