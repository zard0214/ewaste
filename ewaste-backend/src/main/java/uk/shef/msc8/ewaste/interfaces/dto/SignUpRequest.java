package uk.shef.msc8.ewaste.interfaces.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Zhecheng Zhao
 * @RegistrationNo 220186627
 * @date Created in 29/02/2024 14:55
 */
@Data
public class SignUpRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String loginName;
    @NotBlank
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
