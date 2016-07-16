package cc.caucas.bot.telegram.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Georgy Davityan
 */
public class Update {

    private Integer id;
    private Message message;

    public Integer getId() {
        return id;
    }

    @JsonProperty("update_id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Update update = (Update) o;

        return id.equals(update.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
