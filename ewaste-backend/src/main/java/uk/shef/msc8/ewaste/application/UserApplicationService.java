package uk.shef.msc8.ewaste.application;

import org.springframework.stereotype.Service;
import uk.shef.msc8.ewaste.domain.user.entity.User;
import uk.shef.msc8.ewaste.domain.user.entity.valueobject.RoleType;
import uk.shef.msc8.ewaste.domain.user.repository.po.UserPO;
import uk.shef.msc8.ewaste.domain.user.service.UserDomainService;

import javax.annotation.Resource;


/**
 * @author Zhecheng Zhao
 * @RegistrationNo 220186627
 * @date Created in 16/02/2024 03:46
 */
@Service
public class UserApplicationService {

    @Resource
    private UserDomainService userDomainService;

    public UserPO getUserById(Long id) {
        return userDomainService.findById(id);
    }

    public UserPO registerNewUser(UserPO user, RoleType roleType) {
        return userDomainService.registerNewUser(user, roleType);
    }

    public UserPO updateExistingUser(UserPO user) {
        return userDomainService.updateExistingUser(user);
    }

    public UserPO findByEmail(String email) {
        return userDomainService.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return userDomainService.existsByEmail(email);
    }

    public boolean existsByLoginName(String loginName) {
        return userDomainService.existsByLoginName(loginName);
    }

    public UserPO findByLoginName(String loginName) {
        return userDomainService.findByLoginName(loginName);
    }

    public User findUserByPrimaryKey(Long id) {
        return userDomainService.findUserByPrimaryKey(id);
    }
}
