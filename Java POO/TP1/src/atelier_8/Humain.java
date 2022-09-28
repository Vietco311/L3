package atelier_8;

public class Humain extends Personnage {
    private int nbDeplacements = 0;
    private int niveau = 1;

    public Humain(String nNom, int nAge){
        super(nNom, nAge);
    }

    public void deplacer(int destination, int gain){
        super.deplacer(destination, gain);
        this.nbDeplacements ++;
        if (this.nbDeplacements == 4){
            this.niveau++;
        }
        else if(this.nbDeplacements == 6) {
            this.niveau++;
        }
    }

    public int positionSouhaitee(){
        return this.niveau * this.nbDeplacements;
    }

    public String toString(){
        return "Humain" + super.toString();
    }

}
