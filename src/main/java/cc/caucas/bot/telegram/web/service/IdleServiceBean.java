package cc.caucas.bot.telegram.web.service;

import cc.caucas.bot.telegram.web.model.Idle;
import cc.caucas.bot.telegram.web.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Georgy Davityan
 */
@Component
public class IdleServiceBean implements IdleService {

    private static final Log LOG = LogFactory.getLog(IdleServiceBean.class);

    private static final LocalDateTime DEFAULT_COUNTDOWN_TIME = LocalDateTime.now();

    private final Map<User, LocalDateTime> idles = new ConcurrentHashMap<>();

    @Override
    public Idle getIdle(User user) {
        LOG.debug("Retrieving Idle(UserID='" + user.getId() + "')");
        LocalDateTime idleTime = this.idles.get(user);

        if (idleTime == null) {
            LOG.debug("Idle(UserID='" + user.getId() + "') does not exist, using default countdown time");
            idleTime = DEFAULT_COUNTDOWN_TIME;
        }

        return new Idle(user, this.calculateSilentTime(idleTime));
    }

    @Override
    public Idle updateIdle(User user) {
        LOG.debug("Updating Idle(UserID='" + user.getId() + "')");
        return this.addIdle(user);
    }

    @Override
    public Idle addIdle(User user) {
        final LocalDateTime now = LocalDateTime.now();
        LOG.debug("Adding Idle(UserID='" + user.getId() + "')");

        this.idles.put(user, now);

        return new Idle(user, this.toMilliseconds(now));
    }

    @Override
    public List<Idle> getIdles() {
        List<Idle> idleList = this.idles.keySet().stream()
                                                 .map(user -> new Idle(user, this.calculateSilentTime(idles.get(user))))
                                                 .collect(Collectors.toList());

        LOG.debug("Retrieving Idles(size=" + idleList.size() + ")");
        idleList.forEach(idle -> LOG.debug("Idle(UserID='" + idle.getUser().getId() +
                                         "',SilenceTime='" + idle.getSilenceTime() + "')"));

        return idleList;
    }

    private Long toMilliseconds(LocalDateTime time) {
        return time.toEpochSecond(ZoneOffset.UTC);
    }

    private Long calculateSilentTime(LocalDateTime time) {
        return this.toMilliseconds(LocalDateTime.now()) - this.toMilliseconds(time);
    }

}
