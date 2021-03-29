package s180009.service;

import s180009.entity.Beer;
import s180009.entity.Brewery;
import s180009.repositories.BeerRepository;

import java.util.List;


public class BeerService {

    private final BeerRepository repository;

    public BeerService(BeerRepository repository) {
        this.repository = repository;
    }

    public List<Beer> findAllBeers() {
        return repository.findAll();
    }

    public List<Beer> findAllBeersWithLowerPrice(long price) {
        return repository.findAllBeersWithLowerPrice(price);
    }

    public void delete(Beer beer) {
        repository.delete(beer);
    }

    public void create(Beer beer) {
        repository.add(beer);
    }

    public void update(Beer beer) { repository.update(beer); }

    public Beer find(String name) {
        return repository.find(name);
    }

    public List<Beer> findAllBeersInBrewery(Brewery brewery) {
        return repository.findAllBeersInBrewery(brewery);
    }
}
