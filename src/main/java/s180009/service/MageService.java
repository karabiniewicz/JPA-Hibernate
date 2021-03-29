package s180009.service;

import s180009.entity.Mage;
import s180009.entity.Tower;
import s180009.repositories.MageRepository;

import java.util.List;


public class MageService {

    private final MageRepository repository;

    public MageService(MageRepository repository) {
        this.repository = repository;
    }

    public List<Mage> findAllMages() {
        return repository.findAll();
    }

    public List<Mage> findAllMagesWithHigherLevel(int level) {
        return repository.findAllMagesWithHigherLevel(level);
    }

    public void delete(Mage mage) {
        repository.delete(mage);
    }

    public void create(Mage mage) {
        repository.add(mage);
    }

    public Mage find(String name) {
        return repository.find(name);
    }

    public List<Mage> findAllMagesInTower(Tower tower) {
        return repository.findAllMagesInTower(tower);
    }
}
