import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Creazione del server socket sulla porta 9999
            ServerSocket serverSocket = new ServerSocket(9999);
            
            System.out.println("Server in attesa di connessioni...");

            // Accettazione della connessione dal client
            Socket clientSocket = serverSocket.accept();
            
            System.out.println("Connessione accettata da: " + clientSocket.getInetAddress());

            // Apertura dei flussi di input e output per la comunicazione con il client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Lettura della stringa inviata dal client e stampa in maiuscolo
            String message = in.readLine();
            System.out.println("Messaggio ricevuto dal client: " + message);
            out.println("Messaggio ricevuto e stampato in maiuscolo dal server: " + message.toUpperCase());

            // Chiusura delle risorse
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}