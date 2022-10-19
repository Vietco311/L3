public class Artiste {
    private String nom;
    private String prenom;
    private String nomScene;

    public Artiste(String nNom, String nPrenom, String nNomScene){
        this.nom = nNom;
        this.prenom = nPrenom;
        this.nomScene = nNomScene;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public String getNomScene(){
        return this.nomScene;
    }
}
