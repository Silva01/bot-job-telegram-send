package br.net.daniel.silva.botsendertelegram.send;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendDTO {
    private String idTelegramUser;
    private List<String> messages;
}
