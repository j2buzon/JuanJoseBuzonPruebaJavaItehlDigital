package co.com.jjbs.itehl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import co.com.jjbs.itehl.capacitacion.PruebaTecnicaJjbsApplication;
import co.com.jjbs.itehl.capacitacion.domain.Curso;
import co.com.jjbs.itehl.capacitacion.domain.Descuento;
import co.com.jjbs.itehl.capacitacion.domain.Modalidad;
import co.com.jjbs.itehl.capacitacion.service.CursoService;
import co.com.jjbs.itehl.capacitacion.service.DescuentoService;
import co.com.jjbs.itehl.capacitacion.service.ModalidadService;


@SpringBootTest(classes = PruebaTecnicaJjbsApplication.class)
class PruebaTecnicaJjbsApplicationTests {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private ModalidadService modalidadService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private DescuentoService descuentoService;

	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	void init() {
		List<Modalidad> modalities = new ArrayList<>();
		
		Modalidad modality = new Modalidad();
		modality.setNombre("Privada");
		modality.setDescripcion("Modalidad privada");
		modalities.add(modality);
		
		modality = new Modalidad();
		modality.setNombre("Online");
		modality.setDescripcion("Modalidad en modo virtual");
		modalities.add(modality);
		
		modality = new Modalidad();
		modality.setNombre("OnDemand");
		modality.setDescripcion("Modalidad sobre demanda");
		modalities.add(modality);
		
		mongoTemplate.insert(modalities , "Modalidades");

		Curso curso = new Curso();
		curso.setCosto(new Double(12000));
		curso.setDescripcion("Curso de prueba");
		curso.setDirigidoA("Abierto a todo público");
		curso.setHoras(20);
		curso.setModalidad(mongoTemplate.findOne(Query.query(Criteria.where("nombre").is("OnDemand")), Modalidad.class));
		curso.setNombre("Test Curso");
		
		mongoTemplate.insert(curso , "Cursos");
	}
	
	@Test
	void testListModalitiesShouldReturnModalities() {
		List<Modalidad> listModalities = modalidadService.listModalities();
		assertFalse(listModalities.isEmpty());
	}
	
	@Test
	void testListCourseByModalityShouldReturnCourses() {
		Modalidad modality = mongoTemplate.findOne(Query.query(Criteria.where("nombre").is("OnDemand")), Modalidad.class);
		List<Curso> courses = cursoService.listCoursesByModality(modality.getId());
		assertFalse(courses.isEmpty());
	}
	
	@Test
	void testSaveCourseShouldInsertOneCourse() {
		Curso curso = new Curso();
		curso.setCosto(new Double(12000));
		curso.setDescripcion("Curso de prueba");
		curso.setDirigidoA("Abierto a todo público");
		curso.setHoras(20);
		Modalidad modality = mongoTemplate.findOne(Query.query(Criteria.where("nombre").is("Online")), Modalidad.class);
		curso.setModalidad(modality);
		cursoService.saveCourse(curso);
		assertNotNull(curso.getId());
	}
	
	@Test
	void testSaveDiscountShouldInsertOneDiscount() {
		Curso curso = mongoTemplate.findOne(Query.query(Criteria.where("nombre").is("Test Curso")), Curso.class);;
		Descuento descuento = new Descuento();
		descuento.setCurso(curso);
		descuento.setFechaFinal("31/12/2021");
		descuento.setNombre("Descuento para el Test Curso" );
		descuento.setPais("COL");
		
		descuentoService.saveDiscount(descuento);
		assertNotNull(descuento.getId());
	}

}
