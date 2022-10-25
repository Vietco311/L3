import java.util.*;

public class Compilation extends RegroupementMusique{
    private Groupe labelle;

    public Compilation(String nNom, ArrayList<Titre> nMusiques, Groupe nLabelle){
        super(nNom, nMusiques);
        this.labelle = nLabelle;
    }

    public Groupe getLabelle(){
        return this.labelle;
    }
}
