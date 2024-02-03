package uni.fmi.masters.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "RESERVATIONS")
public class Reservation extends BaseModel {
    @ManyToOne // one user can have many reservations
    @JoinColumn(name = "User_id")
    private User owner; //owner of reservaiton
    @Column(name = "DATE")
    private String reservationDate;
    @Column(name = "TIME")
    private String reservationTime;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "RESERVATION_TO_SALON")
    private Salon salonId;
    @Column(name = "STATUS")
    private boolean status;

}
