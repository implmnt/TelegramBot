package cc.caucas.bot.telegram.web.service;

import org.springframework.stereotype.Service;

/**
 * @author Georgy Davityan
 */
@Service
public interface TokenService {

    String getToken();

    Boolean isValid(String token);

}
