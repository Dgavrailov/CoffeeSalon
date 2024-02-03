package uni.fmi.masters.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SALONS")
public class Salon extends BaseModel{
    @Column(length = 50, name = "Salon_name", nullable = false)
    private String title;
    @Column(length = 500, unique = true, nullable = false)
    private String description;
    @ManyToOne // one user can have many salons
    @JoinColumn(name = "User_id")
    private User owner; // salon owner;
    @OneToMany
    private Set<Product> salonProducts; // uslugite koqto shte predlaga salona

    public boolean addProduct(final Product product){
        if(salonProducts ==null){
            salonProducts = new HashSet<>();
        }
        return salonProducts.add(product);
    }
}
