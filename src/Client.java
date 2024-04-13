import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Creazione della connessione al server sulla porta 9999
            Socket socket = new Socket("localhost", 9999);

            // Apertura dei flussi di input e output per la comunicazione con il server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Invio di una stringa al server
            String message = "Ciao server!";
            out.println(message);

            // Ricezione e stampa della risposta dal server
            String response = in.readLine();
            System.out.println("Risposta dal server: " + response);

            // Chiusura delle risorse
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
