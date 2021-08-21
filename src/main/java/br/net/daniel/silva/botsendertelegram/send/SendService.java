package br.net.daniel.silva.botsendertelegram.send;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendService {

    @Value("${bot.token}")
    private String telegramToken;

    public void telegram(SendDTO mensagem) {
        TelegramBot bot = new TelegramBot(telegramToken);
        log.debug("[TELEGRAM-SEND] - Iniciando envio de mensagem para usuario: {}", mensagem.getIdTelegramUser());
        mensagem.getMessages()
                .stream()
                .map(d -> new SendMessage(mensagem.getIdTelegramUser(), d).parseMode(ParseMode.HTML))
                .forEach(bot::execute);
        log.info("[TELEGRAM-SEND] - Enviado mensagem com sucesso");
    }
}
