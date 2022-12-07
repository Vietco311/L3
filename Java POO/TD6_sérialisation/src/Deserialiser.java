import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInput;

public class Deserialiser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("fichier.txt");
        ObjectInput object = new ObjectInputStream(file);
        Personne p1 = (Personne) object.readObject();
        System.out.println(p1.toString());
    }
}
