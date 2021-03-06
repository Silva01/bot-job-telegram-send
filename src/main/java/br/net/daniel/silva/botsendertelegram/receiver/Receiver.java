package br.net.daniel.silva.botsendertelegram.receiver;

import br.net.daniel.silva.botsendertelegram.send.SendService;
import br.net.daniel.silva.botsendertelegram.util.ConvertUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@RabbitListener(queues = "jarvis.send.telegram")
@Slf4j
@Component
public class Receiver {

    private SendService sendService;

    @Autowired
    public Receiver(SendService sendService) {
        this.sendService = sendService;
    }

    @RabbitHandler
    public void receive(String mensagem) {
        try {
            log.debug("[TELEGRAM-SEND] - Recebendo mensagem da fila: {} e convertendo para envio", mensagem);
            sendService.telegram(ConvertUtil.jsonToSendDTO(mensagem));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
