package one.digitalinnovation.labpadroesprojetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Sprign Boot gerado via Spring Initializr
 * 
 * Módulos selecionados:
 * 
 * - Spring Data JPA
 * - Spring WEB
 * - H2 Database
 * - OpenFeign
 * 
 * Módulos selecionados e instalados através do MavenRepository:
 * 
 *  - Springdoc OpenAPI UI
 * 
 * @author dsouzarogerio
 *
 */
@EnableFeignClients
@SpringBootApplication
public class LabPadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesProjetoSpringApplication.class, args);
	}

}
