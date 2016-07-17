package cc.caucas.bot.telegram.core.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Georgy Davityan
 */
@Document(collection = "group_members")
public class GroupMember {

    private Integer groupId;
    private Integer userId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupMember that = (GroupMember) o;

        if (!groupId.equals(that.groupId)) return false;
        return userId.equals(that.userId);

    }

    @Override
    public int hashCode() {
        int result = groupId.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }
}
