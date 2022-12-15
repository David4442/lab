package mk.finki.ukim.lab.repository.impl;

import mk.finki.ukim.lab.bootstrap.DataHolder;
import mk.finki.ukim.lab.model.Balloon;
import mk.finki.ukim.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ManufacturerRepository {

    public List<Manufacturer> findAll() {
        return DataHolder.manufacturers;
    }
    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturers.stream().filter(i->i.getId().equals(id)).findFirst();
    }

}
