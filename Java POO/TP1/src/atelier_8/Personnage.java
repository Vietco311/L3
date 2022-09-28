package atelier_8;

public abstract class Personnage {
    private String nom;
    private int age;
    private int position = 0;
    private Joueur proprietaire;
    

    public Personnage(String nNom, int nAge){
        this.nom = nNom;
        this.age = nAge;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getNom() {
        return this.nom;
    }
    
    public int getPosition() {
        return this.position;
    }

    public void deplacer(int destination, int gain){
        this.position += destination;
        proprietaire.modifierPoints(gain);
        
    }

    public void penaliser(int penalite){
        proprietaire.modifierPoints(penalite);
    }

    public String toString(){
        return nom;
    }

    abstract int positionSouhaitee();
}
