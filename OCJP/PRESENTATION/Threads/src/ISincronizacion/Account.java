/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISincronizacion;

public class Account {
  private int balance = 50;
  public int getBalance() {
    return balance;
  }
  public void retirada(int amount){
    balance = balance - amount;
  }
}