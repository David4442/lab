package mk.finki.ukim.lab.repository.jpa;

import mk.finki.ukim.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepositoryJpa extends JpaRepository<Manufacturer,Long> {

}
