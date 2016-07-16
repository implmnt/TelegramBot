package cc.caucas.bot.telegram.web;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Georgy Davityan
 */
@RestController
public class TestController {

    public static final String TOKEN = UUID.randomUUID().toString();

    @PostConstruct
    public void setUp() {
        System.out.println("Generated token: " + TOKEN);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hello/{token}")
    public void hello(@PathVariable("token") String token, @RequestBody String update) {
        if (Objects.equals(TOKEN, token)) {
            System.out.println(update);
        } else {
            System.out.println("Invalid token");
        }
    }

}
