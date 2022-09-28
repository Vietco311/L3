package atelier_8;

public class Humain extends Personnage {
    private int nbDeplacements = 0;
    private int niveau = 1;

    public Humain(String nNom, int nAge){
        super(nNom, nAge);
    }

    public void deplacer(int destination, int gain){
        this.nbDeplacements ++;
        if (this.nbDeplacements == 4){
            this.niveau++;
        }
        else if(this.nbDeplacements == 6) {
            this.niveau++;
        }
        super.deplacer(destination, gain);
    }

    public int positionSouhaitee(){
        return this.niveau * ((int)(Math.random() * niveau) + 1);
    }

    public String toString(){
        return "Humain" + super.toString();
    }

}
