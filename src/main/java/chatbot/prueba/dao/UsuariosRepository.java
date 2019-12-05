package chatbot.prueba.dao;

import chatbot.prueba.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario,Integer> {

    // Usuarios findByUsuario(String usuario);
}
