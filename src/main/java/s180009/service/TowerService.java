package s180009.service;


import s180009.entity.Tower;
import s180009.repositories.TowerRepository;

import java.util.List;


public class TowerService {

    private final TowerRepository repository;

    public TowerService(TowerRepository repository) {
        this.repository = repository;
    }

    public List<Tower> findAllTowers() {
        return repository.findAll();
    }

    public void delete(Tower tower) {
        repository.delete(tower);
    }

    public void create(Tower tower) {
        repository.add(tower);
    }

    public Tower find(String name) {
        return repository.find(name);
    }
}
