package chatbot.prueba.dao;

import chatbot.prueba.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Persona, Integer>{

<<<<<<< HEAD
    List<Persona> findByStatus(int status);
=======
    List<Persona> findAllByEstatus(int estatus);

>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
}
