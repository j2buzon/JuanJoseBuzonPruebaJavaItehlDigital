package co.com.jjbs.itehl.capacitacion.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeWebController {
	
	@GetMapping(value = "/")
	public String homePage(Model model) {
		return "home";
	}

}
