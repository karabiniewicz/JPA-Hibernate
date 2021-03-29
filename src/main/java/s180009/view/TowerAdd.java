package s180009.view;

import s180009.entity.Tower;
import s180009.service.MageService;
import s180009.service.TowerService;

import java.util.Scanner;

public class TowerAdd implements View{

    private final MageService mageService;
    private final TowerService towerService;

    public TowerAdd(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("height: ");
        int height = Integer.parseInt(scanner.nextLine());

        Tower tower = towerService.find(name);

        if (tower == null) {
            towerService.create(Tower.builder()
                    .name(name)
                    .height(height)
                    .build());
            System.out.println("Tower created!");
        } else {
            System.out.println("Tower already exists!");
        }
    }
}
