package cc.caucas.bot.telegram.web.service;

import cc.caucas.bot.telegram.web.model.Message;
import cc.caucas.bot.telegram.web.model.Update;
import cc.caucas.bot.telegram.web.service.exception.TelegramBotException;
import cc.caucas.bot.telegram.web.service.handler.Handler;
import cc.caucas.bot.telegram.web.service.handler.MessageHandler;
import cc.caucas.bot.telegram.web.util.UpdateParseException;
import cc.caucas.bot.telegram.web.util.UpdateParser;
import cc.caucas.bot.telegram.web.util.UpdateType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Georgy Davityan
 */
@Component
public class TelegramFacadeBean implements TelegramFacade {

    private static final Log LOG = LogFactory.getLog(TelegramFacadeBean.class);

    private MessageHandler messageHandler;

    @Override
    public void execute(Update update) {
        LOG.info("Executing Update(ID='" + update.getId() + "')");
        try {
            UpdateType updateType = UpdateParser.parse(update);

            switch (updateType) {
                case MESSAGE: {
                    Message message = update.getMessage();
                    this.messageHandler.handle(message.getFrom(), message);
                } break;

                case COMMAND: {

                } break;

                default:
                    LOG.warn("Unknown UpdateType('" + updateType + "')");
            }

        } catch (UpdateParseException e) {
            LOG.error("Something goes wrong while parsing Update(ID='" + update.getId() + "')", e);
            throw new TelegramBotException("Unable to parse given Update(ID='" + update.getId() + "')", e);
        }
    }

    @Autowired
    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }
}
