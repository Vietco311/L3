public class Playlist extends RegroupementMusique{
    private Utilisateur createur;

    public Playlist(String nNom, Titre[] nMusiques, Utilisateur nCreateur){
        super(nNom, nMusiques);
        this.createur = nCreateur;
    }
}
