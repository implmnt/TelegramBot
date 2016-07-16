package cc.caucas.bot.telegram.web;

import cc.caucas.bot.telegram.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Georgy Davityan
 */
@RestController
public class TestController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping(method = RequestMethod.POST, value = "/hello/{token}")
    public void hello(@PathVariable("token") String token, @RequestBody String update) {
        if (tokenService.isValid(token)) {
            System.out.println(update);
        } else {
            System.out.println("Invalid token");
        }
    }

}
