package co.com.jjbs.itehl.capacitacion.controller.rest.facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.com.jjbs.itehl.capacitacion.domain.Curso;
import co.com.jjbs.itehl.capacitacion.domain.Descuento;
import co.com.jjbs.itehl.capacitacion.domain.Modalidad;

@Component
public class CapacitacionAPIFacadeImpl implements CapacitacionAPIFacade {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Override
	public List<Modalidad> listModalities() {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		Modalidad[] modalities = restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/modalidades", Modalidad[].class);
		return Arrays.asList(modalities);
	}

	@Override
	public Modalidad saveModality(Modalidad modalidad) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/modalidades", modalidad, Modalidad.class);
	}

	@Override
	public List<Curso> listCourses() {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		Curso[] courses = restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos", Curso[].class);
		return Arrays.asList(courses);
	}
	
	@Override
	public List<Curso> listCoursesByModality(String idModality) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		Curso[] courses = restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos/modalidad/" + idModality, Curso[].class);
		return Arrays.asList(courses);
	}
	
	@Override
	public Curso findCourseById(String courseId) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos/" + courseId, Curso.class);
	}
	
	@Override
	public Curso saveCourse(Curso curso) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos", curso, Curso.class);
	}
	
	@Override
	public void updateCourse(Curso curso) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos", curso, Curso.class);
	}

	@Override
	public List<Descuento> listDiscount() {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		Descuento[] modalities = restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/descuentos", Descuento[].class);
		return Arrays.asList(modalities);
	}

	@Override
	public Descuento saveDiscount(Descuento descuento) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/descuentos", descuento, Descuento.class);
	}

}
