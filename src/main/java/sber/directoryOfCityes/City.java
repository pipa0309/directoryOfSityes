package sber.directoryOfCityes;

import java.util.Comparator;

public class City implements Comparator<City> {
    private final String name;
    private final String region;
    private final String district;
    private final Integer population;
    private final String foundation;

    public City(String name, String region, String district, Integer population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + "'}";
    }

    @Override
    public int compare(City o1, City o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

