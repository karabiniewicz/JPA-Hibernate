package s180009.view;

import s180009.entity.Beer;
import s180009.entity.Brewery;
import s180009.service.BeerService;
import s180009.service.BreweryService;

import java.util.Scanner;

public class BreweryDelete implements View {

    private final BeerService beerService;
    private final BreweryService breweryService;

    public BreweryDelete(BeerService beerService, BreweryService breweryService) {
        this.beerService = beerService;
        this.breweryService = breweryService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        Brewery brewery = breweryService.find(scanner.nextLine());

        if (brewery != null) {
            for (Beer beer : beerService.findAllBeersInBrewery(brewery)) {
                beerService.delete(beer);
            }
            breweryService.delete(brewery);
            System.out.println("Deleted brewery: " + brewery);
        }
    }
}
