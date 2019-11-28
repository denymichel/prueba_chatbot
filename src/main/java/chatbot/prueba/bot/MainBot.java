package chatbot.prueba.bot;

        import chatbot.prueba.bl.BotBl;

        import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

        import org.telegram.telegrambots.meta.api.objects.Update;
        import org.telegram.telegrambots.bots.TelegramLongPollingBot;

        import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

        import java.util.ArrayList;
        import java.util.List;


public class MainBot extends TelegramLongPollingBot{

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



