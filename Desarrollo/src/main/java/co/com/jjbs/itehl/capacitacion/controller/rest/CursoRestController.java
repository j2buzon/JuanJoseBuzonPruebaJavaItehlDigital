package co.com.jjbs.itehl.capacitacion.controller.rest;

import java.util.List;
import java.util.Optional;

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
import co.com.jjbs.itehl.capacitacion.repository.CursoRepository;

@RestController
@RequestMapping(path = "/api/cursos", produces = MediaType.APPLICATION_JSON_VALUE)
public class CursoRestController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public ResponseEntity<List<Curso>> getCourses() {
		List<Curso> courses = cursoRepository.findAll();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	@GetMapping(path = "/modalidad/{id}")
	public ResponseEntity<List<Curso>> getCoursesByModality(@PathVariable("id") String modalityId) {
		List<Curso> courses = cursoRepository.findByModalidad(modalityId);
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Curso> getCourseById(@PathVariable("id") String courseId) {
		Optional<Curso> course = cursoRepository.findById(courseId);
		if(course.isPresent())
			return new ResponseEntity<>(course.get(), HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping
	public ResponseEntity<Curso> saveCourse(@RequestBody Curso course){
		course = cursoRepository.insert(course);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Curso> updateCourse(@RequestBody Curso course){
		course = cursoRepository.save(course);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

}
