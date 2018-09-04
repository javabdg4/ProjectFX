package com.sda.controller;

import com.sda.model.Person;
import com.sda.view.PersonView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPersonController {
    @FXML
    TextField name;
    @FXML
    TextField lastname;
    @FXML
    TextField street;
    @FXML
    TextField city;
    @FXML
    TextField postalCode;
    @FXML
    TextField telephone;

    @FXML
    private Button closeButton;

    private PersonView personView;

    public void saveButton(ActionEvent actionEvent){
        System.out.println(name.getText());
        System.out.println(lastname.getText());
        System.out.println(street.getText());
        System.out.println(city.getText());
        System.out.println(postalCode.getText());
        System.out.println(telephone.getText());
        Person person = new Person(name.getText(),lastname.getText(),street.getText(),city.getText(),
                                    postalCode.getText(),telephone.getText());
        personView.getPersonList().add(person);
        clearButton(actionEvent);
    }

    public void clearButton(ActionEvent actionEvent){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }

}