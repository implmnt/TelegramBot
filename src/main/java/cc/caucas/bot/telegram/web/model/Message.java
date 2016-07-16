package cc.caucas.bot.telegram.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Georgy Davityan
 */
public class Message {

    private Integer id;
    private User from;

    public Integer getId() {
        return id;
    }

    @JsonProperty("message_id")
    public void setId(Integer id) {
        this.id = id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return id.equals(message.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
