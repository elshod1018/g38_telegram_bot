package com.company;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.request.SendAudio;
import com.pengrad.telegrambot.request.SendMessage;
import kotlin.reflect.KVariance;

import java.io.File;

public class TelegramBotUpdateHandler {
    private final TelegramBot bot = new TelegramBot("6855851211:AAFT4w4WNhw1sZWTiD4lFmbu6qNZjBUjAtQ");

    public void handle(Update update) {

        Message message = update.message();
        if (message != null) {
            Chat chat = message.chat();
            Long chatId = chat.id();
           /* if (chatId.equals(5174610361L)) {
                SendMessage sendMessage = new SendMessage(chatId, "Sorry you are blocked");
                bot.execute(sendMessage);
                return;
            }*/
            String text = message.text();
            if (text.equals("/start")) {
                SendMessage sendMessage = new SendMessage(chatId, "Welcome to g38 bot");
                bot.execute(sendMessage);
            } else if (text.equals("/music")) {
                SendMessage sendMessage = new SendMessage(chatId, "Select music id");

                InlineKeyboardButton b1 = new InlineKeyboardButton("Sherali jo'rayev").callbackData("1");
                InlineKeyboardButton b2 = new InlineKeyboardButton(" 2 ").callbackData("2");
                InlineKeyboardButton b3 = new InlineKeyboardButton(" 3 ").callbackData("3");

                InlineKeyboardButton[] fl1 = {b1, b2};
                InlineKeyboardButton[] fl2 = {b3};
                InlineKeyboardButton[][] buttons = {fl1, fl2};
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup(buttons);
                sendMessage.replyMarkup(inlineKeyboardMarkup);
                bot.execute(sendMessage);

            } else if (text.equals("/settings")) {
                SendMessage sendMessage = new SendMessage(chatId, "Select settings");
                KeyboardButton language = new KeyboardButton("Language");
                KeyboardButton history = new KeyboardButton("History");
                KeyboardButton back = new KeyboardButton("Back");

                KeyboardButton phone = new KeyboardButton("Share phone");
                phone.requestContact(true);

                KeyboardButton location = new KeyboardButton("Location");
                location.requestLocation(true);

                KeyboardButton back4 = new KeyboardButton("4");

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(language, history);
                replyKeyboardMarkup.addRow(back);
                replyKeyboardMarkup.addRow(phone, location);
                replyKeyboardMarkup.addRow(back4);
                replyKeyboardMarkup.resizeKeyboard(true);

                sendMessage.replyMarkup(replyKeyboardMarkup);
                bot.execute(sendMessage);
            } else if (text.equals("History")) {
                SendMessage sendMessage = new SendMessage(chatId, "Here is your history");
                bot.execute(sendMessage);
            } else {
                DeleteMessage deleteMessage = new DeleteMessage(chatId, message.messageId());
                bot.execute(deleteMessage);
            }
        } else {
            CallbackQuery callbackQuery = update.callbackQuery();
            System.out.println(callbackQuery);
            if (callbackQuery != null) {
                Long chatId = callbackQuery.message().chat().id();
                String data = callbackQuery.data();
                System.out.println(data);
                SendAudio sendAudio = new SendAudio(chatId, new File("/home/elshod/Downloads/TELEGRAM/i am so lonely   Arash Helena.mp3"));
                bot.execute(sendAudio);
            }
        }
    }
}
