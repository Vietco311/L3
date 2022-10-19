

public class Groupe {
    private String nom;
    private Artiste[] artistes;

    public Groupe(String nNom, Artiste[] nArtistes){
        this.nom = nNom;
        this.artistes = nArtistes;
    }

    public String getNom(){
        return this.nom;
    }

    public Artiste[] getArtiste(){
        return this.artistes;
    }

    public void deposerTitre(){

    }
}
