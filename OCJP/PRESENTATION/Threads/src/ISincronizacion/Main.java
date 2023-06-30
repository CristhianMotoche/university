/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISincronizacion;

/**
 *
 * @author camm
 */
public class Main { 
  public static void main (String [] args){
    AccountDanger r = new AccountDanger();
    Thread one = new Thread(r);
    Thread two = new Thread(r);
    one.setName("Fred");
    two.setName("Lucy");
    one.start();
    two.start();
  }
}
