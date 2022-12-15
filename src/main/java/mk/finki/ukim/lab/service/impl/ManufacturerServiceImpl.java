package mk.finki.ukim.lab.service.impl;

import mk.finki.ukim.lab.model.Manufacturer;
import mk.finki.ukim.lab.repository.impl.ManufacturerRepository;
import mk.finki.ukim.lab.repository.jpa.ManufacturerRepositoryJpa;
import mk.finki.ukim.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepositoryJpa manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepositoryJpa manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }
    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }
}
