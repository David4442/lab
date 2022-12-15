package mk.finki.ukim.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="shop_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String password;
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<ShoppingCart> carts;

    public User(String username, String password, String name, String surname,LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = LocalDate.now();
    }

    public User() {

    }

}