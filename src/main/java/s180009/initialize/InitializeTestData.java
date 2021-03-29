package s180009.initialize;

import s180009.entity.Beer;
import s180009.entity.Brewery;
import s180009.service.BeerService;
import s180009.service.BreweryService;

public class InitializeTestData {

    private final BeerService beerService;

    private final BreweryService breweryService;

    public InitializeTestData(BeerService beerService, BreweryService breweryService) {
        this.beerService = beerService;
        this.breweryService = breweryService;
    }

    /**
     * Initialize test data. Should be called after dependency injection.
     */
    public void init() {
        Brewery brewery1 = Brewery.builder()
                .name("Elblag")
                .value(10)
                .build();

        breweryService.create(brewery1);

        Brewery brewery2 = Brewery.builder()
                .name("Gosciszewo")
                .value(5)
                .build();

        breweryService.create(brewery2);

        beerService.create(Beer.builder()
                .name("Specjal")
                .price(10)
                .brewery(brewery1)
                .build());

        beerService.create(Beer.builder()
                .name("EB")
                .price(5)
                .brewery(brewery1)
                .build());

        beerService.create(Beer.builder()
                .name("Gosciszewskie")
                .price(6)
                .brewery(brewery2)
                .build());
    }
}
