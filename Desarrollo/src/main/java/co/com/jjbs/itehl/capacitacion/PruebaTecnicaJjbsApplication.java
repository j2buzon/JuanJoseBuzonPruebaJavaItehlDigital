package co.com.jjbs.itehl.capacitacion;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "co.com.jjbs.itehl.capacitacion.repository")
public class PruebaTecnicaJjbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaJjbsApplication.class, args);
	}
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("co.com.jjbs.itehl.capacitacion.controller.rest"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"API Capacitaciones ITEHL",
				"Servicios REST para capacitaciones ITEHL",
				"1.0",
				"http://codmind.com/terms",
				new Contact("Juan José Buzón", "https://www.linkedin.com/in/jjbs2406/", "j2buzon@gmail.com"),
				"License of API",
				"API license URL",
				Collections.emptyList()
				);
	}

}
