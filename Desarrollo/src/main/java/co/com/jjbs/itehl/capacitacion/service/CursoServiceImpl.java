package co.com.jjbs.itehl.capacitacion.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.com.jjbs.itehl.capacitacion.domain.Curso;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	public List<Curso> listCourses() {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		Curso[] courses = restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos", Curso[].class);
		return Arrays.asList(courses);
	}
	
	public List<Curso> listCoursesByModality(String idModality) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		Curso[] courses = restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos/modalidad/" + idModality, Curso[].class);
		return Arrays.asList(courses);
	}
	public Curso findCourseById(String courseId) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos/" + courseId, Curso.class);
	}
	public Curso saveCourse(Curso curso) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos", curso, Curso.class);
	}
	
	public void updateCourse(Curso curso) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/cursos", curso, Curso.class);
	}

}
