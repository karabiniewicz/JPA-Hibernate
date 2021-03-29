package s180009.view;

import s180009.entity.Beer;
import s180009.entity.Brewery;
import s180009.service.BeerService;
import s180009.service.BreweryService;

import java.util.Scanner;

public class BeerAdd implements View {

    private final BeerService beerService;
    private final BreweryService breweryService;

    public BeerAdd(BeerService beerService, BreweryService breweryService) {
        this.beerService = beerService;
        this.breweryService = breweryService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("price: ");
        long price = Long.parseLong(scanner.nextLine());
        System.out.print("brewery: ");
        Brewery brewery = breweryService.find(scanner.nextLine());

        Beer beerEntity = beerService.find(name);

        if (beerEntity == null && brewery != null) {
            beerService.create(Beer.builder()
                    .name(name)
                    .price(price)
                    .brewery(brewery)
                    .build());
            System.out.println("The beer has been poured!");
        } else {
            System.out.println("Beer already exists or brewery is not exist!");
        }
    }
}
