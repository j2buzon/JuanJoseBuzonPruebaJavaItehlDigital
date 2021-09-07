package co.com.jjbs.itehl.capacitacion.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.com.jjbs.itehl.capacitacion.domain.Curso;
import co.com.jjbs.itehl.capacitacion.domain.Descuento;

@Service
public class DescuentoServiceImpl implements DescuentoService {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private CursoService cursoService;

	@Override
	public List<Descuento> listDiscount() {
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		Descuento[] modalities = restTemplate.getForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/descuentos", Descuento[].class);
		return Arrays.asList(modalities);
	}

	@Override
	public Descuento saveDiscount(Descuento descuento) {
		Curso course = cursoService.findCourseById(descuento.getCurso().getId());
		descuento.setModalidad(course.getModalidad());
		switch (descuento.getModalidad().getNombre()) {
		case "OnDemand":
			descuento.setValorDescuento(course.getCosto()*0.30);
			break;
			
		case "Online":
			descuento.setValorDescuento(course.getCosto()*0.20);
			break;

		default:
			descuento.setValorDescuento(course.getCosto()*0.10);
			break;
		}
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(null).build().toUriString();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(baseUrl + webApplicationContext.getServletContext().getContextPath() + "/api/descuentos", descuento, Descuento.class);
	}

}
