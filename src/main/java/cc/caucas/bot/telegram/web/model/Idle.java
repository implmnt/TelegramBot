package cc.caucas.bot.telegram.web.model;

import java.time.LocalDate;

/**
 * @author Georgy Davityan
 */
public class Idle {

    private User user;
    private Long silenceTime;

    public Idle(User user, Long silenceTime) {
        this.user = user;
        this.silenceTime = silenceTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getSilenceTime() {
        return silenceTime;
    }

    public void setSilenceTime(Long silenceTime) {
        this.silenceTime = silenceTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Idle idle = (Idle) o;

        return user.equals(idle.user);

    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }
}
