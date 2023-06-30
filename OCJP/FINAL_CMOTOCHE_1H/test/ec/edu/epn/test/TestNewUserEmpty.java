/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.test;

import org.junit.Test;

/**
 *
 * @author camm
 */
public class TestNewUserEmpty extends TestFXBase {
    @Test
    public void errorMessageUserEmpty() {
        clickOn(BTN_NEW_USER);
        clickOn(BTN_ACEPT);
        clickOn(BTN_CANCEL);
    }
}
