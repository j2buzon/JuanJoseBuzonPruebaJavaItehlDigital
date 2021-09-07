package co.com.jjbs.itehl.capacitacion.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jjbs.itehl.capacitacion.domain.Curso;
import co.com.jjbs.itehl.capacitacion.service.CursoService;

@RestController
@RequestMapping(path = "/api/cursos", produces = MediaType.APPLICATION_JSON_VALUE)
public class CursoRestController {

	@Autowired
	private CursoService cursoRepository;
	
	@GetMapping
	public ResponseEntity<List<Curso>> getCourses() {
		return new ResponseEntity<>(cursoRepository.listCourses(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/modalidad/{id}")
	public ResponseEntity<List<Curso>> getCoursesByModality(@PathVariable("id") String modalityId) {
		return new ResponseEntity<>(cursoRepository.listCoursesByModality(modalityId), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Curso> getCourseById(@PathVariable("id") String courseId) {
		Curso course = cursoRepository.findCourseById(courseId);
		if(course!=null)
			return new ResponseEntity<>(course, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping
	public ResponseEntity<Curso> saveCourse(@RequestBody Curso course){
		return new ResponseEntity<>(cursoRepository.saveCourse(course), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateCourse(@RequestBody Curso course){
		cursoRepository.updateCourse(course);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
