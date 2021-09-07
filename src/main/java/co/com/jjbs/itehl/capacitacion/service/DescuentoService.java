package co.com.jjbs.itehl.capacitacion.service;

import java.util.List;

import co.com.jjbs.itehl.capacitacion.domain.Descuento;

public interface DescuentoService {
	
	public List<Descuento> listDiscount();
	
	public Descuento saveDiscount(Descuento descuento);

}
