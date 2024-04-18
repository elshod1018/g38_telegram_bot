package com.company;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;

public class TelegramBotRunner {
    private static final String TOKEN = "6855851211:AAFT4w4WNhw1sZWTiD4lFmbu6qNZjBUjAtQ";
    private static TelegramBotUpdateHandler updateHandler = new TelegramBotUpdateHandler();

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(TOKEN);
        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                System.out.println(update);
                updateHandler.handle(update);
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }, Throwable::printStackTrace);
    }
}
