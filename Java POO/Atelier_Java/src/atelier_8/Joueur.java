package atelier_8;

import java.util.ArrayList;

public class Joueur {
    private String nom;
    private String code;
    private static int nbJoueurs;
    private int nbPoints = 0;
    private ArrayList<Personnage> listPersos;


    /**
     * The player
     * @param nNom
     */
    public Joueur(String nNom){
        nbJoueurs++;
        this.nom = nNom;
        this.code = "J" + nbJoueurs;
        this.listPersos = new ArrayList<Personnage>();
    }

    /**
     * Getter, points of the player
     * @return
     */
    public int getNbPoints() {
        return this.nbPoints;
    }

    /**
     * Setter, change points of the player
     * @param nbPoints
     */
    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

    /**
     * Getter, get the character of a player
     * @return
     */
    public ArrayList<Personnage> getListPersos() {
        return this.listPersos;
    }


    /**
     * Add a character into the list
     * @param p
     */
    public void ajouterPersonnage(Personnage p){
        if (!(listPersos.contains(p)) && p != null){
            this.listPersos.add(p);
            p.setProprietaire(this);
        }
    }
    /**
     * Add points to player score
     * @param nb
     */
    public void modifierPoints(int nb){
        this.nbPoints += nb;
        if (this.nbPoints < 0){
            setNbPoints(0);
        }
        
    }
    /**
     * 
     * @return true if the player has at least one character
     */
    public boolean peutJouer(){
        return !(listPersos.isEmpty());
    }

    @Override
    /**
     * 
     * @return information on the player
     */
    public String toString(){
        String result;
        if (peutJouer()) {
            result = code + nom + "(" + nbPoints + " points) avec " + listPersos.size() + " personnage";
        }else{
            result = code + nom + "(" + nbPoints + " points) aucun " + "personnage";
        }
        return result;
    }

}
