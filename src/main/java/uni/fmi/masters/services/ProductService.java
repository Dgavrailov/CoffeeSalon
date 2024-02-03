package uni.fmi.masters.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import uni.fmi.masters.models.Product;
import uni.fmi.masters.repo.ProductRepo;
import uni.fmi.masters.repo.SalonRepo;

@Service
public class ProductService extends BaseService<Product> {

    @Autowired
    private ProductRepo productRepo;

    @Override
    protected JpaRepository<Product, Long> getRepo() {
        return productRepo;
    }
}
