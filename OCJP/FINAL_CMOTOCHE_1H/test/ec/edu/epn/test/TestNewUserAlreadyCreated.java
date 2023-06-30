/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.api.FxAssert;
import org.testfx.matcher.base.NodeMatchers;

/**
 *
 * @author camm
 */
public class TestNewUserAlreadyCreated extends TestFXBase {

    @Test
    public void ensureLoginIsShown() {
        clickOn(BTN_NEW_USER);
        clickOn(TXT_USER_NAME).write("Cristhian");
        clickOn(TXT_PASSWORD).write("Motoche");
        clickOn(BTN_ACEPT);
        clickOn(BTN_CANCEL);
    }
}
