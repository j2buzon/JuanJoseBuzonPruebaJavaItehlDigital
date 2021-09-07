package co.com.jjbs.itehl.capacitacion.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jjbs.itehl.capacitacion.domain.Descuento;
import co.com.jjbs.itehl.capacitacion.service.DescuentoService;

@RestController
@RequestMapping(path = "/api/descuentos", produces = MediaType.APPLICATION_JSON_VALUE)
public class DescuentoRestController {
	
	@Autowired
	private DescuentoService descuentoService;
	
	@GetMapping
	public ResponseEntity<List<Descuento>> getDiscounts(){
		return new ResponseEntity<>(descuentoService.listDiscount(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Descuento> saveDiscount(@RequestBody Descuento discount){
		return new ResponseEntity<>(descuentoService.saveDiscount(discount), HttpStatus.OK);
	}
	

}
