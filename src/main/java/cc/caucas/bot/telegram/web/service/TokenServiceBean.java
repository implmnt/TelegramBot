package cc.caucas.bot.telegram.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Georgy Davityan
 */
@Component
public class TokenServiceBean implements TokenService {

    @Value("${bot.telegram.token}")
    private String token;

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public Boolean isValid(String token) {
        return Objects.equals(this.token, token);
    }
}
