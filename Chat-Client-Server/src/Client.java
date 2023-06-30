import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class Client {
    public static String input = "";
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println(
                "Usage: java Client <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        Chat chat = new Chat();
        chat.setTitle("Cliente");
        chat.setVisible(true);
        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
            ) {

            String inputFromServer;
            chat.getjButton1().addActionListener((ActionEvent ae) -> {
                String userInput = JOptionPane.showInputDialog(null, "Ingrese su mensaje", "Cliente", 1);
                if (userInput != null) {
                    Client.input += "C: " + userInput + "\n";
                    chat.setjTextArea1(Client.input);
                    out.println(userInput);
                }
            });

            chat.getjButton2().addActionListener((ActionEvent ae) -> {
                    System.exit(0);
            });

            while((inputFromServer = in.readLine()) != null){
                Client.input += "S: "+ inputFromServer + "\n";
                chat.setjTextArea1(input);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +hostName);
            System.exit(1);
        }
    }
}
