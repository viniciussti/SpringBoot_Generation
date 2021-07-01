package MinhaLojadeGames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MinhaLojadeGames.model.Categoria;


/*Annotation (Anotação), que indica que a Classe é uma Repository,
ou seja, é responsável pela comunicação com o Banco de dados através dos métodos
padrão e das Method Queries, que são consultas personalizadas através de palavras
chave que representam as instruções da linguagem SQL*/
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{ 
	// TRAZENDO POR HERANÇA A CLASSE CATEGORIA 
	
		public List <Categoria> findAllByGeneroContainingIgnoreCase(String genero);
		//CRIANDO MÉTODO PARA EFETUAR CONSULTA ATRAVÉS DO ATRIBUTO GENERO
}
