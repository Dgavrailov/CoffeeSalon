package uni.fmi.masters.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.fmi.masters.models.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
}
