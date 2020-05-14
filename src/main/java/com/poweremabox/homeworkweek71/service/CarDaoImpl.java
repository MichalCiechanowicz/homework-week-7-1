package com.poweremabox.homeworkweek71.service;

import com.poweremabox.homeworkweek71.dao.CarDao;
import com.poweremabox.homeworkweek71.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CarDaoImpl implements CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Car> getAllCars() {
        String sql = "SELECT * FROM cars";
        return getCars(sql);
    }

    @Override
    public List<Car> getCarsByYearOfManufacture(long startYear, long endYear) {
        String sql = "SELECT * FROM cars WHERE manufacture_year BETWEEN "+ startYear+" AND "+endYear;
        return getCars(sql);
    }

    @Override
    public void addCar(String make, String model, String color, long date) {
        Car car = new Car(make, model, color, date);
        String sql = "INSERT INTO cars VALUES(?,?,?,?,?) ";
        jdbcTemplate.update(sql, car.getCarId(), car.getMake(), car.getModel(), car.getColor(), car.getManufactureYear());
    }

    private List<Car> getCars(String sql) {

        List<Car> carList = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(el -> carList.add(new Car(
                Long.parseLong(String.valueOf(el.get("car_id"))),
                String.valueOf(el.get("make")),
                String.valueOf(el.get("model")),
                String.valueOf(el.get("color")),
                Long.parseLong(String.valueOf(el.get("manufacture_year")))
        )));
        return carList;
    }
}
