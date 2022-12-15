package mk.finki.ukim.lab.model;


import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateCreated;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Order> orders;


    public ShoppingCart() {

    }

    public ShoppingCart( User user) {
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.orders = new ArrayList<>();

    }
}