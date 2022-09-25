package personal.projects.GymPlan.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import personal.projects.GymPlan.utils.Shop;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @PrimaryKeyJoinColumn
    private Long id;

    @OneToMany(targetEntity=Ingredient.class, mappedBy="id", fetch=FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Ingredient>ingredients;

    @ElementCollection(targetClass = Shop.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "shops")
    private List<Shop> shops;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "generated_date")
    private LocalDateTime generatedDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
