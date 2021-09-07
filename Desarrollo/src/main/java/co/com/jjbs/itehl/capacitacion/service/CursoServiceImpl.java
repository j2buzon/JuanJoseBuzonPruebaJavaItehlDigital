package co.com.jjbs.itehl.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jjbs.itehl.capacitacion.domain.Curso;
import co.com.jjbs.itehl.capacitacion.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> listCourses() {
		return cursoRepository.findAll();
	}
	
	public List<Curso> listCoursesByModality(String idModality) {
		return cursoRepository.findByModalidad(idModality);
	}
	public Curso findCourseById(String courseId) {
		return cursoRepository.findById(courseId).orElse(null);
	}
	public Curso saveCourse(Curso course) {
		return cursoRepository.insert(course);
	}
	
	public void updateCourse(Curso course) {
		cursoRepository.save(course);
	}

}
