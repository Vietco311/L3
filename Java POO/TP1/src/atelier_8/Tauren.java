package atelier_8;

public class Tauren extends Personnage {
    private double taille;

    public Tauren(String nNom, int nAge, int nTaille){
        super(nNom, nAge);
        this.taille = nTaille;
    }

    public void deplacer(int destination, int gain){
        super.deplacer(destination, gain);;     
    }

    public int positionSouhaitee(){
        int r = (int)(Math.random() * taille) + 1;
        return r;
    }

    public String toString(){
        return "Tauren" + super.toString();
    }
}
