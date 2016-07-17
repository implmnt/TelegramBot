package cc.caucas.bot.telegram.web.model;

/**
 * @author Georgy Davityan
 */
public class ChatMember {

    private User user;
    private String status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatMember that = (ChatMember) o;

        return user.equals(that.user);

    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }
}
