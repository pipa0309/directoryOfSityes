package sber.directoryOfCityes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<City> cities = parse();
        printCities(cities);
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

    private static void printCities(List<City> cities) {
        for (City city : cities) {
            System.out.println(city + "\n");
        }
    }
}
