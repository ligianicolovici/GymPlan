package personal.projects.GymPlan.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import personal.projects.GymPlan.utils.Shop;

import javax.persistence.*;
@Table(name = "ingredient")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "id", "shopFrom", "quantity"})
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @PrimaryKeyJoinColumn
    private Long id;

    @Column(name = "shopFrom")
    private Shop shopFrom;

    @Column(name = "quantity")
    private Double quantity;


    public Long getId() {
        return id;
    }

    public Shop getShopFrom() {
        return shopFrom;
    }

    public void setShopFrom(Shop shopFrom) {
        this.shopFrom = shopFrom;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
