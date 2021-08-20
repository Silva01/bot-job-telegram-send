package br.net.daniel.silva.botsendertelegram.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@RabbitListener(queues = "jarvis.send.telegram")
@Slf4j
@Component
public class Receiver {

    @RabbitHandler
    public void receive(byte[] mensagem) {
        System.out.println(new String(mensagem, StandardCharsets.UTF_8));
    }
}
