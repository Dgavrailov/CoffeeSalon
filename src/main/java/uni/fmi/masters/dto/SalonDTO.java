package uni.fmi.masters.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uni.fmi.masters.models.Product;
import uni.fmi.masters.models.User;

@Getter
@Setter
@NoArgsConstructor
public class SalonDTO extends BaseDTO {
    private String title;
    private String description;
    private User owner; // salon owner;
    private Product product; // uslugata koqto shte predlaga salona
}
