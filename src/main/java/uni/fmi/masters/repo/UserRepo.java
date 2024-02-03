package uni.fmi.masters.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.fmi.masters.models.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
