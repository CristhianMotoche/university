/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JInteraccion;

public class ThreadB extends Thread {
  int total;
  public void run() {
    synchronized(this) {
      for(int i=0;i<100;i++) {
        total += i;
      }
      notify();
    }
  }
}
