package ExerciciosSpringBoot.Atividade01SpringBoot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Habilidades_Mentalidades {

	@RequestMapping("/habilidade_mentalidade")
	public String habilidade() {
		return ("A habilidade que eu utilizei foi a: Atenção aos detalhes! <br> A mentalidade que eu utlizei foi a: Persistência!");
	}
	
	
}
