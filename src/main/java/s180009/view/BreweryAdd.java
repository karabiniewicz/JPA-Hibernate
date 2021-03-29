package s180009.view;

import s180009.entity.Brewery;
import s180009.service.BeerService;
import s180009.service.BreweryService;

import java.util.Scanner;

public class BreweryAdd implements View{

    private final BeerService beerService;
    private final BreweryService breweryService;

    public BreweryAdd(BeerService beerService, BreweryService breweryService) {
        this.beerService = beerService;
        this.breweryService = breweryService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("value: ");
        long value = Long.parseLong(scanner.nextLine());

        Brewery brewery = breweryService.find(name);

        if (brewery == null) {
            breweryService.create(Brewery.builder()
                    .name(name)
                    .value(value)
                    .build());
            System.out.println("Brewery created!");
        } else {
            System.out.println("Brewery already exists!");
        }
    }
}
