package cc.caucas.bot.telegram.web;

import cc.caucas.bot.telegram.web.model.Update;
import cc.caucas.bot.telegram.web.service.TelegramFacade;
import cc.caucas.bot.telegram.web.service.TokenService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Georgy Davityan
 */
@RestController
@RequestMapping("/bot")
public class BotController {

    private static final Log LOG = LogFactory.getLog(BotController.class);

    private TokenService tokenService;
    private TelegramFacade telegramFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/hook/{token}")
    public void onUpdate(@PathVariable("token") String token,
                         @RequestBody Update update) {
        if (tokenService.isValid(token)) {
            telegramFacade.execute(update);
        } else {
            LOG.warn("Invalid Token(token='" + token + "')");
        }
    }

    @Autowired
    public void setTelegramFacade(TelegramFacade telegramFacade) {
        this.telegramFacade = telegramFacade;
    }

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }
}
