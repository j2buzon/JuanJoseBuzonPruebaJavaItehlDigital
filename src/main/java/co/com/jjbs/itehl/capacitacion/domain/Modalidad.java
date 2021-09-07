package co.com.jjbs.itehl.capacitacion.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Modalidades")
public class Modalidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8872807637935263125L;
	
	@Id
	private String id;
	private String nombre;
	private String descripcion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
