/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HEstadoHilo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloEjemplo extends Thread {
    public HiloEjemplo(String nombre){
        super(nombre);
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i+"  "+getName()); 
            /*
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        }
        System.out.println("Finaliza "+getName());   
    }
}