package uni.fmi.masters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uni.fmi.masters.models.Product;
import uni.fmi.masters.models.Reservation;
import uni.fmi.masters.services.ProductService;
import uni.fmi.masters.services.ReservationService;


import java.util.List;


@Controller
public class Main {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/")
    public String getMain(Model model){
        return getAllProducts(model);

    }

    @GetMapping(path = "/reservation")
    public String getReservation() { return "reservation.html";}

    @GetMapping(path = "/all")
    public String getAllRes(Model model) {
        List<Reservation> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        return "/reservationsMade";
    }

    public String getAllProducts(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index.html";
    }

}
