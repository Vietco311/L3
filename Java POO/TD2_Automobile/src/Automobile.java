public abstract class Automobile {
    private String modele;
    private int puissance;
    private String couleur;
    private int espace;

    public Automobile(String nModele, int nPuissance, String nCouleur, int nEspace){
        this.modele = nModele;
        this.puissance = nPuissance;
        this.couleur = nCouleur;
        this.espace = nEspace;
    }

    public String afficherCaracteristiques(){
        return "Modèle: " + modele + "; Puissance: " + puissance + "; Couleur: " + couleur + "; Espace: " + espace;
    }

}
