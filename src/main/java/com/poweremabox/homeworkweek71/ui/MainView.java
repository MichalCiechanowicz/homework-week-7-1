package com.poweremabox.homeworkweek71.ui;

import com.poweremabox.homeworkweek71.model.Car;
import com.poweremabox.homeworkweek71.service.CarDaoImpl;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Route("cars")
@Controller
@UIScope
public class MainView extends VerticalLayout {

    private CarDaoImpl carDao;
    private Grid<Car> grid;

    @Autowired
    public MainView(CarDaoImpl carDao) {
        this.carDao = carDao;
        grid = new Grid<>(Car.class);

        showAllCars();
        getCarsByYearOfManufacture();
    }

    public void showAllCars() {
        List<Car> carList = carDao.getAllCars();
        grid.setItems(carList);
        grid.setColumns("make", "model", "color", "manufactureYear");
        Button button = new Button("Add new Car");
        button.addClickListener(e ->
                button.getUI().ifPresent(ui ->
                        ui.navigate("add-car")));
        add(grid,button);
    }

    public void getCarsByYearOfManufacture(){
        HorizontalLayout hl = new HorizontalLayout();
        Label infoLabel = new Label("Seach car by year of manufacture");
        TextField startTextField = new TextField("From");
        TextField endTextField = new TextField("To");
        Button button = new Button("Search");
        button.addClickListener(event -> {
            List<Car> carsByYearOfManufacture = carDao.getCarsByYearOfManufacture(
                    Long.parseLong(startTextField.getValue()),
                    Long.parseLong(endTextField.getValue()));
            grid = new Grid<>(Car.class);
            grid.setColumns("make", "model", "color", "manufactureYear");
            grid.setItems(carsByYearOfManufacture);
            Button buttonInside = new Button("close");
            Dialog dialog = new Dialog();
            dialog.setWidth("2000");
            dialog.setHeight("800");
            dialog.add(grid,buttonInside);
            dialog.open();
            buttonInside.addClickListener(e -> dialog.close());
        });
        hl.add(startTextField,endTextField);
        add(infoLabel,hl,button);

    }

}
