package uk.shef.msc8.ewaste.domain.user.service;

import org.springframework.stereotype.Service;
import uk.shef.msc8.ewaste.domain.user.entity.Role;
import uk.shef.msc8.ewaste.domain.user.entity.User;
import uk.shef.msc8.ewaste.domain.user.repository.po.RolePO;
import uk.shef.msc8.ewaste.domain.user.repository.po.UserPO;
import uk.shef.msc8.ewaste.domain.user.repository.po.UserRolePO;
import uk.shef.msc8.ewaste.interfaces.assembler.AssemblerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zhecheng Zhao
 * @RegistrationNo 220186627
 * @date Created in 01/03/2024 12:35
 */
@Service
public class UserFactory {

    public User getUser(UserPO userPO) {
        Set<Role> roles = new HashSet<>();
        var authorities = userPO.getAuthorities();
        authorities.stream().forEach(item ->{
            Role role = new AssemblerFactory().convert(
                    (source, target) -> {
                        target.setRoleCode(source.getRoleCode());
                        target.setRoleName(source.getRoleName());
                    }, item, Role.class
            );
            roles.add(role);
        });
        User user = User.builder()
                .userName(userPO.getUserName())
                .gender(userPO.getGender())
                .phone(userPO.getPhone())
                .email(userPO.getEmail())
                .imageUrl(userPO.getImageUrl())
                .authorities(roles)
                .build();
        return user;
    }
}
