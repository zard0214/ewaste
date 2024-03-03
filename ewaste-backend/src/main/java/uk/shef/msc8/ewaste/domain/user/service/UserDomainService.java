package uk.shef.msc8.ewaste.domain.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.shef.msc8.ewaste.domain.user.entity.User;
import uk.shef.msc8.ewaste.domain.user.entity.UserRole;
import uk.shef.msc8.ewaste.domain.user.entity.valueobject.RoleType;
import uk.shef.msc8.ewaste.domain.user.repository.facade.RoleRepository;
import uk.shef.msc8.ewaste.domain.user.repository.facade.UserRepository;
import uk.shef.msc8.ewaste.domain.user.repository.facade.UserRoleRepository;
import uk.shef.msc8.ewaste.domain.user.repository.po.UserPO;
import uk.shef.msc8.ewaste.domain.user.repository.po.UserRolePO;
import uk.shef.msc8.ewaste.infrastructure.exception.BizException;

import javax.annotation.Resource;

/**
 * @author Zhecheng Zhao
 * @RegistrationNo 220186627
 * @date Created in 16/02/2024 03:45
 */
@Service
@Slf4j
public class UserDomainService {

    @Resource
    private UserFactory userFactory;

    @Resource
    private UserRepository userRepository;

    @Resource
    public UserRoleRepository userRoleRepository;

    @Resource
    public RoleRepository roleRepository;

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserPO findById(Long id) {
        var userPO = userRepository.findById(id);
        if(null != userPO){
            var userRole = userRoleRepository.getUserRoleByUserId(userPO.getId());
            userRole.stream().forEach(item -> {
                var role = roleRepository.getRoleById(item.getRoleId());
                userPO.addRole(role);
            });
        }
        return userPO;
    }

    public UserPO findByEmail(String email) {
        var userByEmail = userRepository.getUserByEmail(email);
        if(null != userByEmail){
            var userRole = userRoleRepository.getUserRoleByUserId(userByEmail.getId());
            userRole.stream().forEach(item -> {
                var role = roleRepository.getRoleById(item.getRoleId());
                userByEmail.addRole(role);
            });
        }
        return userByEmail;
    }

    public boolean existsByLoginName(String loginName) {
        return userRepository.existsByLoginName(loginName);
    }

    public UserPO findByLoginName(String loginName) {
        var userByEmail = userRepository.getUserByLoginName(loginName);
        if(null != userByEmail){
            var userRole = userRoleRepository.getUserRoleByUserId(userByEmail.getId());
            userRole.stream().forEach(item -> {
                var role = roleRepository.getRoleById(item.getRoleId());
                userByEmail.addRole(role);
            });
        }
        return userByEmail;
    }

    @Transactional
    public UserPO registerNewUser(UserPO user, RoleType roleType) {
        var userPO = userRepository.saveUser(user);
        var rolePO = roleRepository.getRoleByCode(roleType.getCode());
        UserRolePO userRole = new UserRolePO();
        userRole.setRoleId(rolePO.getId());
        userRole.setUserId(userPO.getId());
        userRoleRepository.saveUserRole(userRole);
        return userPO;
    }

    public UserPO updateExistingUser(UserPO user) {
        return userRepository.updateUser(user);
    }


    public User findUserByPrimaryKey(Long id) {
        var userPO = findById(id);
        if (null == userPO) {
            throw new BizException("user does not exist");
        }
        return userFactory.getUser(userPO);
    }
}
