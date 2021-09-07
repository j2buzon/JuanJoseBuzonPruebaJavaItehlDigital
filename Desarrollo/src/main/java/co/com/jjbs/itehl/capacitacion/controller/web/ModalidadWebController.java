package co.com.jjbs.itehl.capacitacion.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.jjbs.itehl.capacitacion.controller.rest.facade.CapacitacionAPIFacade;
import co.com.jjbs.itehl.capacitacion.domain.Modalidad;

@Controller
public class ModalidadWebController {
	
	@Autowired
	private CapacitacionAPIFacade capacitacionAPIFacade;
	
	@GetMapping("/modalidades")
	public String listModalidades(Model model) {
		model.addAttribute("modalities", capacitacionAPIFacade.listModalities());
		return "modalities/list";
	}
	
	@GetMapping(path = "modalidad")
	public String addModalidad(Model model) {
		model.addAttribute("modality", new Modalidad());
		return "modalities/modality";
	}
	
	@PostMapping(path = "modalidad")
	public String saveModalidad(Modalidad modalidad) {
		capacitacionAPIFacade.saveModality(modalidad);
		return "redirect:/modalidades";
	}

}
