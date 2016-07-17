package cc.caucas.bot.telegram.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Georgy Davityan
 */
public class Result<T> {

    private Boolean isOk;
    private T result;

    public Boolean getOk() {
        return isOk;
    }

    @JsonProperty("ok")
    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
