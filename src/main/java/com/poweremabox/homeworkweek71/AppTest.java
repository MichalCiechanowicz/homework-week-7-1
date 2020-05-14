//package com.poweremabox.homeworkweek71;
//
//import com.poweremabox.homeworkweek71.configuration.DbConfig;
//import com.poweremabox.homeworkweek71.dao.CarDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class AppTest {
//
//    private DbConfig dbConfig;
//    private CarDao carDao;
//
//    @Autowired
//    public AppTest(DbConfig dbConfig, CarDao carDao) {
//        this.dbConfig = dbConfig;
//        this.carDao = carDao;
//
//        dbConfig.createDataBase();
////
//        carDao.addCar("Audi", "A3", "Silver",2001);
//        carDao.addCar("Fiat", "500", "Whiter", 2011);
//        carDao.addCar("Fiat", "125p", "Red", 1976);
//        carDao.addCar("VW", "Passat", "Red", 2010);
//        carDao.addCar("Bmw", "i8", "Red", 2018);
//
//        carDao.getAllCars().forEach(System.out::println);
//
//        carDao.getCarsByYearOfManufacture(2000,2010).forEach(System.out::println);
//    }
//}
