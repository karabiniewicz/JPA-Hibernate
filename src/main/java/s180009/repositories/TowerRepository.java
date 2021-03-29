package s180009.repositories;

import s180009.entity.Mage;
import s180009.entity.Tower;

import javax.persistence.EntityManagerFactory;

/**
 * Repository for storing {@link Mage} entities.
 */
public class TowerRepository extends JpaRepository<Tower, String> {

    public TowerRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Tower.class);
    }

}
