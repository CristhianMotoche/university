/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.test;

import ec.edu.epn.clases.Main;
import java.util.concurrent.TimeoutException;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

/**
 *
 * @author camm
 */
public class TestFXBase extends ApplicationTest {

    protected final String BTN_LOGIN = "Login";
    protected final String BTN_NEW_USER = "New User?";
    protected final String BTN_ACEPT = "#btnAcept";
    protected final String BTN_CANCEL = "#btnCancel";
    protected final String TXT_USER_NAME = "#txtUserName";
    protected final String TXT_PASSWORD = "#txtPassword";
    protected final String PASS_PASSWORD = "#passPassword";

    @BeforeClass
    public static void setUpClass() throws Exception {
        ApplicationTest.launch(Main.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        ApplicationTest.launch(Main.class, null);
    }

    @After
    public void tearDown() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    public <T extends Node> T find(final String query) {
        return (T) lookup(query).queryAll().iterator().next();
    }
}
