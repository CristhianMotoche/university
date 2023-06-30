import java.awt.event.ActionEvent;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Server {
    public static String input = "";
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        Chat chat = new Chat();
        chat.setTitle("Sevidor");
        chat.setVisible(true);

        try (
            ServerSocket serverSocket =
                new ServerSocket(Integer.parseInt(args[0]));
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            ) {
                String inputLine;
                chat.getjButton1().addActionListener((ActionEvent ae) -> {
                    String userInput =
                            JOptionPane.showInputDialog(null, "Ingrese su mensaje", "Servidor", 1);
                    if (userInput != null) {
                        Server.input += "S: " + userInput + "\n";
                        chat.setjTextArea1(Server.input);
                        out.println(userInput);
                    }
                });

                chat.getjButton2().addActionListener((ActionEvent ae) -> {
                        System.exit(0);
                });

                while((inputLine = in.readLine()) != null){
                    Server.input += "C: " + inputLine + "\n";
                    chat.setjTextArea1(Server.input);
                }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
