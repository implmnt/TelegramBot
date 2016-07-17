package cc.caucas.bot.telegram.core.domain.service;

import cc.caucas.bot.telegram.core.domain.GroupMember;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Georgy Davityan
 */
@Service
public interface RegistrationService {

    GroupMember register(Integer userId, Integer groupId);
    GroupMember unregister(Integer userId, Integer groupId);
    List<GroupMember> getAll();
    List<GroupMember> getGroupMembers(Integer groupId);
    List<GroupMember> getUserGroups(Integer userId);

}
