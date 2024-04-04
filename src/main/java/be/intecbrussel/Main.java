package be.intecbrussel;

import be.intecbrussel.model.Country;
import be.intecbrussel.model.President;
import be.intecbrussel.service.CountryService;

import java.util.Optional;

public class Main {



    public static void main(String[] args) {
        // Create presidents
        President albert = new President("Albert", 80);
        President macron = new President("Macron", 60);
        President dina = new President("Dina Boluarte", 59);

        // Create countries
        Country belgium = new Country("Belgium", 11000000, albert);
        Country france = new Country("France", 60000000, macron);
        Country peru = new Country("Peru", 33000000, dina);

        // Service handles the logic
        CountryService cs = new CountryService();

        // Saves countries to database
        cs.createCountry(belgium);
        cs.createCountry(france);
        cs.createCountry(peru);

        // Read countries from database
        Optional<Country> dbCountry = cs.readCountry("Peru");
        if (dbCountry.isPresent()) {
            System.out.println(dbCountry.get());
        } else {
            System.out.println("No country found!");
        }

        // Delete country from database
        cs.deleteCountry("France");

        // Update a country
        Optional<Country> countryToUpdate = cs.readCountry("Belgium");
        if (countryToUpdate.isPresent()) {
            Country foundCountry = countryToUpdate.get();
            foundCountry.setPopulation(foundCountry.getPopulation()+1);
            foundCountry.getPresident().setAge(99);
            cs.updateCountryButEasier(foundCountry);
        }
    }
}