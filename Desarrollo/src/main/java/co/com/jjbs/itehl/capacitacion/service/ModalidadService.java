package co.com.jjbs.itehl.capacitacion.service;

import java.util.List;

import co.com.jjbs.itehl.capacitacion.domain.Modalidad;

public interface ModalidadService {
	
	public List<Modalidad> listModalities();
	
	public Modalidad saveModality(Modalidad modalidad);

}
