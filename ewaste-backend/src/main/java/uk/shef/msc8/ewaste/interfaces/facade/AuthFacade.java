package uk.shef.msc8.ewaste.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uk.shef.msc8.ewaste.application.AuthApplicationService;
import uk.shef.msc8.ewaste.infrastructure.common.resp.ResponseDTO;
import uk.shef.msc8.ewaste.interfaces.dto.LoginRequest;
import uk.shef.msc8.ewaste.interfaces.dto.SignUpRequest;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;

/**
 * @author Zhecheng Zhao
 * @RegistrationNo 220186627
 * @date Created in 17/02/2024 23:05
 */
@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthFacade {
    @Resource
    private AuthApplicationService authApplicationService;

    @PostMapping("/login")
    public ResponseDTO authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authApplicationService.login(loginRequest.getLoginName(), loginRequest.getPassword());
    }

    @PostMapping("/signup")
    public ResponseDTO registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authApplicationService.registerUser(signUpRequest);
    }
}
