package mk.finki.ukim.lab.repository.jpa;

import mk.finki.ukim.lab.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepositoryJpa extends JpaRepository<ShoppingCart,Long> {
}
