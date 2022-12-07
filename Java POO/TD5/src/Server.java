import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Server {
    public static void main(String[] args) throws Exception{
        final BufferedReader in;
        final PrintWriter out;
        try{
            ServerSocket server = new ServerSocket(2000);
            Socket socket = server.accept();
            System.out.println("Nouvel utilisateur connecté");
            out = new PrintWriter(socket.getOutputStream()); 
            out.println("Salut!");
            out.flush();
            socket.close();
            server.close();
            Thread recevoir= new Thread(new Runnable() {
                String msg ;
                @Override
                public void run() {
                    try {
                        msg = in.readLine();
                        p1.setNom("Antonio");
                        //tant que le client est connecté
                        while(msg!=null){
                            System.out.println("Client : "+msg);
                            msg = in.readLine();
                        }
                        //sortir de la boucle si le client a déconecté
                        System.out.println("Client déconecté");
                        //fermer le flux et la session socket
                        out.close();
                        clientSocket.close();
                        serveurSocket.close();
                        serverOutputStream.close();
                        serverInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            recevoir.start();
            Thread envoi= new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    while(true){
                        try {
                            serverOutputStream.writeObject(p1);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        msg = sc.nextLine();
                        out.println(msg);
                        out.flush();
                    }
                }
            });
            envoi.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
