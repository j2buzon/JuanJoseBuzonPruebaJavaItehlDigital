package co.com.jjbs.itehl.capacitacion.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.jjbs.itehl.capacitacion.controller.rest.facade.CapacitacionAPIFacade;
import co.com.jjbs.itehl.capacitacion.domain.Descuento;

@Controller
public class DescuentoWebController {

	@Autowired
	private CapacitacionAPIFacade capacitacionAPIFacade;
	
	@GetMapping("/descuentos")
	public String listDiscounts(Model model) {
		model.addAttribute("discounts", capacitacionAPIFacade.listDiscount());
		return "discounts/list";
	}
	
	@GetMapping(path = "/add-discount")
	public String addDiscount(Model model) {
		model.addAttribute("modalities", capacitacionAPIFacade.listModalities());
		model.addAttribute("courses", capacitacionAPIFacade.listCourses());
		model.addAttribute("discount", new Descuento());
		return "discounts/discount";
	}
	
	@PostMapping(path = "/add-discount")
	public String saveDiscount(Descuento descuento) {
		capacitacionAPIFacade.saveDiscount(descuento);
		return "redirect:/discounts";
	}

}
