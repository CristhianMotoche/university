/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller;

import ec.edu.epn.clases.Main;
import ec.edu.epn.clases.controller.dialogs.AddItemDialogController;
import ec.edu.epn.clases.controller.dialogs.DeleteItemsDialogController;
import ec.edu.epn.clases.controller.dialogs.EditItemDialogController;
import ec.edu.epn.clases.controller.dialogs.PrintItemsDialogController;
import ec.edu.epn.clases.controller.dialogs.SearchItemsDialogController;
import ec.edu.epn.pojos.Persona;
import ec.edu.epn.pojos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cristhian Motoche
 */
public class MainMenuController
        extends Controller
        implements Initializable {

    /**
     *
     *  Empty constructor
     *
     */
    public MainMenuController() {
    }

    /**
     *
     * @param user
     */
    public MainMenuController(Usuario user) {
        this.user = user;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleAddItem() {
        Optional<Persona> newPersona = showPersonAddDialog();
        newPersona.ifPresent(p -> {
            this.user.getPersonas().add(p);
        });
    }

    /**
     *
     * Show Dialog for adding a new person
     *
     * @return
     */
    public Optional<Persona> showPersonAddDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/dialogs/AddItemDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AddItemDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.showAndWait();
            return Optional.ofNullable(controller.getPersona());
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    @FXML
    private void handleEditItem() {
        ObservableList<Persona> peopleData = FXCollections.observableArrayList();
        this.user.getPersonas().forEach(p -> {
            peopleData.add(p);
        });
        showTable("Edit Person", "view/dialogs/EditItemsDialog.fxml", new EditItemDialogController(), peopleData);
    }

    @FXML
    private void handleRemoveItem() {
        ObservableList<Persona> peopleData = FXCollections.observableArrayList();
        this.user.getPersonas().forEach(p -> {
            peopleData.add(p);
        });
        showPersonDeleteDialog(peopleData).ifPresent(people -> this.user.setPersonas(people));
    }

    /**
     *
     * Show dialog for deleting a person
     *
     * @param peopleData
     * @return
     */
    public Optional<ArrayList<Persona>> showPersonDeleteDialog(ObservableList<Persona> peopleData) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/dialogs/DeleteItemsDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Delete Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            DeleteItemsDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPeople(this.user.getPersonas());
            controller.setPersonTableItems(peopleData);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.showAndWait();
            return Optional.ofNullable(controller.getPeople());
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    @FXML
    private void handleSearchItem() {
        ObservableList<Persona> peopleData = FXCollections.observableArrayList();
        this.user.getPersonas().forEach(p -> {
            peopleData.add(p);
        });
        showTable("Search Person", "view/dialogs/SearchItemsDialog.fxml", new SearchItemsDialogController(), peopleData);
    }

    @FXML
    private void handlePrintItems() {
        ObservableList<Persona> peopleData = FXCollections.observableArrayList();
        this.user.getPersonas().forEach(p -> {
            peopleData.add(p);
        });
        showTable("Show People", "view/dialogs/PrintItemsDialog.fxml", new PrintItemsDialogController(), peopleData);
    }

    @FXML
    private void handleExit() {
        this.main.getPrimaryStage().setWidth(450);
        this.main.getPrimaryStage().setHeight(250);
        routeToController("view/Login.fxml", new LoginController(), user);
    }
}
