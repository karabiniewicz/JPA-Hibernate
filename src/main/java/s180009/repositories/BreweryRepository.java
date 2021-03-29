package s180009.repositories;

import s180009.entity.Beer;
import s180009.entity.Brewery;

import javax.persistence.EntityManagerFactory;

/**
 * Repository for storing {@link Beer} entities.
 */
public class BreweryRepository extends JpaRepository<Brewery, String> {

    public BreweryRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Brewery.class);
    }

}
