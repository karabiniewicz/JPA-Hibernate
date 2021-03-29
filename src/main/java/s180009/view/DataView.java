package s180009.view;

import s180009.entity.Mage;
import s180009.entity.Tower;
import s180009.service.MageService;
import s180009.service.TowerService;

public class DataView implements View{

    private final MageService mageService;

    private final TowerService towerService;

    public DataView(MageService mageService, TowerService towerService) {
            this.mageService = mageService;
            this.towerService = towerService;
    }

    @Override
    public void display() {

        System.out.print("Mages:\n");
        for (Mage mage: mageService.findAllMages()) {
            System.out.println(mage);
        }
        System.out.println();

        System.out.print("Tower:\n");
        for (Tower tower: towerService.findAllTowers()) {
            System.out.println(tower);
            System.out.print("\tMages in tower:\n");
            for (Mage mage: mageService.findAllMagesInTower(tower)) {
                System.out.println("\t\t" + mage);
            }
        }
        System.out.println();
    }
}
