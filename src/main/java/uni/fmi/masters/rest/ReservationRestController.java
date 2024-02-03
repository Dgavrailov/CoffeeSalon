package uni.fmi.masters.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uni.fmi.masters.dto.ReservationDTO;
import uni.fmi.masters.models.Reservation;
import uni.fmi.masters.models.User;
import uni.fmi.masters.repo.UserRepo;
import uni.fmi.masters.services.ReservationService;
import uni.fmi.masters.services.UserService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.System.*;

@RestController
@RequestMapping(path ="/reservations")
public class ReservationRestController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserRepo userRepo;
    Main tillYouMakeIt = new Main();

    @GetMapping()
    public List<ReservationDTO> findAll(){
        List<Reservation> reservations = reservationService.findAll();
        return reservations.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    @GetMapping(path = "/{reservationId}")
    public ReservationDTO getBy(@PathVariable(name = "reservationId") long reservationId) {
        Optional<Reservation> optionalReservation = reservationService.getEntity(reservationId);
        return optionalReservation.map(this::convertToDTO).orElse(null);
    }

    private ReservationDTO convertToDTO(Reservation reservation) {
        return modelMapper.map(reservation, ReservationDTO.class);
    }
    @DeleteMapping(path = "/delete/{reservationId}")
    public String deleteReservation(@PathVariable(name = "reservationId") Long reservationId){
        System.out.print(reservationId);
//        boolean isRemoved = reservationService.remove(reservationId);

        boolean isRemoved = remove(reservationId);
        if (isRemoved) {
            return "redirect:/reservations/all";
        } else {
            return "redirect:/index";
        }
    }
    @PostMapping(path = "/save")
    public String saveReservation(  @RequestParam(value="firstName") String firstName,
                                    @RequestParam(value="lastName") String lastName,
                                    @RequestParam(value = "time") String time,
                                    @RequestParam(value = "date") String date,
                                    @RequestParam(value = "email") String email,
                                    Model model){

        Reservation reservation = new Reservation();
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userRepo.save(user);
        reservation.setOwner(user);
        reservation.setReservationTime(time);
        reservation.setReservationDate(date);
        reservation.setStatus(true);
        reservation.setCreatedAt(LocalDateTime.now());
        reservationService.create(reservation);

        return "succesfullReservation";
    }
    @GetMapping(path = "/all")
    public String getAllRes(Model model) {
        List<Reservation> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        return "/reservationsMade";
    }

    private Reservation convertToModel(ReservationDTO reservationDTO) {
        return modelMapper.map(reservationDTO, Reservation.class);
    }

    @PutMapping()
    public ReservationDTO update(@RequestBody ReservationDTO reservationDTO) {
        Reservation updated = reservationService.update(convertToModel(reservationDTO));
        return convertToDTO(updated);
    }

    public boolean remove(@PathVariable(name = "reservationId") long reservationId) {
        boolean isRemoved = reservationService.remove(reservationId);
        String deletedMessage = "Reservation with id: '" + reservationId + "' was deleted!";
        String notDeletedMessage = "Reservation with id: '" + reservationId + "' does not exists!";
        return isRemoved;
    }
}
