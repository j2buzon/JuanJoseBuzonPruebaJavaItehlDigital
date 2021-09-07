package co.com.jjbs.itehl.capacitacion.service;

import java.util.List;

import co.com.jjbs.itehl.capacitacion.domain.Curso;

public interface CursoService {
	
	public List<Curso> listCourses();
	
	public List<Curso> listCoursesByModality(String idModality);
	
	public Curso findCourseById(String courseId);
	
	public Curso saveCourse(Curso curso);
	
	public void updateCourse(Curso curso);

}
