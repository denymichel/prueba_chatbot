
package chatbot.prueba;

import chatbot.prueba.bl.PersonaBl;
import chatbot.prueba.bl.UsuariosBl;
import chatbot.prueba.dto.PersonaDto;
import chatbot.prueba.dto.UsuariosDto;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class AsisMedBot extends TelegramLongPollingBot {

    private PersonaBl personaBl=new PersonaBl();
    public static UsuariosDto usuariosDto=new UsuariosDto();
    public static PersonaDto personaDto=new PersonaDto();

    private ArrayList<Long[]> data=new ArrayList<>();

    private final static Logger LOGGER = Logger.getLogger(AsisMedBot.class.getName());

    @Override
    public void onUpdateReceived(Update update) {
         if(newChat(update.getMessage().getChatId())){
            addId(update.getMessage().getChatId());
            LOGGER.info("Id added: "+update.getMessage().getChatId());
        }
          LOGGER.info("Id already exists"+update.getMessage().getChatId());
        if (update.hasMessage() && update.getMessage().hasText()) {

        }
    }

    @Override
    public String getBotUsername() {
        return "AsisMedBot";
    }

    @Override
    public String getBotToken() {
        return "965898434:AAFYisxZkAsAWykdChxs9DNy1ceCADAmogo";
    }

    //registro

    private void ReplyMessage(Message message) {
        String message_text = message.getText();
        long chat_id = message.getChatId();
        int position=getId(chat_id);
        if ((message_text.equals("/iniciar") || data.get(position)[3].equals(2L)) ) {
            if(!register(chat_id, position, message_text) && data.get(position)[1].equals(0L)){
                LOGGER.info("Id registering");
            }else{

                createUserType(chat_id); //metodo que manda un mensaje "Como desea entrar?"
            }
        }
      if (((message_text.equals("/registrar_persona") || data.get(position)[3].equals(1L))) && data.get(position)[1].equals(2L)) {
            data.get(position)[3]= Long.valueOf(1);
            data.get(position)[2]= Long.valueOf(personaBl.personaRegistro(message_text, chat_id, Math.toIntExact(data.get(position)[2]), personaDto, new AsisMedBot()));

            if (data.get(position)[2].equals(0L)) data.get(position)[3]= Long.valueOf(0);
        }

        if (message_text.equals("Paciente")){
            sendMessage(chat_id, "Usted entro como:"+message_text);
            data.get(position)[1]= Long.valueOf(2);
            LOGGER.info(data.get(position)[0]+" is in Carpooler mode");
        }

    }

    // devuelve la posición del Id buscado
    private int getId(long chat_id) {
        int position=0;
        for(int id=0; id<data.size(); id++){
            if(data.get(id)[0]==chat_id){
                position=id;
            }
        }
        return position;
    }

    // Aquí envía un mensaje al usuario y elimina cualquier teclado personalizado
    public void sendMessage(long chat_id, String text){
        SendMessage message = new SendMessage() // creando objeto mensaje
                .setChatId(chat_id)
                .setText(text);
        ReplyKeyboardRemove keyboardMarkupRemove = new ReplyKeyboardRemove();
        message.setReplyMarkup(keyboardMarkupRemove);
        try {
            execute(message); //Enviando nuestro mensaje objeto al usuario
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

//aqui la persona decide registrarse
    private void createUserType(long chat_id) {
        SendMessage message = new SendMessage()
                .setChatId(chat_id)
                .setText("Bienvenido, para seguir con el servicio debe registrarse:");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("Registro");

        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



   //agregando al usuario al Arraylist
    private void addId(Long chatId) {
        Long[] dataCreation = new Long[4];
        //ChatId
        dataCreation[0]=chatId;
        dataCreation[1]=0L;
        dataCreation[2]=-1L;
        dataCreation[3]=0L;
        data.add(dataCreation);
    }

    // Esta búsqueda si el ChatId existe en el arrayList
    private boolean newChat(Long chatId) {
        boolean newChat=true;
        for (Long[] datum : data) {
            if (datum[0].equals(chatId)) {
                LOGGER.info("Id encontrado: " + datum[0]);
                newChat = false;
            }
        }
        return newChat;
    }

    //registro del usuario
    private boolean register(Long chatId, int position, String message_text) {
        boolean registered=false;
        if (data.get(position)[2].equals(0L)){
            registered=true;
            data.get(position)[2]= Long.valueOf(0L);
            data.get(position)[3]= Long.valueOf(0);
        }else{
            data.get(position)[3] = Long.valueOf(2);
            // data.get(position)[2] = userBl.userRegister(message_text, chatId, Math.toIntExact(data.get(position)[2]), personDto, new CarpoolingBot());
        }
        return registered;
    }

}