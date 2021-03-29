package s180009.repositories;

import s180009.entity.Beer;
import s180009.entity.Brewery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Repository for storing {@link Beer} entities.
 */
public class BeerRepository extends JpaRepository<Beer, String> {

    public BeerRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Beer.class);
    }

    public List<Beer> findAllBeersWithLowerPrice(long price) {
        EntityManager entityManager = getEmf().createEntityManager();
        List<Beer> beerList = entityManager.createQuery("Select distinct b from Beer b where b.price < :price", Beer.class)
                .setParameter("price", price)
                .getResultList();
        entityManager.close();
        return beerList;
    }

    public List<Beer> findAllBeersInBrewery(Brewery brewery) {
        EntityManager entityManager = getEmf().createEntityManager();
        List<Beer> beerList = entityManager.createQuery("Select b from Beer b where b.brewery = :brewery", Beer.class)
                .setParameter("brewery", brewery)
                .getResultList();
        entityManager.close();
        return beerList;
    }
}
