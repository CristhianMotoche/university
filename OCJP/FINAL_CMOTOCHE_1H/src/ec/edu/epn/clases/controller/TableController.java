/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller;

import ec.edu.epn.clases.utils.Utils;
import ec.edu.epn.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * Table Controller that extends from Controller
 *
 * @author Cristhian Motoche
 */
public class TableController
    extends Controller
    implements Initializable {

    /**
     *
     */
    @FXML
    protected TableView<Persona> personTable;

    /**
     *
     */
    @FXML
    protected TableColumn<Persona, String> columnNombre;

    /**
     *
     */
    @FXML
    protected TableColumn<Persona, String> columnEdad;

    /**
     *
     */
    @FXML
    protected TableColumn<Persona, String> columnFecha;

    /**
     *
     */
    @FXML
    protected TableColumn<Persona, String> columnSalario;

    /**
     *
     */
    @FXML
    protected TableColumn<Persona, String> columnEmail;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnNombre.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columnEdad.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf((int) cellData.getValue().getEdad())));
        columnFecha.setCellValueFactory(cellData
                -> new SimpleStringProperty(Utils.formatDate(cellData.getValue().getFechaNacimiento())));
        columnSalario.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSueldo())));
        columnEmail.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getEmail()));
    }

    /**
     *
     * @param peopleData
     */
    public void setPersonTableItems(ObservableList<Persona> peopleData) {
        this.personTable.setItems(peopleData);
    }
}
