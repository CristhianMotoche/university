/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserverconcurrente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{

    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;
    String id;
    
    public ServerThread(Socket sock, String hilo) throws IOException {
        this.clientSocket = sock;
        this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        this.id = hilo;
    }

    @Override
    public void run(){
        try {
            String inputLine;
            while ((inputLine = this.in.readLine()) != null) {
                this.out.println(inputLine);
                System.out.println(this.id);
            }
        } catch (IOException ex) {
            System.out.println("Exception caught when trying to listen");
            System.out.println(ex);
        }
    }
}
