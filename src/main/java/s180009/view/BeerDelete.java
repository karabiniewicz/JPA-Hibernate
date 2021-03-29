package s180009.view;

import s180009.entity.Beer;
import s180009.service.BeerService;
import s180009.service.BreweryService;

import java.util.Scanner;

public class BeerDelete implements View{

    private final BeerService beerService;
    private final BreweryService breweryService;

    public BeerDelete(BeerService beerService, BreweryService breweryService) {
        this.beerService = beerService;
        this.breweryService = breweryService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        Beer beer = beerService.find(scanner.nextLine());

        if (beer != null) {
            beerService.delete(beer);
            System.out.println("Deleted beer: " + beer);
        }
    }
}
