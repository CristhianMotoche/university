/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JInteraccion;

public class Main {
  public static void main(String [] args) {
    ThreadB b = new ThreadB();
    b.start();
    System.out.println("Waiting for b to complete...");
    /*
    synchronized(b){
      try {
        System.out.println("Waiting for b to complete...");
        b.wait();
      } catch(InterruptedException e){}

      System.out.println("Total is: " + b.total);
    }
    */
  }
}
