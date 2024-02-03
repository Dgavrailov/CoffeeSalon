package uni.fmi.masters.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO{
    //userID from baseDTO
    private int roleId; //1 for customer, 2 for shop owner, 3 for admin
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private String phone;
    private String address;
}
