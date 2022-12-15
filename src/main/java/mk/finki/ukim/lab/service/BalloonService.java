package mk.finki.ukim.lab.service;

import mk.finki.ukim.lab.model.Balloon;
import mk.finki.ukim.lab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String name,String description);
    Optional<Balloon> save(String name, String description, Long manufacturerId);

    void deleteById(Long id);

    Optional<Balloon> findById(Long id);
}
