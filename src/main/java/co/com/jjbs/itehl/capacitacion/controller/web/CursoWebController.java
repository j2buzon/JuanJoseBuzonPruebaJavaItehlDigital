package co.com.jjbs.itehl.capacitacion.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.jjbs.itehl.capacitacion.domain.Curso;
import co.com.jjbs.itehl.capacitacion.service.CursoService;
import co.com.jjbs.itehl.capacitacion.service.ModalidadService;

@Controller
public class CursoWebController {

	@Autowired
	private ModalidadService modalidadService;

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/cursos")
	public String listCourses(Model model) {
		model.addAttribute("courses", cursoService.listCourses());
		return "courses/list";
	}
	
	@GetMapping(path = "/add-curso")
	public String addCourse(Model model) {
		model.addAttribute("modalities", modalidadService.listModalities());
		model.addAttribute("course", new Curso());
		return "courses/course";
	}
	
	@PostMapping(path = "/add-curso")
	public String saveCourse(Curso curso) {
		cursoService.saveCourse(curso);
		return "redirect:/cursos";
	}
	
	@GetMapping(path = "/update-curso")
	public String updateCourse(String id, Model model) {
		model.addAttribute("modalities", modalidadService.listModalities());
		Curso course  = cursoService.findCourseById(id);
		model.addAttribute("course", course);
		return "courses/course";
	}
	
	@PostMapping(path = "/update-curso")
	public String updateCourse(Curso curso) {
		cursoService.updateCourse(curso);
		return "redirect:/cursos";
	}

}
