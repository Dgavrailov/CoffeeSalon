package uni.fmi.masters.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends BaseModel{
    @Column(length = 1) //nullable = false
    private int roleId; //1 for customer, 2 for shop owner, 3 for admin
    @Column(length = 256) //nullable = false
    private String firstName;
    @Column( length = 256) //nullable = false
    private String lastName;
    @Column( length = 56) //nullable = false
    private String password;
    @Column( length = 256,nullable = false, unique=false) //nullable = false
    private String email;
    @Column( length = 56) //nullable = false
    private String phone;
    @Column(length = 256) //nullable = false
    private String address;
}
