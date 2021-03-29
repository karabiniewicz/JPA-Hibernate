package s180009.view;

import s180009.entity.Mage;
import s180009.service.MageService;
import s180009.service.TowerService;

import java.util.Scanner;

public class MagesWithHigherLevel implements View{

    private final MageService mageService;

    private final TowerService towerService;

    public MagesWithHigherLevel(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("level: ");
        int level = Integer.parseInt(scanner.nextLine());

        for (Mage mage : mageService.findAllMagesWithHigherLevel(level)) {
            System.out.println(mage);
        }
    }
}
