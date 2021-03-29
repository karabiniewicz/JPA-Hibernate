package s180009.view;

import s180009.entity.Beer;
import s180009.service.BeerService;
import s180009.service.BreweryService;

import java.util.Scanner;

public class BeersWithLowerPrice implements View{

    private final BeerService beerService;

    private final BreweryService breweryService;

    public BeersWithLowerPrice(BeerService beerService, BreweryService breweryService) {
        this.beerService = beerService;
        this.breweryService = breweryService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("price: ");
        long price = Long.parseLong(scanner.nextLine());

        for (Beer beer : beerService.findAllBeersWithLowerPrice(price)) {
            System.out.println(beer);
        }
    }
}
