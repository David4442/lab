package mk.finki.ukim.lab.repository.jpa;

import mk.finki.ukim.lab.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryJpa extends JpaRepository<Order,Long> {
}
