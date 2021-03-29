package s180009.view;

import s180009.entity.Tower;
import s180009.service.MageService;
import s180009.service.TowerService;

import java.util.Scanner;

public class TowerDelete implements View{

    private final MageService mageService;
    private final TowerService towerService;

    public TowerDelete(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        Tower tower = towerService.find(scanner.nextLine());

        if (tower != null) {
            towerService.delete(tower);
            System.out.println("Deleted tower: " + tower);
        }
    }
}
