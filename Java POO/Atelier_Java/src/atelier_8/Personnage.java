package atelier_8;

public abstract class Personnage {
    private String nom;
    private int age;
    private int position = 0;
    private Joueur proprietaire;
    
    /**
     * Construtor of Personnage(A playable character)
     * @param nNom
     * @param nAge
     */
    public Personnage(String nNom, int nAge){
        this.nom = nNom;
        this.age = nAge;
    }

    /**
     * Setter, change the owner of the character
     * @param proprietaire
     */
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * Getter, name of the character
     * @return
     */
    public String getNom() {
        return this.nom;
    }
    
    /**
     * Getter, position of the character
     * @return
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Setter, set the position of a character
     * @param position
     */
    public void setPosition(int position){
        this.position = position;
    }

    /**
     * Move a character on the board, earning points for its owner
     * @param destination
     * @param gain
     */
    public void deplacer(int destination, int gain){
        this.position += destination;
        proprietaire.modifierPoints(gain);     
    }

    /**
     * Penalising a character, substracting points of the owner
     * @param penalite
     */
    public void penaliser(int penalite){
        proprietaire.modifierPoints(penalite);
    }

    @Override
    public String toString(){
        return nom;
    }

    abstract int positionSouhaitee();
}
