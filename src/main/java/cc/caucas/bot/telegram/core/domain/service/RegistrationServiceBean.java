package cc.caucas.bot.telegram.core.domain.service;

import cc.caucas.bot.telegram.core.domain.GroupMember;
import cc.caucas.bot.telegram.web.service.BotService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Georgy Davityan
 */
@Component
public class RegistrationServiceBean implements RegistrationService {

    private static final Log LOG = LogFactory.getLog(RegistrationServiceBean.class);

    private MongoOperations mongoOperations;
    private BotService botService;

    @Autowired
    public RegistrationServiceBean(MongoOperations mongoOperations,
                                   BotService botService) {
        this.mongoOperations = mongoOperations;
        this.botService = botService;
    }

    @Override
    public GroupMember register(Integer userId, Integer groupId) {
        LOG.info("Registering GroupMember(GroupID='" + groupId + "',UserID='" + userId + "')");

        GroupMember groupMember = this.getGroupMember(userId, groupId);
        if (groupMember == null) {
            groupMember = this.insertGroupMember(userId, groupId);
            LOG.info("Successfully registered GroupMember(GroupID='" + groupId + "',UserID='" + userId + "')");
        } else {
            LOG.warn("GroupMember(GroupID='" + groupId + "',UserID='" + userId + "') has already registered. Skipping...");
        }

        return groupMember;
    }

    private GroupMember getGroupMember(Integer userId, Integer groupId) {
        Query query = Query.query(Criteria.where("userId").is(userId).and("groupId").is(groupId));
        return this.mongoOperations.findOne(query, GroupMember.class);
    }

    private GroupMember insertGroupMember(Integer userId, Integer groupId) {
        GroupMember groupMember = new GroupMember();
        groupMember.setGroupId(groupId);
        groupMember.setUserId(userId);

        this.mongoOperations.insert(groupMember);

        return groupMember;
    }

    @Override
    public GroupMember unregister(Integer userId, Integer groupId) {
        LOG.info("Removing registration of GroupMember(GroupID='" + groupId + "',UserID='" + userId + "')");



        return null;
    }

    @Override
    public List<GroupMember> getAll() {
        return null;
    }

    @Override
    public List<GroupMember> getGroupMembers(Integer groupId) {
        return null;
    }

    @Override
    public List<GroupMember> getUserGroups(Integer userId) {
        return null;
    }
}
