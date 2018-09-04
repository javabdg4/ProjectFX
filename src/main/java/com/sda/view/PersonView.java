package com.sda.view;

import com.sda.Main;
import com.sda.controller.NewPersonController;
import com.sda.controller.PersonController;
import com.sda.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonView {
    private Stage stage;
    private VBox vbox;

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public PersonView(Stage stage){
        this.stage = stage;
        personList.add(new Person("1", "Denki", "Ali 6", "Bdg", "84-320", "394-023-213"));
        personList.add(new Person("2", "Sade", "Jani 2", "Bdg", "84-320", "543-236-754"));
        personList.add(new Person("3", "Rogue", "Juno 64", "Bdg", "84-320", "754-643-754"));
        personList.add(new Person("4", "Diki", "Mako 45", "Bdg", "84-320", "754-532-754"));
        personList.add(new Person("5", "Goto", "Mokito 21", "Bdg", "84-320", "857-645-754"));
        personList.add(new Person("6", "Marvin", "Momo 43", "Bdg", "84-320", "234-436-764"));
        personList.add(new Person("7", "Whale", "Nikel 76", "Bdg", "84-320", "544-453-653"));
        personList.add(new Person("8", "Zombo", "Suare 120", "Bdg", "84-320", "234-456-234"));
    }

    public void loadNewPersonView(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/Chart.fxml"));
        VBox newPersonView = null;
        try {
            newPersonView = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage newPersonStage = new Stage();
        Scene newPersonScene = new Scene(newPersonView);
        newPersonStage.setScene(newPersonScene);
        newPersonStage.show();
        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);
    }

    public void loadView(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/RootView.fxml"));
        try {
            vbox = (VBox) loader.load();
            Scene scene = new Scene(vbox);
            stage.setScene(scene);
            stage.show();

            PersonController personController = loader.getController();
            personController.setPersonView(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}