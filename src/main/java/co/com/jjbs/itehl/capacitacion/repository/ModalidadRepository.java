package co.com.jjbs.itehl.capacitacion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.com.jjbs.itehl.capacitacion.domain.Modalidad;

@Repository
public interface ModalidadRepository extends MongoRepository<Modalidad, String> {

}
