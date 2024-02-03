package uni.fmi.masters.utils;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import org.antlr.v4.runtime.misc.LogManager;
import org.hibernate.annotations.Array;
import org.modelmapper.internal.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uni.fmi.masters.models.Product;
import uni.fmi.masters.models.Reservation;
import uni.fmi.masters.models.Salon;
import uni.fmi.masters.models.User;
import uni.fmi.masters.repo.ProductRepo;
import uni.fmi.masters.repo.ReservationRepo;
import uni.fmi.masters.repo.SalonRepo;
import uni.fmi.masters.repo.UserRepo;
import uni.fmi.masters.rest.ProductRestController;
import uni.fmi.masters.services.ProductService;

import javax.lang.model.element.ModuleElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class DataGenerator {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SalonRepo salonRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductService productService;

    @Autowired
    private ReservationRepo reservationRepo;

    @PostConstruct
    public void init() {
        if(userRepo.count() == 0 ) {
            User user = new User();
            user.setFirstName("Denislav");
            user.setLastName("Gavrailov");
            user.setAddress("Plovdiv");
            user.setPassword("123456");
            user.setRoleId(3);
            user.setPhone("+359883559844");
            user.setEmail("dgavrailov@gmail.com");

            userRepo.save(user);



            if(salonRepo.count() == 0) {

                Salon salon1 = new Salon();
                salon1.setOwner(user);
                salon1.setTitle("Barista");
                salon1.setDescription("Coffee shop");

                Product product1 = createProduct("Small Coffee", "Arabicca", 1.15);
                Product product2 = createProduct("Large Coffee", "Arabicca", 1.30);
                Product product3 = createProduct("Latte ", "With Milk", 3.15);
                Product product4 = createProduct("Latte speciale", "With organic milk", 1.15);
                productRepo.save(product1);
                productRepo.save(product2);
                productRepo.save(product3);
                productRepo.save(product4);
                salon1.addProduct(product1);
                salon1.addProduct(product2);
                salon1.addProduct(product3);
                salon1.addProduct(product4);


                salonRepo.save(salon1);
                Reservation reservation = new Reservation();
                reservation.setOwner(user);
                reservation.setStatus(true);
                reservation.setSalonId(salon1);
                reservation.setReservationDate("12/12/1222");
                reservation.setReservationTime("12:20");
                reservation.setCreatedAt(LocalDateTime.now());

                reservationRepo.save(reservation);
            }
        }

    }
    private Product createProduct(String title, String description, double price) {
        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(price));
        product.setTitle(title);
        product.setDescription(description);
        return product;
    }
}
