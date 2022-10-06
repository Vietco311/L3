package atelier_8;

public class Tauren extends Personnage {
    private double taille;

    /**
     * Constructor
     * @param nNom
     * @param nAge
     * @param nTaille
     */
    public Tauren(String nNom, int nAge, int nTaille){
        super(nNom, nAge);
        this.taille = nTaille;
    }

    public void deplacer(int destination, int gain){
        super.deplacer(destination, gain);   
    }

    /**
     * Roll a random number between 1 and the height of the Tauren where he wishes to land.
     * @return 
     */
    public int positionSouhaitee(){
        int r = (int)(Math.random() * taille) + 1;
        return r;
    }

    @Override
    public String toString(){
        return "Tauren " + super.toString();
    }
}
