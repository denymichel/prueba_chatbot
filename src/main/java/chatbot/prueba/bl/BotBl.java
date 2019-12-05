package chatbot.prueba.bl;

<<<<<<< HEAD
import chatbot.prueba.dao.PersonRepository;
import chatbot.prueba.dao.UsuariosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotBl {
    //codigo prueba de chatbot almacen
    public int id= 0;
    public String seccion = "";
    public String accion = "";
    public String campo = "";
    public String codigo = "";
    public String codigo_modificar = "";
    public String sucursal = "";
    public String nombre = "";
    public String stock = "";
    public String direccion = "";
    public String celular = "";
    public String tipo = "";
    public String descripcion = "";
    public boolean sw_mensajeMempleados = false;
    public boolean sw_mensajeMProductos = false;
    //fin codigo almacen


    private static final Logger LOGGER = LoggerFactory.getLogger(BotBl.class);
    //anadimos repositorios usuarios, persona,
    private UsuariosRepository usuariosRepository;
    private PersonRepository personRepository;

    @Autowired
    public BotBl(UsuariosRepository usuariosRepository, PersonRepository personRepository) {
        this.usuariosRepository = usuariosRepository;
        this.personRepository = personRepository;
    }





/**
    //This method process and update when a user is send a message to the chatbot
    public int processUpdate(Update update){
        LOGGER.info("Receiving an update from user {}",update);
        int response = 0;
        if(isNewUser(update)){
            LOGGER.info("First time using app for: {} ",update.getMessage().getFrom());
            response = 1;
        }
        else{
            List<Persona> allPersons;
            Boolean validation;
            String newLastName,newFirstName,newCellphone,newCI,newBrand,newModel,newEnrollmentNumber,newPassenger;
            Integer idUser;
            Persona newPerson;
            Persona persona;
            Usuarios usuarios = usuariosRepository.findByUsuario(update.getMessage().getFrom().getId().toString());
            int last_conversation = usuarios.getIdusuarios();
            //What happens when chatbot receives a response to a conversation "last conversation"
            switch (last_conversation){

                case 1:
                    idUser = usuarios.getIdPersona().getIdpersona();
                    LOGGER.info("Buscando el id {} en CpPerson",idUser);
                    persona = personRepository.findById(idUser).get();
                    newLastName = update.getMessage().getText();
                    //See if the Last name only has alphabetical Letters and spaces
                    validation = isOnlyAlphabeticalCharacters(newLastName);
                    if(validation){
                        persona.setApellidos(newLastName);
                        personRepository.save(persona);
                        response = 2;
                    }
                    else{
                        response = 4;
                    }
                    break;

                //****************************************\\
                //Here is the Menu for Carpooler\\
                //****************************************\\
                case 10:
                    idUser = usuarios.getIdPersona().getIdpersona();
                    LOGGER.info("Buscando el id {} en CpPerson",idUser);
              //      persona = personRepository.findById(idUser).get();
                    response = 10;
                    //Here is the menu for the carpooler
                    if(update.getMessage().getText().equals("Registrar Vehículo")){
                        response = 11;
                    }
                    if(update.getMessage().getText().equals("Ver Vehículos")){
                        response = 19;
                    }
                    if(update.getMessage().getText().equals("Registrar Viaje")){
                        response = 10;
                    }
                    if(update.getMessage().getText().equals("Ver viajes")){
                        response = 10;
                    }
                    if(update.getMessage().getText().equals("Volver al Menú Principal")){
                        response = 3;
                    }
                    break;
        }
      }
        return response;
    }


    private boolean isNewUser(Update update){
        boolean response = false;
        User user = update.getMessage().getFrom();
        Usuarios usuarios = usuariosRepository.findByUsuario(user.getId().toString());
        if(usuarios==null){
            Persona persona = new Persona();
            persona.setNombres(user.getFirstName());

            if(user.getLastName() == null){
                persona.setApellidos("-");
            }
            else{
                persona.setNombres(user.getLastName());
            }
            persona.setEstatus(Estatus.ACTIVE.getEstatus());
         //   persona.setCarpool(0);//0 is for a not carpooler user
=======
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
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
            persona.setTxHost("localhost");
            persona.setTxUsuario("admin");
            persona.setTxFecha(new Date());
            personRepository.save(persona);
            usuarios = new Usuarios();
            usuarios.setUsuario(user.getId().toString());
<<<<<<< HEAD
            //usuarios.setBotUserId(user.getId().toString());
       //   cpUser.setChatUserId(update.getMessage().getChatId().toString());
            usuarios.setIdPersona(persona);
       //     usuarios.setConversationId(1);
            usuarios.setTxHost("localhost");
            usuarios.setTxUsuario("admin");
            usuarios.setTxFecha(new Date());
            usuariosRepository.save(usuarios);
            response = true;
        }
        return response;
    }

    private boolean isOnlyAlphabeticalCharacters(String text){
        Boolean validation = true;
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(!Character.isLetter(ch) && ch != ' '){
                validation = false;
                break;
            }
        }
        if(isOnlySpaces(text)){
            validation = false;
        }
        return validation;
    }

    private boolean isOnlySpaces(String text){
        Boolean validation = true;
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(ch != ' '){
                validation = false;
            }
            break;
        }
        return validation;
    }

 */

}

=======
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
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
