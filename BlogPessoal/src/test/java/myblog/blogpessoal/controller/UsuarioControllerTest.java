package myblog.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import myblog.blogpessoal.model.Usuario;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	private Usuario usuario;
	private Usuario usuarioupd;
	
	
	@BeforeAll
	public void start() {
		usuario = new Usuario(0L, "Maria", "maria@gmail.com", "44451198");
		usuarioupd = new Usuario(0L, "Maria da Silva", "maria2@gmail.com", "995467892");
	}
	
	
	@Test
	public void deveRealizarPostUsuarios() {

		/*
		 * Criando um objeto do tipo HttpEntity para enviar como terceiro parâmentro do
		 * método exchange. (Enviando um objeto contato via body)
		 * 
		 */
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);

		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, request,Usuario.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	public void deveMostrarTodosUsuarios() {
		ResponseEntity<String> resposta = testRestTemplate.exchange("/usuarios/", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	public void deveRealizarPutUsuarios() {

		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuarioupd);

		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/alterar", HttpMethod.PUT, request,
				Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());

	}
	
	@Disabled
	@Test
	@DisplayName("😜")
	public void deveRealizarDeleteUsuarios() {

		/*
		 * O Contato com Id 3 será apagado somente ele existir no Banco. Caso contrário,
		 * o teste irá falhar!
		 * 
		 */
		ResponseEntity<String> resposta = testRestTemplate.exchange("/usuarios/3", HttpMethod.DELETE, null,
				String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());

	}

}
