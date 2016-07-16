package cc.caucas.bot.telegram.web;

import cc.caucas.bot.telegram.web.model.Idle;
import cc.caucas.bot.telegram.web.model.Message;
import cc.caucas.bot.telegram.web.model.Update;
import cc.caucas.bot.telegram.web.service.IdleService;
import cc.caucas.bot.telegram.web.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Georgy Davityan
 */
@RestController
@RequestMapping("/bot")
public class BotController {

    private static final Logger LOG = LoggerFactory.getLogger(BotController.class);

    @Autowired
    private TokenService tokenService;
    @Autowired
    private IdleService idleService;

    @RequestMapping(method = RequestMethod.POST, value = "/hook/{token}")
    public void onUpdate(@PathVariable("token") String token,
                         @RequestBody Update update) {
        if (tokenService.isValid(token)) {
            Message message = update.getMessage();
            if (message != null) {
                idleService.addIdle(message.getFrom());
            }
        } else {
            LOG.warn("Invalid token");
        }
    }

    @RequestMapping("/idles")
    public @ResponseBody List<Idle> getIdles() {
        return idleService.getIdles();
    }

}
