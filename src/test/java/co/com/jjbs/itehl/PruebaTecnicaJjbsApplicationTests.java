package co.com.jjbs.itehl;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import co.com.jjbs.itehl.capacitacion.PruebaTecnicaJjbsApplication;
import co.com.jjbs.itehl.capacitacion.domain.Modalidad;
import co.com.jjbs.itehl.capacitacion.service.ModalidadService;


@SpringBootTest(classes = PruebaTecnicaJjbsApplication.class)
class PruebaTecnicaJjbsApplicationTests {
	
	@Autowired
	private ModalidadService modalidadService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void listModalitiesTest() {
		List<Modalidad> listModalities = modalidadService.listModalities();
		assertFalse(listModalities.isEmpty());
	}

}
