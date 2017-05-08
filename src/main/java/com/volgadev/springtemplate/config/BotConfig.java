package com.volgadev.springtemplate.config;

import com.volgadev.springtemplate.bot.BotApiTools;
import com.volgadev.springtemplate.bot.MyChatBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.TelegramBotsApi;

/**
 * Created by Julia on 07.05.2017.
 */
@Configuration
@ComponentScan("com.volgadev.springtemplate")
public class BotConfig {
    @Bean
    public BotApiTools botApiTools(){
        return new BotApiTools();
    }

    @Bean
    public TelegramBotsApi chatBot() {
        return botApiTools().registerBot(new MyChatBot());
    }
}
