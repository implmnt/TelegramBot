package cc.caucas.bot.telegram.web.util;

import cc.caucas.bot.telegram.web.model.Update;

/**
 * @author Georgy Davityan
 */
public abstract class UpdateParser {

    public static UpdateType parse(Update update) throws UpdateParseException {
        if (update.getMessage() != null) {
            return UpdateType.MESSAGE;
        }
        throw new UpdateParseException("Unkown Update(ID='" + update.getId() + "')");
    }

}
