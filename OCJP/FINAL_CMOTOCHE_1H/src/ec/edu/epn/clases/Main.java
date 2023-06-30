/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases;

import ec.edu.epn.clases.controller.LoginController;
import ec.edu.epn.pojos.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Cristhian Motoche
 */
public class Main extends Application {

    /**
     *
     * Attributes
     *
     */
    public static ArrayList<Usuario> users = new ArrayList<>();
    private Stage primaryStage;
    private BorderPane rootLayout;
    private static String TITLE = "OCJP - Proyecto";

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(Main.TITLE);
        Main.users.add(new Usuario("Cristhian", "Motoche"));

        try {
            initRootLayout();
            showLogin();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the root layout.
     *
     * @throws java.io.IOException
     */
    public void initRootLayout() throws IOException {
        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
        this.rootLayout = (BorderPane) loader.load();

        // Show the scene containing the root layout.
        Scene scene = new Scene(this.rootLayout);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    /**
     * Shows the person overview inside the root layout.
     *
     * @throws java.io.IOException
     */
    public void showLogin() throws IOException {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Login.fxml"));
        AnchorPane personOverview = (AnchorPane) loader.load();

        // Set person overview into the center of root layout.
        rootLayout.setCenter(personOverview);

        // Give the controller access to the main app.
        LoginController controller = loader.getController();
        controller.setMain(this);
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     *
     * Returns the BorderPane of the first stage
     *
     * @return
     */
    public BorderPane getRootLayout() {
        return rootLayout;
    }

    /**
     *
     * Main function
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
