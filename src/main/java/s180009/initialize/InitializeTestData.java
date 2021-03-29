package s180009.initialize;

import s180009.entity.Mage;
import s180009.entity.Tower;
import s180009.service.MageService;
import s180009.service.TowerService;

public class InitializeTestData {

    private final MageService mageService;

    private final TowerService towerService;

    public InitializeTestData(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    /**
     * Initialize test data. Should be called after dependency injection.
     */
    public void init() {
        Tower tower1 = Tower.builder()
                .name("Tower 1")
                .height(24)
                .build();

        towerService.create(tower1);

        mageService.create(Mage.builder()
                .name("Mage 1")
                .level(9)
                .tower(tower1)
                .build());

        mageService.create(Mage.builder()
                .name("Mage 2")
                .level(2)
                .tower(tower1)
                .build());
    }
}
