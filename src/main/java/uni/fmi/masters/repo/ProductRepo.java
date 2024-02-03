package uni.fmi.masters.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.fmi.masters.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
