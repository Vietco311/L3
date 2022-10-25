import java.util.ArrayList;

public class Playlist extends RegroupementMusique{
    private Client createur;

    public Playlist(String nNom, ArrayList<Titre> nMusiques, Client nCreateur){
        super(nNom, nMusiques);
        this.createur = nCreateur;
    }
}
