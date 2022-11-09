package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("BMW", "Black", 2000));
        cars.add(new Car("Opel", "Red", 1980));
        cars.add(new Car("Toyota", "White", 1976));
        cars.add(new Car("GMG", "Black", 2000));
        cars.add(new Car("Ford", "Yellow", 1976));
    }

    public List<Car> getCars(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
