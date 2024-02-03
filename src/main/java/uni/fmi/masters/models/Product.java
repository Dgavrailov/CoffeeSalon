package uni.fmi.masters.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseModel{
    @Column(length = 50, name = "Product_name", nullable = false)
    private String title;
    @Column(length = 500, nullable = false)
    private String description;
    @Column(name = "Price_of_product", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal price;


}
