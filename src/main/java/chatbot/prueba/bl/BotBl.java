package chatbot.prueba.bl;

import chatbot.prueba.dao.PersonRepository;
import chatbot.prueba.dao.UsuariosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotBl {



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
 persona.setTxHost("localhost");
 persona.setTxUsuario("admin");
 persona.setTxFecha(new Date());
 personRepository.save(persona);
 usuarios = new Usuarios();
 usuarios.setUsuario(user.getId().toString());
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

