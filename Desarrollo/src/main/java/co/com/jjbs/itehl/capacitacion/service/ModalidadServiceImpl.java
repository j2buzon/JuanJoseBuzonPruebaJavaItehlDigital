package co.com.jjbs.itehl.capacitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jjbs.itehl.capacitacion.domain.Modalidad;
import co.com.jjbs.itehl.capacitacion.repository.ModalidadRepository;

@Service
public class ModalidadServiceImpl implements ModalidadService {
	
	@Autowired
	private ModalidadRepository modalidadRepository;

	@Override
	public List<Modalidad> listModalities() {
		return modalidadRepository.findAll();
	}

	@Override
	public Modalidad saveModality(Modalidad modality) {
		return modalidadRepository.save(modality);
	}

}
