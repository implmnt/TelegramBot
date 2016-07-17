package cc.caucas.bot.telegram.web.service;

import cc.caucas.bot.telegram.web.model.Update;

/**
 * @author Georgy Davityan
 */
public interface TelegramFacade {

    void execute(Update update);

}
