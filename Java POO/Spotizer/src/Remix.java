public class Remix extends Titre{
    private Groupe remixer;

    public Remix(String nNom, int nDurée, int nTempo, Style nStyle, Groupe nAuteurs, Groupe nRemixer){
        super(nNom, nDurée, nTempo, nStyle, nAuteurs);
        this.remixer = nRemixer;
    }
    
}
