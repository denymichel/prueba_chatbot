package chatbot.prueba.bl;

import chatbot.prueba.dao.UsuariosRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuariosBl {

    UsuariosRepository usuariosRepository;
/**
    public Usuarios findUserByTelegramUserId(Update update){
        Usuarios usuarios = usuariosRepository.findByUserId(update.getMessage().getFrom().getId().toString());
        return usuarios;
    }
*/


}
