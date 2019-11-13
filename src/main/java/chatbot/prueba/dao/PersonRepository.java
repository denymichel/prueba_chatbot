package chatbot.prueba.dao;

import chatbot.prueba.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Persona, Integer>{

}
