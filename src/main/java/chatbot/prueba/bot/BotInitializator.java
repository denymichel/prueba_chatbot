package chatbot.prueba.bot;

import chatbot.prueba.bl.BotBl;
import chatbot.prueba.bl.PersonaBl;
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

  BotBl botBl;

    @Autowired
    public BotInitializator(BotBl botBl) {
        this.botBl = botBl;
    }

    public BotInitializator() {
    }

    //en el metodo init inicia nuestro chatbot
    @PostConstruct
    public void init() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new MainBot(botBl));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }

}