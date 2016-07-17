package cc.caucas.bot.telegram.web.service.handler;

import cc.caucas.bot.telegram.web.model.Message;
import cc.caucas.bot.telegram.web.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * @author Georgy Davityan
 */
@Component
@Scope(SCOPE_PROTOTYPE)
public class MessageHandler implements Handler<Message> {

    @Override
    public void handle(User user, Message message) {

    }

}
