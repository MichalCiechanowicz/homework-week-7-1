package com.poweremabox.homeworkweek71.model;

public class Car {
    private long carId;
    private String make;
    private String model;
    private String color;
    private long manufactureYear;

    public Car() {
    }

    public Car(String make, String model, String color, long manufactureYear) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.manufactureYear = manufactureYear;
    }

    public Car(long carId, String make, String model, String color, long manufactureYear) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.color = color;
        this.manufactureYear = manufactureYear;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public long getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(long manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", manufactureYear='" + manufactureYear + '\'' +
                '}';
    }
}
