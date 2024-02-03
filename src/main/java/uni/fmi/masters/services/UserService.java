package uni.fmi.masters.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import uni.fmi.masters.dto.BaseDTO;
import uni.fmi.masters.dto.UserDTO;
import uni.fmi.masters.models.User;
import uni.fmi.masters.repo.UserRepo;



@Service
public class UserService extends BaseService<User> {
    @Autowired
    UserRepo userRepo;

    @Override
    protected JpaRepository<User, Long> getRepo() {
        return userRepo;
    }
}
