package com.poweremabox.homeworkweek71.dao;

import com.poweremabox.homeworkweek71.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarDao {

    List<Car> getAllCars();

    List<Car> getCarsByYearOfManufacture(long starYear, long endYear);

    void addCar(String make, String model, String color, long date);

}
