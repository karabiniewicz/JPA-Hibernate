package s180009;

import s180009.initialize.InitializeTestData;
import s180009.repositories.MageRepository;
import s180009.repositories.TowerRepository;
import s180009.service.MageService;
import s180009.service.TowerService;
import s180009.view.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab4Pu");

        MageService mageService = new MageService(new MageRepository(entityManagerFactory));
        TowerService towerService = new TowerService(new TowerRepository(entityManagerFactory));

        InitializeTestData initializeTestData = new InitializeTestData(mageService, towerService);
        initializeTestData.init();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("command: ");
            String command = scanner.next();
            switch (command) {
                case "addMag":
                    new MageAdd(mageService, towerService).display();
                    break;
                case "delMag":
                    new MageDelete(mageService, towerService).display();
                    break;
                case "addTower":
                    new TowerAdd(mageService, towerService).display();
                    break;
                case "delTower":
                    new TowerDelete(mageService, towerService).display();
                    break;
                case "viewAll":
                    new DataView(mageService, towerService).display();
                    break;
                case "magesWithHigherLevel":
                    new MagesWithHigherLevel(mageService, towerService).display();
                    break;
                case "quit":
                    exit = true;
                    break;
                default:
                    System.out.println("addMag|delMag|addTower|delTower|viewAll|magesWithHigherLevel||quit");
            }
            System.out.println();
        }
        entityManagerFactory.close();
    }
}
