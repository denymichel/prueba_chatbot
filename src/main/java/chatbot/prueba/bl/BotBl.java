package chatbot.prueba.bl;

import chatbot.prueba.dao.ChatRepository;
import chatbot.prueba.dao.PersonRepository;
import chatbot.prueba.dao.UsuariosRepository;
import chatbot.prueba.domain.Chat;
import chatbot.prueba.domain.Persona;
import chatbot.prueba.domain.Usuario;
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
    //anadimos repositorios usuarios, persona y chat
    private UsuariosRepository usuariosRepository;
    private PersonRepository personRepository;
    private ChatRepository chatRepository;

    @Autowired
    public BotBl(UsuariosRepository usuariosRepository, PersonRepository personRepository, ChatRepository chatRepository) {
        this.usuariosRepository = usuariosRepository;
        this.personRepository = personRepository;
        this.chatRepository = chatRepository;
    }






 //This method process and update when a user is send a message to the chatbot
 public List<String> processUpdate(Update update) {
  LOGGER.info("Recibiendo update {} ", update);
  List<String> chatResponse = new ArrayList<>();
  Usuario usuario = initUser(update.getMessage().getFrom());
  continueChatWithUser(update, usuario, chatResponse);
  return chatResponse;

 }

 private void continueChatWithUser(Update update, Usuario usuario, List<String> chatResponse) {
  // Obtener el ultimo mensaje que envió el usuario
  Chat lastMessage = chatRepository.findLastChatByUserId(usuario.getIdusuario());
  // Preparo la variable para retornar la respuesta
  String response = null;
  // Si el ultimo mensaje no existe (es la primera conversación)
  if (lastMessage == null) {
   // Retornamos 1
   LOGGER.info("Primer mensaje del usuario botUserId{}", usuario.getBotUserId());
   response="Bienvenido a AsisMedBot" +
           "Soy un asistente automatizado que puedo ayudarte a realizar una reserva medica desde cualquier lugar" +
           "/inicio";
  } else {
   // Si existe convesasción previa iniciamos la variable del ultimo mensaje en 1
   int lastMessageInt = 0;
   try {
    // Intenemos obtener el ultimo mensaje retornado y lo convertimos a entero.
    // Si la coversin falla en el catch retornamos 1
    lastMessageInt = Integer.parseInt(lastMessage.getOutMessage());
    response = "" + (lastMessageInt + 1);
   } catch (NumberFormatException nfe) {
    response = "Hola de nuevo, soy Bender" +
            "para  realizar la reserva, porfvor registrate" +
            "/registro";
   }
  }
  LOGGER.info("PROCESSING IN MESSAGE: {} from user {}" ,update.getMessage().getText(), usuario.getIdusuario());
  // Creamos el objeto CpChat con la respuesta a la presente conversación.
  Chat chat = new Chat();
  chat.setIdusuario(usuario);
  chat.setInMessage(update.getMessage().getText());
  chat.setOutMessage(response);
  chat.setMsgFecha(new Date()); //FIXME Obtener la fecha del campo entero update.getMessage().
  chat.setTxDate(new Date());
  chat.setTxUser(usuario.getIdusuario().toString());
  chat.setTxHost(update.getMessage().getChatId().toString());
  // Guardamos en base dedatos
  chatRepository.save(chat);
  // Agregamos la respuesta al chatResponse.
  chatResponse.add(response);
 }



 private Usuario  initUser(User user){
// boolean result = false;
 //User user = update.getMessage().getFrom();
 Usuario usuario = usuariosRepository.findByBotUserId(user.getId().toString());
 if(usuario==null){
 Persona persona = new Persona();
 persona.setNombre(user.getFirstName());

 if(user.getLastName() == null){
 persona.setApellido("-");
 }
 else{
 persona.setNombre(user.getLastName());
 }
 persona.setStatus(Estatus.ACTIVE.getEstatus());
 persona.setTxHost("localhost");
 persona.setTxUser("admin");
 persona.setTxDate(new Date());
 personRepository.save(persona);
 usuario = new Usuario();
 usuario.setBotUserId(user.getId().toString());

 usuario.setIdpersona(persona);
 usuario.setTxHost("localhost");
 usuario.setTxUser("admin");
 usuario.setTxDate(new Date());
 usuariosRepository.save(usuario);
// result = true;
 }
 return usuario;
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

}

