package s180009.repositories;

import s180009.entity.Mage;
import s180009.entity.Tower;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Repository for storing {@link Mage} entities.
 */
public class MageRepository extends JpaRepository<Mage, String> {

    public MageRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Mage.class);
    }

    public List<Mage> findAllMagesWithHigherLevel(int level) {
        EntityManager entityManager = getEmf().createEntityManager();
        List<Mage> mageList = entityManager.createQuery("Select m from Mage m where m.level > :level", Mage.class)
                .setParameter("level", level)
                .getResultList();
        entityManager.close();
        return mageList;
    }

    public List<Mage> findAllMagesInTower(Tower tower) {
        EntityManager entityManager = getEmf().createEntityManager();
        List<Mage> mageList = entityManager.createQuery("Select m from Mage m where m.tower = :tower", Mage.class)
                .setParameter("tower", tower)
                .getResultList();
        entityManager.close();
        return mageList;
    }

}
