import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
        
    public static final int PORT = 2000;

    public static void main(String[] args) throws Exception{
        new Server();
    }

    public Server() throws Exception{
        ServerSocket serveurSocket = new ServerSocket(PORT);
        System.out.println("Server is: " + PORT);
        Socket clientSocket = serveurSocket.accept();
        System.out.println("Server is: " + PORT);

        ObjectInputStream serverInputStream = new ObjectInputStream(clientSocket.getInputStream());
        ObjectOutputStream serverOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        System.out.println("Server is: " + PORT);

        Personne p1 = (Personne) serverInputStream.readObject();
        System.out.println("Server is: " + PORT);

        p1.setNom("Colino");
        serverOutputStream.writeObject(p1);
        
        serveurSocket.close();
    }
}

