package uk.shef.msc8.ewaste.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.shef.msc8.ewaste.application.UserApplicationService;
import uk.shef.msc8.ewaste.domain.user.entity.User;
import uk.shef.msc8.ewaste.domain.user.repository.po.UserPO;
import uk.shef.msc8.ewaste.infrastructure.auth.CurrentUser;
import uk.shef.msc8.ewaste.infrastructure.auth.UserPrincipal;
import uk.shef.msc8.ewaste.infrastructure.common.resp.Response;
import uk.shef.msc8.ewaste.infrastructure.common.resp.ResponseDTO;
import uk.shef.msc8.ewaste.infrastructure.exception.ResourceNotFoundException;

import javax.annotation.Resource;

/**
 * @author Zhecheng Zhao
 * @RegistrationNo 220186627
 * @date Created in 16/02/2024 03:43
 */
@RestController
@Slf4j
public class UserFacade {

    @Resource
    private UserApplicationService userApplicationService;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseDTO<User> getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        var user = userApplicationService.findUserByPrimaryKey(userPrincipal.getId());
        if(user == null)
            throw new ResourceNotFoundException("User", "id", userPrincipal.getId());
        return Response.success(user);
    }
}
