package uni.fmi.masters.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import uni.fmi.masters.models.Salon;
import uni.fmi.masters.models.User;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDTO extends BaseDTO{

    private User owner; //owner of reservaiton
    private String reservationDate;
    private String reservationTime;
    private Salon salonId;
    private boolean status;

}
