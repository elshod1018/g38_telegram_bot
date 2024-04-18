package com.company;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendAudio;
import com.pengrad.telegrambot.request.SendDocument;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("6855851211:AAFT4w4WNhw1sZWTiD4lFmbu6qNZjBUjAtQ");
        SendMessage sendMessage = new SendMessage("5174610361", "Hello from java application bot");
        SendDocument sendDocument = new SendDocument("5174610361", new File("/home/elshod/Downloads/TELEGRAM/m5_interview_mailing_jar....pdf"));

        bot.execute(sendMessage);
        bot.execute(sendDocument);
    }
}
