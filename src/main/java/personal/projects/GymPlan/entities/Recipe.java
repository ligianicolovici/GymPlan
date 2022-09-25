package personal.projects.GymPlan.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @PrimaryKeyJoinColumn
    private Long id;
    @OneToMany(targetEntity=Ingredient.class, mappedBy="id", fetch=FetchType.LAZY)
    private List<Ingredient> ingredients;
    @Column(name= "description")
    private String description;
    @Column(name= "special_note")
    private String specialNote;
    @OneToMany(targetEntity=User.class, mappedBy="id", fetch=FetchType.LAZY)
    private List<User>users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
