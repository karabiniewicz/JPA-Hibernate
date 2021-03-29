package s180009.view;

import s180009.entity.Beer;
import s180009.entity.Brewery;
import s180009.service.BeerService;
import s180009.service.BreweryService;

public class DataView implements View{

    private final BeerService beerService;

    private final BreweryService breweryService;

    public DataView(BeerService beerService, BreweryService breweryService) {
            this.beerService = beerService;
            this.breweryService = breweryService;
    }

    @Override
    public void display() {

        System.out.print("Beers:\n");
        for (Beer beer : beerService.findAllBeers()) {
            System.out.println(beer);
        }
        System.out.println();

        System.out.print("Breweries:\n");
        for (Brewery brewery : breweryService.findAllBreweries()) {
            System.out.println(brewery);
            System.out.print("\tBeers in brewery:\n");
            for (Beer beer : beerService.findAllBeersInBrewery(brewery)) {
                System.out.println("\t\t" + beer);
            }
        }
        System.out.println();
    }
}
