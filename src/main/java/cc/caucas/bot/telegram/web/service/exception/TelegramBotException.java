package cc.caucas.bot.telegram.web.service.exception;

/**
 * @author Georgy Davityan
 */
public class TelegramBotException extends RuntimeException {

    public TelegramBotException(String message) {
        super(message);
    }

    public TelegramBotException(String message, Throwable cause) {
        super(message, cause);
    }
}
