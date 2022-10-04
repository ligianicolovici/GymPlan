package personal.projects.GymPlan.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import personal.projects.GymPlan.utils.Shop;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Table(name = "shopping_list")
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "id", "ingredients", "shops","user","created_at"})
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

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }
}
