import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialiser {
    public static void main(String[] args) throws IOException {
        Personne p1 = new Personne("Colin", "Anthony", 20);
        FileOutputStream file = new FileOutputStream("fichier.txt");
        ObjectOutputStream object = new ObjectOutputStream(file);
        System.out.println(p1.toString());
        object.writeObject(p1);



    }
     
    
}


