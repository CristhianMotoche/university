/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.test;

import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.matcher.base.NodeMatchers;

/**
 *
 * @author camm
 */
public class TestNewUser extends TestFXBase {

    @Test
    public void ensureLoginIsShown() {
        clickOn(BTN_NEW_USER);
        clickOn(BTN_CANCEL);
        clickOn(BTN_NEW_USER);
        clickOn(TXT_USER_NAME).write("USER_TEST");
        clickOn(TXT_PASSWORD).write("USER_PASS");
        clickOn(BTN_ACEPT);
        clickOn("#txt_user_name").write("USER_TEST");
        clickOn("#pass_password").write("USER_PASS");
        clickOn(BTN_LOGIN);
        FxAssert.verifyThat("#label", NodeMatchers.hasText("Main Menu"));
    }
}
