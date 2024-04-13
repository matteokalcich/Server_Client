import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);
            // Creazione della connessione al server sulla porta 9999
            Socket socket = new Socket("192.168.52.27", 9999);

            // Apertura dei flussi di input e output per la comunicazione con il server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Ricezione e stampa della risposta dal server
            String text = in.readLine();
            System.out.println(text);
            String message = scanner.nextLine();
            out.println(message);



            // Chiusura delle risorse
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
