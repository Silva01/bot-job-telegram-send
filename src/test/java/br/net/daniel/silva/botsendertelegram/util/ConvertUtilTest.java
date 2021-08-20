package br.net.daniel.silva.botsendertelegram.util;

import br.net.daniel.silva.botsendertelegram.send.SendDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConvertUtilTest {

    @Test
    public void deveConverterStringEmDTOSemErros() throws JsonProcessingException {
        String json = "{\n" +
                "\t\"idTelegramUser\": \"213440647\",\n" +
                "\t\"messages\": [\n" +
                "\t\t\"Iniciando teste de envio\",\n" +
                "\t\t\"Se você recebeu essa mensagem então foi enviada com sucesso\"\n" +
                "\t]\n" +
                "}";

        SendDTO dto = ConvertUtil.jsonToSendDTO(json);

        Assertions.assertEquals("213440647", dto.getIdTelegramUser());
        Assertions.assertEquals(2, dto.getMessages().size());
        Assertions.assertEquals("Iniciando teste de envio", dto.getMessages().get(0));
        Assertions.assertEquals("Se você recebeu essa mensagem então foi enviada com sucesso", dto.getMessages().get(1));
    }
}
