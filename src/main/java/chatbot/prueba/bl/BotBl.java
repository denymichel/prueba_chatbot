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
    //anadimos repositorios usuarios, persona,
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

 /**Si es la primera vez pedir una imagen para su perfil
  List<String> result = new ArrayList<>();
  if (initUser(update.getMessage().getFrom())) {
            LOGGER.info("Primer inicio de sesion para: {} ",update.getMessage().getFrom() );
            result.add("Por favor ingrese una imagen para su foto de perfil");
        } else { // Mostrar el menu de opciones
            LOGGER.info("Dando bienvenida a: {} ",update.getMessage().getFrom() );
            result.add("Bienvenido al Bot");
        }
    return result;
*/
  }


 /**
 public int processUpdate(Update update){
  LOGGER.info("Receiving an update from user {}",update);
  int response = 0;
  if(initUser(update)){
   LOGGER.info("First time using app for: {} ",update.getMessage().getFrom() );
   response = 1;
  }
  else{
   List<Persona> allCars;
   Boolean validation;
   String newLastName,newFirstName,newCellphone,newCI,newBrand,newModel,newEnrollmentNumber,newPassenger;
   Integer idUser;
  // CpCar newCar;
   Persona persona;
   Usuario usuario = usuariosRepository.findByBotUserId(update.getMessage().getFrom().getId().toString());
   int last_conversation = usuario.getIdusuario();
   //What happens when chatbot receives a response to a conversation "last conversation"
   switch (last_conversation){
    //****************************************\\
    //Here is the initial registering\\
    //****************************************\\
    case 1:
     idUser = usuario.getIdpersona().getIdpersona();
     LOGGER.info("Buscando el id {} en CpPerson",idUser);
     persona = personRepository.findById(idUser).get();
     newLastName = update.getMessage().getText();
     //See if the Last name only has alphabetical Letters and spaces
     validation = isOnlyAlphabeticalCharacters(newLastName);
     if(validation){
      persona.setApellido(newLastName);
      personRepository.save(persona);
      response = 2;
     }
     else{
      response = 4;
     }

     break;
    case 2:
     idUser = usuario.getIdpersona().getIdpersona();
     LOGGER.info("Buscando el id {} en CpPerson",idUser);
     persona = personRepository.findById(idUser).get();
     newFirstName = update.getMessage().getText();
     validation = isOnlyAlphabeticalCharacters(newFirstName);
     if(validation){
      persona.setNombre(newFirstName);
      personRepository.save(persona);
      response = 3;
     }
     else{
      response = 5;
     }
     break;
    //****************************************\\
    //Here the user can correct its mistakes on the registering\\
    //****************************************\\
    case 4:
     //Try again to enter Last Name
     idUser = usuario.getIdpersona().getIdpersona();
     persona = personRepository.findById(idUser).get();
     newLastName = update.getMessage().getText();
     validation = isOnlyAlphabeticalCharacters(newLastName);
     if(validation){
      persona.setApellido(newLastName);
      personRepository.save(persona);
      response = 2;
     }
     else{

      response = 4;
     }
     break;
    case 5:
     //Try again to enter First Name
     idUser = usuario.getIdpersona().getIdpersona();
     persona = personRepository.findById(idUser).get();
     newFirstName = update.getMessage().getText();
     validation = isOnlyAlphabeticalCharacters(newFirstName);
     if(validation){
      persona.setNombre(newFirstName);
      personRepository.save(persona);
      response = 3;
     }
     else{
      response = 5;
     }
     break;
    //****************************************\\
    //Here starts the carpooler part\\
    //****************************************\\
    case 6:
     idUser = usuario.getIdpersona().getIdpersona();
     LOGGER.info("Buscando el id {} en CpPerson",idUser);
     persona = personRepository.findById(idUser).get();
     newCellphone = update.getMessage().getText();
     if(isValidCellphone(newCellphone)){
      persona.setTelefono(newCellphone);
      personRepository.save(persona);
      response = 7;
     }
     else{
      response = 8;
     }
     break;
    case 7:
     idUser = usuario.getIdpersona().getIdpersona();
     LOGGER.info("Buscando el id {} en CpPerson",idUser);
     persona = personRepository.findById(idUser).get();
     newCI = update.getMessage().getText();
     if(isValidCI(newCI)){
      persona.setCi(newCI);
      personRepository.save(persona);
      response = 10;
     }
     else{
      response = 9;
     }
     break;

    case 8:
     idUser = usuario.getIdpersona().getIdpersona();
     persona = personRepository.findById(idUser).get();
     newCellphone = update.getMessage().getText();
     if(isValidCellphone(newCellphone)){
      persona.setTelefono(newCellphone);
      personRepository.save(persona);
      response = 7;
     }
     else{
      response = 8;
     }
     break;

    case 9:
     idUser = usuario.getIdpersona().getIdpersona();
     persona = personRepository.findById(idUser).get();
     newCI = update.getMessage().getText();
     if(isValidCI(newCI)){
      persona.setCi(newCI);
      personRepository.save(persona);
      response = 10;
     }
     else{
      response = 9;
     }
     break;
    //****************************************\\
    //Here is the Menu for Carpooler\\
    //****************************************\\
    case 10:
     idUser = usuario.getIdpersona().getIdpersona();
     LOGGER.info("Buscando el id {} en CpPerson",idUser);
     persona = personRepository.findById(idUser).get();
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

    case 19:
     response = 10;
     break;

   }
   usuario.setIdusuario(response);
   usuariosRepository.save(usuario);
  }
  return response;
 }
*/



 /**
   Procesa el chat con UN usuario
    update El mensaje que envio el usuario
    Usuario El usuario con el que se esta interactuando
   chatResponse Los mensajes que se desean retornar al usuario.
  */
 private void continueChatWithUser(Update update, Usuario usuario, List<String> chatResponse) {
  // Obtener el ultimo mensaje que envió el usuario
  Chat lastMessage = chatRepository.findLastChatByUserId(usuario.getIdusuario());
  // Preparo la variable para retornar la respuesta

  String response = null;
  // Si el ultimo mensaje no existe (es la primera conversación)

  if (lastMessage == null) {
   // Retornamos 1
   LOGGER.info("Primer mensaje del usuario botUserId{}", usuario.getBotUserId());
   response = "bienvenido ";
  } else {
   // Si existe convesasción previa iniciamos la variable del ultimo mensaje en 1
   int lastMessageInt = 0;
   try {
    // Intenemos obtener el ultimo mensaje retornado y lo convertimos a entero.
    // Si la coversin falla en el catch retornamos 1
    lastMessageInt = Integer.parseInt(lastMessage.getOutMessage());
    response = "" + (lastMessageInt + 1);
   } catch (NumberFormatException nfe) {
    response = "hola de nuevo ";
   }
  }

  /**
  Integer idUser;
  Persona persona;
  int responseuno = 0;

  int lastMessage2 = usuario.getIdusuario();
  switch (lastMessage2){
   case 10:
    idUser = usuario.getIdpersona().getIdpersona();
    LOGGER.info("Buscando el id {} en CpPerson",idUser);
    persona = personRepository.findById(idUser).get();
    responseuno = 10;
    //Here is the menu for the carpooler
    if(update.getMessage().getText().equals("Registrar Vehículo")){
     responseuno = 11;
    }
    if(update.getMessage().getText().equals("Ver Vehículos")){
     responseuno = 19;
    }
    if(update.getMessage().getText().equals("Registrar Viaje")){
     responseuno = 10;
    }
    if(update.getMessage().getText().equals("Ver viajes")){
     responseuno = 10;
    }
    if(update.getMessage().getText().equals("Volver al Menú Principal")){
     responseuno = 3;
    }
    break;
  }
*/

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


//NUEVO USUARIO
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

 /**
 private boolean isValidCellphone(String text){
  Boolean validation = true;
  for(int i=0;i<text.length();i++){
   char ch = text.charAt(i);
   if(!Character.isDigit(ch)){
    validation = false;
   }
  }
  if(isOnlySpaces(text)){
   validation = false;
  }
  if(text.length()!=8){
   validation = false;
  }
  if(text.charAt(0)!='6' && text.charAt(0)!='7'){
   validation = false;
  }
  return validation;
 }
*/

 private boolean isValidCI(String text){
  //7-8 numbers or 7-8 numbers plus a alphabetical character
  Boolean validation = true;
  int lenght = text.length();
  char lastCharacter = text.charAt(lenght-1);
  if(Character.isDigit(lastCharacter) || Character.isAlphabetic(lastCharacter)){
   for(int i=0;i<lenght-1;i++){
    char ch = text.charAt(i);
    if(!Character.isDigit(ch)){
     validation = false;
     break;
    }
   }
  }
  else{
   validation = false;
  }
  if(isOnlySpaces(text)){
   validation = false;
  }
  return validation;
 }

 private boolean isOnlyAlphaNumeric(String text){
  boolean validation = true;
  for(int i=0;i<text.length();i++){
   char ch = text.charAt(i);
   if(!Character.isAlphabetic(ch) && !Character.isDigit(ch)){
    validation = false;
    break;
   }
  }
  return validation;
 }

}

