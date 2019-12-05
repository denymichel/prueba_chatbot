package chatbot.prueba.dao;

import chatbot.prueba.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Persona, Integer>{

    List<Persona> findByStatus(int status);
}
