/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KInteraccion2;

public class Main {
    public static void main(String [] args) {
    Calculator calculator = new Calculator();
    new Reader(calculator).start();
    new Reader(calculator).start();
    new Reader(calculator).start();
    new Thread(calculator).start();
  }
}

class Reader extends Thread {
  Calculator c;
  public Reader(Calculator calc) {
    c = calc;
  }

  public void run() {
    synchronized(c) {
      try {
        System.out.println("Waiting for calculation...");
        c.wait();
      }
      catch (InterruptedException e) {
      }
      System.out.println("Total is: " + c.total);
    }
  }
}

class Calculator implements Runnable {
  int total;
  public void run() {
    synchronized(this) {
      for(int i = 0; i < 100; i++) {
        total += i;
      }
      notifyAll();
    }
  }
}