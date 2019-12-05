package chatbot.prueba.bot;

import chatbot.prueba.bl.BotBl;
import chatbot.prueba.bl.PersonaBl;
<<<<<<< HEAD
import chatbot.prueba.bl.UsuariosBl;
=======
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
import chatbot.prueba.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

//@Component , ponemos component para que Spring lo reconozca
@Component
public class BotInitializator {

<<<<<<< HEAD
    PersonaBl personaBl;
    UsuariosBl usuariosBl;
    BotBl botBl;

    @Autowired
    public BotInitializator(PersonaBl personaBl, UsuariosBl usuariosBl, BotBl botBl){
        this.personaBl = personaBl;
        this.usuariosBl = usuariosBl;
        this.botBl = botBl;
    }
/**
    PersonRepository personRepository;
=======
  BotBl botBl;

>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
    @Autowired
    public BotInitializator(BotBl botBl) {
        this.botBl = botBl;
    }
<<<<<<< HEAD
*/
=======
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a

    public BotInitializator() {
    }

    //en el metodo init inicia nuestro chatbot
    @PostConstruct
    public void init() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
<<<<<<< HEAD
        try { telegramBotsApi.registerBot(new MainBot(personaBl, usuariosBl, botBl));
=======
        try {
            telegramBotsApi.registerBot(new MainBot(botBl));
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }

}