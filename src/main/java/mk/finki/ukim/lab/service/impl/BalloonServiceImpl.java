package mk.finki.ukim.lab.service.impl;

import mk.finki.ukim.lab.model.Balloon;
import mk.finki.ukim.lab.model.Manufacturer;
import mk.finki.ukim.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.lab.repository.impl.BalloonRepository;
import mk.finki.ukim.lab.repository.impl.ManufacturerRepository;
import mk.finki.ukim.lab.repository.jpa.BalloonRepositoryJpa;
import mk.finki.ukim.lab.repository.jpa.ManufacturerRepositoryJpa;
import mk.finki.ukim.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepositoryJpa balloonRepository;
    private final ManufacturerRepositoryJpa manufacturerRepository;


    public BalloonServiceImpl(BalloonRepositoryJpa balloonRepository, ManufacturerRepositoryJpa manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }


    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String name, String description) {
        return balloonRepository.findAllByNameOrDescription(name,description);
    }

    @Override
    public Optional<Balloon> save(String name, String description, Long manufacturerId) {

        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId).
                orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        return Optional.of(this.balloonRepository.save(new Balloon(name, description, manufacturer)));
    }

    @Override
    public void deleteById(Long id) {
        this.balloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return this.balloonRepository.findById(id);
    }
}
