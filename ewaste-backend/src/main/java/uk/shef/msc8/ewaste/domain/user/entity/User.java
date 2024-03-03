package uk.shef.msc8.ewaste.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.shef.msc8.ewaste.infrastructure.auth.AuthProvider;

import java.util.*;

/**
 * @author Zhecheng Zhao
 * @RegistrationNo 220186627
 * @date Created in 16/02/2024 03:35
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer gender;

    private String userName;
    private String phone;
    private String email;
    private String imageUrl;

    private Set<Role> authorities = new HashSet<>();
}
