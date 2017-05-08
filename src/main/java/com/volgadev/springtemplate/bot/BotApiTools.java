package com.volgadev.springtemplate.bot;

import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import sun.misc.Contended;

/**
 * Created by Julia on 07.05.2017.
 */
public class BotApiTools {
    public BotApiTools() {
        ApiContextInitializer.init();
    }

    public TelegramBotsApi registerBot(TelegramLongPollingBot bot) {
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return botsApi;
    }
}
