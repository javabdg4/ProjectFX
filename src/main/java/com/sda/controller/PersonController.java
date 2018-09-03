package com.sda.controller;

import com.sda.model.Person;
import com.sda.view.PersonView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonController {

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameCol;
    @FXML
    private TableColumn<Person, String> lastname;
    @FXML
    private Label nameLabel;
    @FXML
    private Label lastnameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label postalcodeLabel;
    @FXML
    private Label telephoneLabel;

    private PersonView personView;

    public void setPersonView(PersonView personView) {
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }

    @FXML
    public void initialize() {
        System.out.println("TEST");

        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastname.setCellValueFactory(cell -> cell.getValue().lastnameProperty());
        personTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldField, newField) -> viewPersonInfoOnLabel(newField));
    }

    public void viewPersonInfoOnLabel(Person person) {
        System.out.println(person.getName());
        nameLabel.setText(person.getName());
        lastnameLabel.setText(person.getLastname());
        streetLabel.setText(person.getStreet());
        cityLabel.setText(person.getCity());
        postalcodeLabel.setText(person.getPostalCode());
        telephoneLabel.setText(person.getTelephone());
    }
}
