package uni.fmi.masters.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.fmi.masters.models.Salon;

public interface SalonRepo extends JpaRepository<Salon, Long> {
}
