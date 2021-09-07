package co.com.jjbs.itehl.capacitacion.controller.rest.facade;

import java.util.List;

import co.com.jjbs.itehl.capacitacion.domain.Curso;
import co.com.jjbs.itehl.capacitacion.domain.Descuento;
import co.com.jjbs.itehl.capacitacion.domain.Modalidad;

public interface CapacitacionAPIFacade {

	public List<Modalidad> listModalities();

	public Modalidad saveModality(Modalidad modalidad);
	
	public List<Curso> listCourses();
	
	public List<Curso> listCoursesByModality(String idModality);
	
	public Curso findCourseById(String courseId);
	
	public Curso saveCourse(Curso curso);
	
	public void updateCourse(Curso curso);
	
	public List<Descuento> listDiscount();
	
	public Descuento saveDiscount(Descuento descuento);

}
