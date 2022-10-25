import java.util.ArrayList;

public abstract class Utilisateur {
    private String nom;
    private String prenom;
    private String username;

    public Utilisateur(String nNom, String nPrenom, String nUsername){
        this.nom = nNom;
        this.prenom = nPrenom;
        this.username = nUsername;
    }

    public abstract RegroupementMusique creerListeMusic(String nNom, ArrayList<Titre> nMusiques);
}
