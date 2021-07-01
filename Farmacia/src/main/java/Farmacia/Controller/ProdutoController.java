package Farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Farmacia.Repository.ProdutoRepository;
import Farmacia.model.Produto;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository prodRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(prodRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id) {
		return prodRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nomeProduto/{nomeProduto}")
	public ResponseEntity<List<Produto>> getByProduto(@PathVariable String nomeProduto) {
		return ResponseEntity.ok(prodRepository.findAllBynomeProdutoContainingIgnoreCase(nomeProduto));
	}

	@PostMapping
	public ResponseEntity<Produto> CadastrarProduto(@RequestBody Produto nomeProduto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(prodRepository.save(nomeProduto));
	}

	@PutMapping
	public ResponseEntity<Produto> EditarProduto(@RequestBody Produto nomeProduto) {
		return ResponseEntity.status(HttpStatus.OK).body(prodRepository.save(nomeProduto));
	}

	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		prodRepository.deleteById(id);
	}

}
