package s180009.service;


import s180009.entity.Brewery;
import s180009.repositories.BreweryRepository;

import java.util.List;


public class BreweryService {

    private final BreweryRepository repository;

    public BreweryService(BreweryRepository repository) {
        this.repository = repository;
    }

    public List<Brewery> findAllBreweries() {
        return repository.findAll();
    }

    public void delete(Brewery brewery) {
        repository.delete(brewery);
    }

    public void create(Brewery brewery) {
        repository.add(brewery);
    }

    public Brewery find(String name) {
        return repository.find(name);
    }
}
