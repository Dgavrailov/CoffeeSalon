package uni.fmi.masters.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import uni.fmi.masters.models.Salon;
import uni.fmi.masters.repo.SalonRepo;

@Service
public class SalonService extends BaseService<Salon> {
    @Autowired
    private SalonRepo salonRepo;

    @Override
    protected JpaRepository<Salon, Long> getRepo() {
        return salonRepo;
    }
}
