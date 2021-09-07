package co.com.jjbs.itehl.capacitacion.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.com.jjbs.itehl.capacitacion.domain.Modalidad;

@Service
public class ModalidadServiceImpl implements ModalidadService {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Override
	public List<Modalidad> listModalities() {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		Modalidad[] modalities = restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/modalidades", Modalidad[].class);
		return Arrays.asList(modalities);
	}

	@Override
	public Modalidad saveModality(Modalidad modalidad) {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/modalidades", modalidad, Modalidad.class);
	}

}
