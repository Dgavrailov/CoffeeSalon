//package uni.fmi.masters.rest;
//
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import uni.fmi.masters.repo.ReservationRepo;
//import uni.fmi.masters.services.ReservationService;
//
//@Controller
//@RequestMapping(path = "/admin")
//public class ControllPoint {
//
//    @Autowired
//    ReservationService reservationService;
//    @Autowired
//    ReservationRepo reservationRepo;
//
//    @GetMapping(path = "/delete/{reservationId}")
//    public String deleteReservation(){
//
//        return reservationRepo.delete();
//    }
//}
