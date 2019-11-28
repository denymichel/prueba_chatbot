package chatbot.prueba.bl;

       import chatbot.prueba.dao.PersonRepository;
       import chatbot.prueba.dao.UserRepository;
       import chatbot.prueba.domain.Persona;
       import chatbot.prueba.domain.Usuarios;
       import chatbot.prueba.dto.Estatus;
       import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.telegram.telegrambots.meta.api.objects.Update;
        import org.telegram.telegrambots.meta.api.objects.User;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

@Service
public class BotBl {

    private static final Logger LOGGER = LoggerFactory.getLogger(BotBl.class);

    private UserRepository userRepository;
    private PersonRepository personRepository;

    @Autowired
    public BotBl(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    public List<String> processUpdate(Update update) {
        LOGGER.info("Recibiendo update {} ", update);
        List<String> result = new ArrayList<>();
        // Si es la primera vez pedir una imagen para su perfil
        if (initUser(update.getMessage().getFrom())) {
            LOGGER.info("Primer inicio de sesion para: {} ",update.getMessage().getFrom() );
            result.add("Por favor ingrese una imagen para su foto de perfil");
        } else { // Mostrar el menu de opciones
            LOGGER.info("Dando bienvenida a: {} ",update.getMessage().getFrom() );
            result.add("Bienvenido al Bot");
        }

        //continueChatWihtUser(CpUser, CpChat)


        return result;
    }


    private void coninueChatWithUSer(Usuarios usuarios) {
        // Ver donde se quedo el Usuario
        // continuear co conversacion
    }
    /**
     * Si es la primera vez que el usuario conversa con el bot, se guarda su información en BBDD.
     * A futuro ademas de guardar la información captura el ultimo estado de la conversación.
     * @param user
     * @return first time login
     */
    private boolean initUser(User user) {
        boolean result = false;
        Usuarios usuarios = userRepository.findByUsuario(user.getId().toString());
        if (usuarios == null) {
            Persona persona = new Persona();
            persona.setNombres(user.getFirstName());
            persona.setApellidos(user.getLastName());
           // persona.setCi(user.get);
          //  persona.setTelefono(user.getTelefono());
            persona.setEstatus(Estatus.ACTIVE.getEstatus());
            persona.setTxHost("localhost");
            persona.setTxUsuario("admin");
            persona.setTxFecha(new Date());
            personRepository.save(persona);
            usuarios = new Usuarios();
            usuarios.setUsuario(user.getId().toString());
            usuarios.setIdPersona(persona);
            usuarios.setTxHost("localhost");
            usuarios.setTxUsuario("admin");
            usuarios.setTxFecha(new Date());
           userRepository.save(usuarios);
            result = true;
        }
        return result;
    }

}
