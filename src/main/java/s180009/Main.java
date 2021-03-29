package s180009;

import s180009.initialize.InitializeTestData;
import s180009.repositories.BeerRepository;
import s180009.repositories.BreweryRepository;
import s180009.service.BeerService;
import s180009.service.BreweryService;
import s180009.view.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab4Pu");

        BeerService beerService = new BeerService(new BeerRepository(entityManagerFactory));
        BreweryService breweryService = new BreweryService(new BreweryRepository(entityManagerFactory));

        InitializeTestData initializeTestData = new InitializeTestData(beerService, breweryService);
        initializeTestData.init();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("command: ");
            String command = scanner.next();
            switch (command) {
                case "BeerAdd":
                    new BeerAdd(beerService, breweryService).display();
                    break;
                case "BeerDelete":
                    new BeerDelete(beerService, breweryService).display();
                    break;
                case "BreweryAdd":
                    new BreweryAdd(beerService, breweryService).display();
                    break;
                case "BreweryDelete":
                    new BreweryDelete(beerService, breweryService).display();
                    break;
                case "viewAll":
                    new DataView(beerService, breweryService).display();
                    break;
                case "BeersWithLowerPrice":
                    new BeersWithLowerPrice(beerService, breweryService).display();
                    break;
                case "quit":
                    exit = true;
                    break;
                default:
                    System.out.println("BeerAdd|BeerDelete|BreweryAdd|BreweryDelete|viewAll|BeersWithLowerPrice||quit");
            }
            System.out.println();
        }
        entityManagerFactory.close();
    }
}
