package atelier_8;

public class Humain extends Personnage {
    private int nbDeplacements = 0;
    private int niveau = 1;
    private static final int PASSAGE_NIV_2 = 4;
    private static final int PASSAGE_NIV_3 = 6;

    /**
     * Constructor for Humain, a human
     * @param nNom
     * @param nAge
     */
    public Humain(String nNom, int nAge){
        super(nNom, nAge);
    }


    @Override
    /**
     * 
     * For human, gain level depending on the number of effective move.
     */
    public void deplacer(int destination, int gain){
        this.nbDeplacements ++;
        if (this.nbDeplacements == PASSAGE_NIV_2){
            this.niveau++;
        }
        else if(this.nbDeplacements == PASSAGE_NIV_3) {
            this.niveau++;
        }
        super.deplacer(destination, gain);
    }
    
    /**
     * Roll a number between 1 and the level of the player multiplicated by his level where he wishes to land.
     * @return
     */
    public int positionSouhaitee(){
        return this.niveau * ((int)(Math.random() * niveau) + 1);
    }

    @Override
    public String toString(){
        return "Humain " + super.toString();
    }

}
