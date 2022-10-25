import javax.imageio.ImageIO;
import java.util.ArrayList;

public class Album extends RegroupementMusique{
    private Groupe auteurs;
    private ImageIO visuel;

    public Album(String nNom, ArrayList<Titre> nMusiques, Groupe nAuteurs, ImageIO nVisuel){
        super(nNom, nMusiques);
        this.auteurs = nAuteurs;
        this.visuel = nVisuel;
    }

    public Groupe getGroupe(){
        return this.auteurs;
    }
}
