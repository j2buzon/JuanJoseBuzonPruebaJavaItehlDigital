package co.com.jjbs.itehl.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jjbs.itehl.capacitacion.domain.Curso;
import co.com.jjbs.itehl.capacitacion.domain.Descuento;
import co.com.jjbs.itehl.capacitacion.repository.CursoRepository;
import co.com.jjbs.itehl.capacitacion.repository.DescuentoRepository;

@Service
public class DescuentoServiceImpl implements DescuentoService {

	@Autowired
	private DescuentoRepository descuentoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Descuento> listDiscount() {
		return descuentoRepository.findAll();
	}

	@Override
	public Descuento saveDiscount(Descuento discount) {
		Curso course = cursoRepository.findById(discount.getCurso().getId()).get();
		discount.setModalidad(course.getModalidad());
		switch (discount.getModalidad().getNombre()) {
		case "OnDemand":
			discount.setValorDescuento(course.getCosto()*0.30);
			break;
			
		case "Online":
			discount.setValorDescuento(course.getCosto()*0.20);
			break;

		default:
			discount.setValorDescuento(course.getCosto()*0.10);
			break;
		}
		return descuentoRepository.save(discount);
	}

}
