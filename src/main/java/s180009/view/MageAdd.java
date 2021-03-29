package s180009.view;

import s180009.entity.Mage;
import s180009.entity.Tower;
import s180009.service.MageService;
import s180009.service.TowerService;

import java.util.Scanner;

public class MageAdd implements View {

    private final MageService mageService;
    private final TowerService towerService;

    public MageAdd(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("level: ");
        int level = Integer.parseInt(scanner.nextLine());
        System.out.print("tower: ");
        Tower tower = towerService.find(scanner.nextLine());

        Mage mageEntity = mageService.find(name);

        if (mageEntity == null && tower != null) {
            mageService.create(Mage.builder()
                    .name(name)
                    .level(level)
                    .tower(tower)
                    .build());
            System.out.println("Mage created!");
        } else {
            System.out.println("Mage already exists or tower is null!");
        }
    }
}
