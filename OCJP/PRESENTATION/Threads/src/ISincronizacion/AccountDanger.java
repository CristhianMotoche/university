/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISincronizacion;

public class AccountDanger implements Runnable {
  private Account acct = new Account();
  public void run(){
    for (int x = 0; x < 5; x++) {
      makeWithdrawal(10);
      if (acct.getBalance() < 0){
        System.out.println("La cuenta esta sobregirada!");
      }
    }
  }

  private synchronized void makeWithdrawal(int amt){
  //private void makeWithdrawal(int amt){
    if (acct.getBalance() >= amt){
      System.out.println(Thread.currentThread().getName() + " va a hacer un retiro");
      try{
        Thread.sleep(1000);
      }
      catch(InterruptedException ex){ }

      acct.retirada(amt);
      System.out.println(Thread.currentThread().getName() + " completo el retiro");
    }
    else {
      System.out.println("No hay suficiente en la cuenta " + Thread.currentThread().getName() + " para retirar " + acct.getBalance());
    }
  }
}

