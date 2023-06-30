/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.test;

import ec.edu.epn.clases.Main;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

/**
 *
 * @author camm
 */
public class TextLogin extends TestFXBase {

    @Before
    public void setUp() throws Exception {
        ApplicationTest.launch(Main.class);
    }

    @Test
    public void ensureNewUserIsLoged() {
        clickOn("#txt_user_name").write("Cristhian");
        clickOn("#pass_password").write("Motoche");
        clickOn(BTN_LOGIN);
        FxAssert.verifyThat("#label", NodeMatchers.hasText("Main Menu"));
    }
}
