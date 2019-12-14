package chatbot.prueba.bot;

import chatbot.prueba.AsisMedBot;
import chatbot.prueba.bl.BotBl;
import chatbot.prueba.bl.PersonaBl;
import chatbot.prueba.bl.UsuariosBl;
import chatbot.prueba.domain.Persona;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
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
               ResponseConversation action = botBl.processUpdate(update);
               response(action,update);
        }else if (update.hasCallbackQuery()) {
            ResponseConversation action = botBl.processUpdate(update);
            //switch moved to the response function
            response(action, update);

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


    public void response(ResponseConversation action, Update update){
        int conversation = action.getConversation();
        List<String> responses = new ArrayList<>();
        ReplyKeyboardMarkup rkm=null;
        switch (conversation){
            //****************************************\\
            //Here is the initial registering\\
            //****************************************\\
            case 1:
                responses.add("Bienvenido a Asistente Bot");
                responses.add("Para usar el ChatBot debes registrarte primero");
                responses.add("Ingresa tus apellidos");
                break;
            case 2:
                responses.add("Ingresa tu nombre");
                break;

            case 3:
                responses.add("Error, Ingrese nuevamente sus apellidos");
                responses.add("Solo puede usar letras del alfabeto mayusculas y minusculas, ademas de espacios.");
                break;

            case 4:
                responses.add("Ingrese nuevamente sus Nombres");
                responses.add("Solo puede usar letras del alfabeto mayusculas y minusculas, ademas de espacios.");
                break;

            case 5:
                responses.add("Ingresa su numero de telefono");
                break;

            case 6:
                responses.add("Ingresa su carnet de identidad");
                break;

            case 7:
                responses.add("Error, Ingrese nuevamente su numero de telefono");
                responses.add(".");
                break;

            case 8:
                responses.add("Ingrese nuevamente su carnet de identidad");
                responses.add(".");
                break;

            case 9:
                responses.add("FELICIDADES");
                responses.add("Se registro existosamente.");
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

    }

    private ReplyKeyboardMarkup createReplyKeyboardConfirmation() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add("Si");
        // Add the first row to the keyboard
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("No");
        keyboard.add(row);

        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        return keyboardMarkup;
    }
    //Here the user decides whether it will be a carpooler or a rider and creates a custom keyboard for it
    private ReplyKeyboardMarkup createReplyKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add("Carpooler");
        // Add the first row to the keyboard
        keyboard.add(row);
        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Rider");
        // Add the second row to the keyboard
        keyboard.add(row);
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Corregir registro");
        // Add the second row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        return keyboardMarkup;
    }
    private ReplyKeyboardMarkup createOkMenu(){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add("OK");
        // Add the first row to the keyboard
        keyboard.add(row);
        // Create another keyboard row
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        return keyboardMarkup;
    }
    private ReplyKeyboardMarkup createReplyKeyboardCarpooler() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add("Registrar Vehículo");
        // Add the first row to the keyboard
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("Ver Vehículos");
        keyboard.add(row);
        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Registrar Viaje");
        // Add the second row to the keyboard
        keyboard.add(row);
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Ver Viajes");
        // Add the second row to the keyboard
        keyboard.add(row);
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Volver al Menú Principal");
        // Add the second row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        return keyboardMarkup;
    }

    private ReplyKeyboardMarkup createReplyKeyboardRider() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text

        row.add("Buscar Viaje");
        keyboard.add(row);
        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Ver Viaje");
        // Add the second row to the keyboard
        keyboard.add(row);
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Eliminar Viajes");
        // Add the second row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Volver al Menú Principal");
        // Add the second row to the keyboard
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        return keyboardMarkup;
    }

}
