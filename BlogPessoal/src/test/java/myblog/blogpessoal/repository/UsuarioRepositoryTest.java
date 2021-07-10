package myblog.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import myblog.blogpessoal.model.Usuario;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuariorepository;
	
	@BeforeAll
	public void start() {
		Usuario usuario = new Usuario(0L, "Chefe", "chefe1@gmail.com", "9xxxxxxx9");
		if (usuariorepository.findFirstByNome(usuario.getNome()) == null)
			usuariorepository.save(usuario);

		usuario = new Usuario(0L, "Novo Chefe", "chefe2@gmail.com", "8xxxxxxx8");
		if (usuariorepository.findFirstByNome(usuario.getNome()) == null)
			usuariorepository.save(usuario);

		usuario = new Usuario(0L, "chefe Mais Antigo", "chefe3@gmail.com", "7xxxxxxx7");
		if (usuariorepository.findFirstByNome(usuario.getNome()) == null)
			usuariorepository.save(usuario);

		usuario = new Usuario(0L, "Amigo", "amigo@gmail.com", "5xxxxxxx5");
		if (usuariorepository.findFirstByNome(usuario.getNome()) == null)
			usuariorepository.save(usuario);
	}
	
	
	@Test
	public void findFirstByNome() throws Exception {

		Usuario usuario = usuariorepository.findFirstByNome("Chefe");

		assertTrue(usuario.getNome().equals("Chefe"));
	}
	
	
	@Test
	public void findAllByNomeIgnoreCaseContainingTresUsuarios() {

		List<Usuario> usuarios = usuariorepository.findAllByNomeIgnoreCaseContaining("chefe");

		assertEquals(3, usuarios.size());
	}
	
	@Disabled
	@AfterAll
	public void end() {
		usuariorepository.deleteAll();
	}
}
