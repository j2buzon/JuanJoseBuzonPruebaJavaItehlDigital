package co.com.jjbs.itehl.capacitacion.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.jjbs.itehl.capacitacion.domain.Descuento;
import co.com.jjbs.itehl.capacitacion.service.CursoService;
import co.com.jjbs.itehl.capacitacion.service.DescuentoService;
import co.com.jjbs.itehl.capacitacion.service.ModalidadService;

@Controller
public class DescuentoWebController {

	@Autowired
	private ModalidadService modalidadService;

	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private DescuentoService descuentoService;
	
	@GetMapping("/descuentos")
	public String listDiscounts(Model model) {
		model.addAttribute("discounts", descuentoService.listDiscount());
		return "discounts/list";
	}
	
	@GetMapping(path = "/add-discount")
	public String addDiscount(Model model) {
		model.addAttribute("modalities", modalidadService.listModalities());
		model.addAttribute("courses", cursoService.listCourses());
		model.addAttribute("discount", new Descuento());
		return "discounts/discount";
	}
	
	@PostMapping(path = "/add-discount")
	public String saveDiscount(Descuento descuento) {
		descuentoService.saveDiscount(descuento);
		return "redirect:/discounts";
	}

}
