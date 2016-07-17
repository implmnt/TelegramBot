package cc.caucas.bot.telegram.web.service.handler;

import cc.caucas.bot.telegram.web.model.User;

/**
 * @author Georgy Davityan
 */
public interface Handler<T> {

    void handle(User user, T t);

}
