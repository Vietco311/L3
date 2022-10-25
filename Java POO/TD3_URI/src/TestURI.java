import java.net.URI;
import java.net.URISyntaxException;

public class TestURI {
    public static void main(String[] args){
        try {
            URI test = new URI("\\\\htts://www.universita.corsic/");
            System.out.println("La création c'est bien passé");
        }
        catch(URISyntaxException e) {
            System.out.println("Problème lors de la création, il semble que " + e + "ne soit pas un URI correct");
        }
        
    }
}
