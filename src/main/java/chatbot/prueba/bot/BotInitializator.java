package chatbot.prueba.bot;

import chatbot.prueba.bl.BotBl;
import chatbot.prueba.bl.PersonaBl;
import chatbot.prueba.bl.UsuariosBl;
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
     @Autowired
     public BotInitializator(PersonRepository personRepository) {
     this.personRepository = personRepository;
     }
     */

    public BotInitializator() {
    }


    //en el metodo init inicia nuestro chatbot
    @PostConstruct
    public void init() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try { telegramBotsApi.registerBot(new MainBot(personaBl, usuariosBl, botBl));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }

}