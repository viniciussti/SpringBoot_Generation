package ExerciciosSpringBoot.Atividade02SpringBoot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Objetivos_Aprendizagem {

	@RequestMapping("/objetivo")
	public String objetivo() {
		return "<h1>Meus objetivos de aprendizagem para essa semana!<h1>"
				+ " <br> Aprender SpringBoot, e absorver o máximo de conteúdo!";
	}
	
}
