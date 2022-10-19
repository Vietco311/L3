public class Titre {

    private String nom;
    private int durée;
    private int tempo;
    private Style style;
    private Groupe auteurs;

    public Titre(String nNom, int nDurée, int nTempo, Style nStyle, Groupe nAuteurs){
        this.nom = nNom;
        this.durée = nDurée;
        this.tempo = nTempo;
        this.style = nStyle;
        this.auteurs = nAuteurs;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nNom){
        this.nom = nNom;
    }

    public int getDurée(){
        return this.durée;
    }

    public void setDurée(int nDurée){
        this.durée = nDurée;
    }

    public int getTempo(){
        return this.tempo;
    }

    public void setTempo(int nTempo){
        this.tempo = nTempo;
    }

    public Groupe getAuteurs(){
        return this.auteurs;
    }
}
