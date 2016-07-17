package cc.caucas.bot.telegram.web.service;

import cc.caucas.bot.telegram.web.model.ChatMember;
import cc.caucas.bot.telegram.web.model.Message;
import cc.caucas.bot.telegram.web.model.User;
import org.springframework.stereotype.Service;

/**
 * @author Georgy Davityan
 */
@Service
public interface BotService {

    Message sendMessage(Integer recepientId, String text);
    ChatMember getChatMember(Integer chatId, Integer userId);

}
