package personal.projects.GymPlan.entities;

import personal.projects.GymPlan.utils.Shop;

import javax.persistence.*;

@Entity
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

    public void setId(Long id) {
        this.id = id;
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
