package co.com.jjbs.itehl.capacitacion.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.jjbs.itehl.capacitacion.domain.Curso;

public interface CursoRepository extends MongoRepository<Curso, String>{
	
	List<Curso> findByModalidad(String modalidad);

}
