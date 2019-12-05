package chatbot.prueba.bot;

<<<<<<< HEAD
        import chatbot.prueba.AsisMedBot;
        import chatbot.prueba.bl.BotBl;
        import chatbot.prueba.bl.PersonaBl;
        import chatbot.prueba.bl.UsuariosBl;
        import chatbot.prueba.domain.Persona;
        import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
        import org.telegram.telegrambots.meta.api.objects.Update;
        import org.telegram.telegrambots.bots.TelegramLongPollingBot;
=======
        import chatbot.prueba.bl.BotBl;

        import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

        import org.telegram.telegrambots.meta.api.objects.Update;
        import org.telegram.telegrambots.bots.TelegramLongPollingBot;

>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
        import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

        import java.util.logging.Logger;


public class MainBot extends TelegramLongPollingBot{

<<<<<<< HEAD
    private PersonaBl personaBl;
    private UsuariosBl usuariosBl;
    private BotBl botBl;

    private final static Logger LOGGER = Logger.getLogger(AsisMedBot.class.getName());

    public MainBot(PersonaBl personaBl, UsuariosBl usuariosBl, BotBl botBl){
        this.personaBl = personaBl;
        this.usuariosBl = usuariosBl;
        this.botBl = botBl;
    }

/**
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

    @Override
    public void onUpdateReceived(Update update) {
        //  Model model = new Model();
    ////menu
        Message message1 = update.getMessage();
    if (message1 != null && message1.hasText()) {
        switch (message1.getText()) {
        case "/inicio":
             sendMsg(message1, "Hola soy el asistente automatico, en que te puedo ayudar?");
             break;
        case "/ReservarCitaMedica":
             sendMsg(message1, "Porfavor seleccione una especialidad       " );
             sendMsg(message1,
                 "/MedicinaGeneral      " +
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
    }

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
    public void onUpdateReceived(Update update) {

        ////devuelve el id y datos de persona de la BD
      //  System.out.println(update);
      //  update.getMessage().getFrom().getId();
        //

        if (update.hasMessage() && update.getMessage().hasText()) {
            Persona persona= personaBl.findPersonaById(1);        //sacamos la persona con id 1 de la BD
            //   int conversation = botBl.processUpdate(update);
         //   response(conversation,update);

            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText("Persona desde base de datos: "+ persona);
            try {
                this.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
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


    //car
    /**
    public void response(int conversation, Update update) {
        List<String> responses = new ArrayList<>();
        ReplyKeyboardMarkup rkm = null;
        switch (conversation) {
            //****************************************\\
            //Here is the initial registering\\
            //****************************************\\
            case 1:
                responses.add("Bienvenido a Carpooling Bot");
                responses.add("Para usar el ChatBot debes registrarte primero");
                responses.add("Ingresa tus apellidos");
                break;
            case 2:
                responses.add("Ingresa tu nombre");
                break;
        }
    }
*/
    // //////////////////////////////////////////////
}
=======
        BotBl botBl;


         public MainBot(BotBl personaBl){
             this.botBl = personaBl;

            }



    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        update.getMessage().getFrom().getId();
        if (update.hasMessage() && update.getMessage().hasText()) {
            //   Persona persona= personRepository.findById(1).get();        //sacamos la persona con id 1 de la BD
            //  CpPerson cpPerson = customerBl.findPersonById(1);
            //   SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
            //           .setChatId(update.getMessage().getChatId())
            //          .setText("Persona desde base de datos: "+ persona);

            List<String> messages = botBl.processUpdate(update);
            for (String messageText : messages) {
                SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                        .setChatId(update.getMessage().getChatId())
                        .setText(messageText);
                try {
                    this.execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }}

            @Override
            public String getBotUsername () {
                return "AsisMedBot";
            }
            @Override
            public String getBotToken () {
                return "965898434:AAFYisxZkAsAWykdChxs9DNy1ceCADAmogo";
            }
        }



>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
