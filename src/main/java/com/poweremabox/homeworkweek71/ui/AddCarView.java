package com.poweremabox.homeworkweek71.ui;

import com.poweremabox.homeworkweek71.service.CarDaoImpl;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("add-car")
public class AddCarView extends VerticalLayout {

    private CarDaoImpl carDao;

    @Autowired

    public AddCarView(CarDaoImpl carDao) {
        this.carDao = carDao;
        addCar();
    }

    private void addCar() {
        TextField makeTextField = new TextField("Make");
        TextField modelTextField = new TextField("Model");
        TextField colorTextField = new TextField("Color");
        TextField yearTextField = new TextField("Manufacture Year");
        NativeButton button = new NativeButton("ADD");
        button.addClickListener(e -> carDao.addCar(makeTextField.getValue(),
                    modelTextField.getValue(),
                    colorTextField.getValue(),
                    Long.parseLong(yearTextField.getValue())));
        add(makeTextField, modelTextField, colorTextField, yearTextField, button);


    }

}
