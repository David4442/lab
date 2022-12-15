package mk.finki.ukim.lab.repository.jpa;

import mk.finki.ukim.lab.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalloonRepositoryJpa extends JpaRepository<Balloon,Long> {

    List<Balloon> findAll();

    List<Balloon> findAllByNameOrDescription(String name,String description);

}
