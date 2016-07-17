package cc.caucas.bot.telegram.web.service;

import cc.caucas.bot.telegram.web.model.Message;
import org.springframework.stereotype.Service;

/**
 * @author Georgy Davityan
 */
@Service
public interface TelegramApiService {

    Message sendMessage(Integer recepientId, String text);

}
