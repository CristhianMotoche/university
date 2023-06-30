/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller;

import ec.edu.epn.clases.Main;
import ec.edu.epn.pojos.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Cristhian Motoche
 */
public class NewUserController
        extends Controller
        implements Initializable {

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private void handleAcept() {
        String checks = checkValidInput();
        if (!hasErrors(checks)) {
            Usuario user = new Usuario(txtUserName.getText(), txtPassword.getText());
            Main.users.add(user);
            routeToController("view/Login.fxml", new LoginController(), null);
        }
    }

    /**
     *
     * Return the errors if any
     *
     * @return
     */
    public String checkValidInput() {
        String errors = "";
        if (txtUserName.getText().equals("")) {
            errors += "*The user name musn't be empty\n";
        }
        if (txtPassword.getText().equals("")) {
            errors += "*The password name musn't be empty\n";
        }
        if (Main.users.contains(new Usuario(txtUserName.getText(), txtPassword.getText()))) {
            errors += "*The user already exists\n";
        }
        return errors;
    }

    @FXML
    private void handleCancel() {
        routeToController("view/Login.fxml", new LoginController(), null);
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
}
