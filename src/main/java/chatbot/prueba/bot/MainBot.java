package chatbot.prueba.bot;

        import chatbot.prueba.dao.PersonRepository;
        import chatbot.prueba.domain.Persona;
        import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
        import org.telegram.telegrambots.meta.api.objects.Message;
        import org.telegram.telegrambots.meta.api.objects.Update;
        import org.telegram.telegrambots.bots.TelegramLongPollingBot;
        import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
        import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
        import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
        import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

        import java.util.ArrayList;
        import java.util.List;


public class MainBot extends TelegramLongPollingBot{


    PersonRepository personRepository;
    public MainBot(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

/**
    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
           //   setButtons(sendMessage);
            sendMessage(sendMessage);
        }catch(TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        //  Model model = new Model();
          Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/inicio":
                    sendMsg(message, "Hola soy el asistente automatico, en que te puedo ayudar?");
                    break;
                case "/ReservarCitaMedica":
                    sendMsg(message, "Porfavor seleccione una especialidad       " );
                    sendMsg(message,      "/MedicinaGeneral      " +
                            "/Pediatria         " +
                            "/Traumatologia     ");
                    break;
                case "/VerEspecialidades":
                    sendMsg(message, "/MedicinaGeneral");
                    sendMsg(message, "/Pediatria");
                    sendMsg(message, "/Traumatologia");
                default:
            }
        }
    }
*/
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if (update.hasMessage() && update.getMessage().hasText()) {
            Persona persona= personRepository.findById(1).get();        //sacamos la persona con id 1 de la BD
          //  CpPerson cpPerson = customerBl.findPersonById(1);
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText("Persona desde base de datos: "+ persona);

            try {
                this.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        //
        Message message1 = update.getMessage();
        if (message1 != null && message1.hasText()) {
            switch (message1.getText()) {
                case "/inicio":
                    sendMsg(message1, "Hola soy el asistente automatico, en que te puedo ayudar?");
                    break;
                case "/ReservarCitaMedica":
                    sendMsg(message1, "Porfavor seleccione una especialidad       " );
                    sendMsg(message1,      "/MedicinaGeneral      " +
                            "/Pediatria         " +
                            "/Traumatologia     ");
                    break;
                case "/VerEspecialidades":
                    sendMsg(message1, "/MedicinaGeneral");
                    sendMsg(message1, "/Pediatria");
                    sendMsg(message1, "/Traumatologia");
                default:
            }
        }
        //
    }
/**
    public void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowsList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        //keyboardFirstRow.add(new KeyboardButton( "/inicio"));
        keyboardFirstRow.add(new KeyboardButton( "/ReservarCitaMedica"));
        keyboardFirstRow.add(new KeyboardButton( "/VerEspecialidades"));

        keyboardRowsList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowsList);
    }
*/
    @Override
    public String getBotUsername() {
        return "AsisMedBot";
    }
    @Override
    public String getBotToken() {
        return "965898434:AAFYisxZkAsAWykdChxs9DNy1ceCADAmogo";
    }




    // //////////////////////////////////////////////
    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }





}
