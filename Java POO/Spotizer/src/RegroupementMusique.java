import java.util.ArrayList;

public abstract class RegroupementMusique {
    private String nom;
    private ArrayList<Titre> musiques;

    public RegroupementMusique(String nNom, ArrayList<Titre> nMusiques){
        this.nom = nNom;
        this.musiques = nMusiques;
    }

}
