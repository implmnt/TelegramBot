package cc.caucas.bot.telegram.web.service;

import cc.caucas.bot.telegram.web.model.Idle;
import cc.caucas.bot.telegram.web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Georgy Davityan
 */
@Service
public interface IdleService {

    Idle getIdle(User user);
    Idle updateIdle(User user);
    Idle addIdle(User user);
    List<Idle> getIdles();

}
