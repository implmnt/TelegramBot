package cc.caucas.bot.telegram.web.service;

import cc.caucas.bot.telegram.web.model.Idle;
import cc.caucas.bot.telegram.web.model.User;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @author Georgy Davityan
 */
public class IdleServiceBeanTest {

    private static final AtomicInteger SEQUENCE = new AtomicInteger(1);

    @Test
    public void getIdle() throws Exception {
        IdleServiceBean service = new IdleServiceBean();

        User user = this.createUser();

        Idle idleWhileAdd = service.addIdle(user);
        assertNotNull(idleWhileAdd);

        Idle idleWhileGet = service.getIdle(user);
        assertNotNull(idleWhileGet);

        Idle idleWhileUpdate = service.getIdle(user);
        assertNotNull(idleWhileUpdate);

        service.addIdle(this.createUser());
        service.addIdle(this.createUser());
        service.addIdle(this.createUser());
        service.addIdle(this.createUser());

        List<Idle> idles = service.getIdles();

        assertTrue(idles.size() == 5);
    }

    private User createUser() {
        User user = new User();

        user.setId(SEQUENCE.getAndIncrement());
        user.setFirstName("King");
        user.setLastName(String.format("Arthur %1$s", user.getId()));
        user.setUsername(String.format("@Arthur_%1$s", user.getId()));

        return user;
    }

}