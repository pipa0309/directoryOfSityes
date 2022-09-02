package sber.directoryOfCityes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<City> cities = parse();

//        printCities(cities);

        /**
         * sorted by name (reversed)
         */
//        sortedListByName(cities);

        /**
         * sorted by district (reversed) and name (not reversed)
         */
//        sortedListByDistrictAndName(cities);

        /**
         * print index of max element by population
         */
//        searchElementWithMaxPopulation(cities);

        /**
         * print value of max element by population with Stream API
         */
        searchMaxPopulationStreamApi(cities);
    }

    public static List<City> parse() {
        List<City> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream("src/city_ru.csv"));
            while (scanner.hasNextLine()) {
                list.add(parse(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        scanner.close();

        return new City(name, region, district, population, foundation);
    }

    private static void searchElementWithMaxPopulation(List<City> listCities) {
        Integer max = listCities.get(1).getPopulation();
        int index = 0;
        for (int i = 0; i < listCities.size(); i++) {
            if (listCities.get(i).getPopulation() > max) {
                max = listCities.get(i).getPopulation();
                index = i;
            }
        }
        System.out.println("[" + index + "] = " + max);
    }

    private static void searchMaxPopulationStreamApi(List<City> listCities) {
        Integer max = listCities.stream()
                .max(Comparator.comparing(city -> city.getPopulation()))
                .get().getPopulation();
        if (max != null) {
            System.out.println(max);
        }
    }

    private static void sortedListByName(List<City> listCities) {
        listCities.stream()
                .sorted(Comparator.comparing(City::getName)
                        .reversed())
                .forEach(System.out::println);
    }

    private static void sortedListByDistrictAndName(List<City> listCities) {
        listCities.stream()
                .sorted(Comparator.comparing(City::getDistrict)
                        .reversed()
                        .thenComparing(City::getName))
                .forEach(System.out::println);
    }

    private static void printCities(List<City> listCities) {
        for (City city : listCities) {
            System.out.println(city + "\n");
        }
    }
}