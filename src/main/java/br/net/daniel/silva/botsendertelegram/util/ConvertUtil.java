package br.net.daniel.silva.botsendertelegram.util;

import br.net.daniel.silva.botsendertelegram.send.SendDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ConvertUtil {

    public static SendDTO jsonToSendDTO(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(json, SendDTO.class);
    }
}
