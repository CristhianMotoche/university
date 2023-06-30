/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller.dialogs;

import ec.edu.epn.clases.controller.TableController;
import ec.edu.epn.pojos.Persona;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class EditItemDialogController
        extends TableController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEdad;

    @FXML
    private DatePicker dateDate;

    @FXML
    private TextField txtSueldo;

    @FXML
    private TextField txtEmail;

    private Stage dialogStage;

    private Persona person;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleAcept() {
        String checks = checkValidInput();
        if (!hasErrors(checks)) {
            this.person.setId();
            this.person.setNombre(txtNombre.getText());
            this.person.setEdad(Byte.parseByte(txtEdad.getText()));
            this.person.setSueldo(Double.parseDouble(txtSueldo.getText()));
            Date date = Date.from(dateDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            this.person.setFechaNacimiento(date);
            this.person.setEmail(txtEmail.getText());

            dialogStage.close();
        }
    }

    /**
     *
     * @param person
     */
    public void setPerson(Persona person) {
        this.person = person;
        txtNombre.setText(person.getNombre());
        txtEdad.setText(String.valueOf(person.getEdad()));
        txtEmail.setText(person.getEmail());
        LocalDate date = person.getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dateDate.setValue(date);
        txtSueldo.setText(String.valueOf(person.getSueldo()));
    }

    void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     *
     * @return
     */
    public Persona getPerson() {
        return person;
    }

    /**
     *
     * @return
     */
    public String checkValidInput() {
        String errors = "";
        // Not empties
        if (txtNombre.getText().equals("")) {
            errors += "*The name musn't be empty\n";
        }
        if (txtEdad.getText().equals("")) {
            errors += "*The age musn't be empty\n";
        }
        if (txtEmail.getText().equals("")) {
            errors += "*The email musn't be empty\n";
        }
        if (txtSueldo.getText().equals("")) {
            errors += "*The salary musn't be empty\n";
        }
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(txtEmail.getText());
        if (!m.matches()) {
            errors += "*The mail isn't valid (Example: usuario@domain.com)\n";
        }
        try {
            Byte.parseByte(txtEdad.getText());
        } catch (NumberFormatException e) {
            errors += "*The age must be a number\n";
        }
        try {
            Double.parseDouble(txtSueldo.getText());
        } catch (NumberFormatException e) {
            errors += "*The salary must be a number\n";
        }
        return errors;
    }
}
