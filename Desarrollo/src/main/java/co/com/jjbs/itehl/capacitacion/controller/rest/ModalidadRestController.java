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

import co.com.jjbs.itehl.capacitacion.domain.Modalidad;
import co.com.jjbs.itehl.capacitacion.repository.ModalidadRepository;

@RestController
@RequestMapping(path = "/api/modalidades", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModalidadRestController {

	@Autowired
	private ModalidadRepository modalidadRepository;
	
	@GetMapping
	public ResponseEntity<List<Modalidad>> getModalities(){
		return new ResponseEntity<>(modalidadRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Modalidad> saveModality(@RequestBody Modalidad modality){
		return new ResponseEntity<>(modalidadRepository.save(modality), HttpStatus.OK);
	}

}
