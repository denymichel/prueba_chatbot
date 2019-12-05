package chatbot.prueba.dao;

import chatbot.prueba.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuarios, Integer> {

    Usuarios findByUsuario(String usuario);
}
