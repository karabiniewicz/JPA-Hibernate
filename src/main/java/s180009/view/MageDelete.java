package s180009.view;

import s180009.entity.Mage;
import s180009.service.MageService;
import s180009.service.TowerService;

import java.util.Scanner;

public class MageDelete implements View{

    private final MageService mageService;
    private final TowerService towerService;

    public MageDelete(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        Mage mage = mageService.find(scanner.nextLine());

        if (mage != null) {
            mageService.delete(mage);
            System.out.println("Deleted mage: " + mage);
        }
    }
}
