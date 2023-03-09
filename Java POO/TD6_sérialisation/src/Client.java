import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception{
        
    }
    public Client() throws Exception{

        Socket clientSocket = new Socket("127.0.0.1",Server.PORT);
        System.out.println("Server is: " + Server.PORT);
        ObjectOutputStream flux = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream back = new ObjectInputStream(clientSocket.getInputStream());
        System.out.println("Server is: " + Server.PORT);
        //flux pour envoyer
        Personne p1 = new Personne("Anthony", "Colin", 20);
        flux.writeObject(p1);
        System.out.println("Server is: " + Server.PORT);
        Personne pback = (Personne) back.readObject();
        System.out.println(pback.getNom());
        
        clientSocket.close();
    }
}