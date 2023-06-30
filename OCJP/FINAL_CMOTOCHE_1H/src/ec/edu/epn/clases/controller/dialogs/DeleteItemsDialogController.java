/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller.dialogs;

import ec.edu.epn.clases.controller.TableController;
import ec.edu.epn.pojos.Persona;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cristhian Motoche
 */
public class DeleteItemsDialogController
        extends TableController{

    private Stage dialogStage;

    private ArrayList<Persona> people;

    @FXML
    private void handleDeletePerson() {
        Persona selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
            personTable.getItems().remove(selectedIndex);
            people.remove(selectedIndex);
        } else {
            // Nothing selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Persona> getPeople() {
        return people;
    }

    /**
     *
     * @param people
     */
    public void setPeople(ArrayList<Persona> people) {
        this.people = people;
    }

    /**
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
