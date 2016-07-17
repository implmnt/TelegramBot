package cc.caucas.bot.telegram.web.service;

import cc.caucas.bot.telegram.core.domain.GroupMember;
import cc.caucas.bot.telegram.web.model.ChatMember;
import cc.caucas.bot.telegram.web.model.Message;
import cc.caucas.bot.telegram.web.model.Result;
import cc.caucas.bot.telegram.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Georgy Davityan
 */
@Component
public class BotServiceBean implements BotService {

    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot{token}/";

    private static final String SEND_MESSAGE_METHOD = "sendMessage";
    private static final String GET_CHAT_MEMBER = "getChatMember?chat_id={chat_id}&user_id={user_id}";


    private TokenService tokenService;
    private RestTemplate restTemplate;

    @Autowired
    public BotServiceBean(TokenService tokenService) {
        this.tokenService = tokenService;

        this.restTemplate = new RestTemplate();

        final List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        this.restTemplate.setMessageConverters(messageConverters);
    }

    @Override
    public Message sendMessage(Integer recipientId, String text) {
        String url = this.getURLForMethod(SEND_MESSAGE_METHOD);

        Map<String, Object> request = new HashMap<>();
        request.put("chat_id", recipientId);
        request.put("text", text);

        return this.getRestTemplate().postForObject(url, request, Message.class, tokenService.getToken());
    }

    @Override
    public ChatMember getChatMember(Integer chatId, Integer userId) {
        String url = this.getURLForMethod(GET_CHAT_MEMBER);

        Result<ChatMember> result = this.getRestTemplate().exchange(url,
                                                                     HttpMethod.GET,
                                                                     null,
                                                                     new ParameterizedTypeReference<Result<ChatMember>>() {})
                                                           .getBody();

        return result.getResult();
    }

    private RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    private String getURLForMethod(String method) {
        return TELEGRAM_API_URL + method;
    }
}
