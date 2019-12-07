package chatbot.prueba.bot;

import chatbot.prueba.AsisMedBot;
import chatbot.prueba.bl.BotBl;
import chatbot.prueba.bl.PersonaBl;
import chatbot.prueba.bl.UsuariosBl;
import chatbot.prueba.domain.Persona;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class MainBot extends TelegramLongPollingBot{

    private PersonaBl personaBl;
    private UsuariosBl usuariosBl;
    private BotBl botBl;

    private final static Logger LOGGER = Logger.getLogger(AsisMedBot.class.getName());

    public MainBot(PersonaBl personaBl, UsuariosBl usuariosBl, BotBl botBl){
        this.personaBl = personaBl;
        this.usuariosBl = usuariosBl;
        this.botBl = botBl;
    }


    @Override
    public void onUpdateReceived(Update update) {

        ////devuelve el id y datos de persona de la BD
          System.out.println(update);
          update.getMessage().getFrom().getId();
        //

        if (update.hasMessage() && update.getMessage().hasText()) {
           // Persona persona= personaBl.findPersonaById(1);        //sacamos la persona con id 1 de la BD
              // int conversation = botBl.processUpdate(update);
            //   response(conversation,update);

            List<String> messages = botBl.processUpdate(update);

            for(String messageText: messages) {
                SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                        .setChatId(update.getMessage().getChatId())
                        .setText(messageText);
                try {
                    this.execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

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

    private ReplyKeyboardMarkup createReplyKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Registro");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);

        return keyboardMarkup;
    }
    private ReplyKeyboardMarkup createOkMenu(){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        row.add("OK");

        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);

        return keyboardMarkup;

    }
    private ReplyKeyboardMarkup createReplyKeyboardCarpooler() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        row.add("Registrar Paciente");
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }


     public void response(int conversation, Update update) {
     List<String> responses = new ArrayList<>();
     ReplyKeyboardMarkup rkm = null;
     switch (conversation) {

         //Listado registro
         case 1:
             responses.add("Bienvenido a AsisMedBot");
             responses.add("Para usar el ChatBot debes registrarte primero");
             responses.add("Ingresa un nombre");
             break;
         case 2:
             responses.add("Ingresa un apellido");
             break;
         case 3:
             responses.add("Ingresa N° de C.I.");
             break;
         case 4:
             responses.add("Ingresa N° de celular");
             break;

     }
         for(String messageText: responses) {
             SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                     .setChatId(update.getMessage().getChatId())
                     .setText(messageText);
             if(rkm!=null){
                 message.setReplyMarkup(rkm);
             }else{
                 ReplyKeyboardRemove keyboardMarkupRemove = new ReplyKeyboardRemove();
                 message.setReplyMarkup(keyboardMarkupRemove);
             }
             try {
                 this.execute(message);

             } catch (TelegramApiException e) {
                 e.printStackTrace();
             }
         }



     }}
