package atelier_8;

import java.util.ArrayList;

public class Joueur {
    private String nom;
    private String code;
    private static int nbJoueurs;
    private int nbPoints = 0;
    private ArrayList<Personnage> listPersos = new ArrayList<Personnage>();


    /**
     * The player
     * @param nNom
     */
    public Joueur(String nNom){
        nbJoueurs++;
        this.nom = nNom;
        this.code = "J" + nbJoueurs;
    }

    public int getNbPoints() {
        return this.nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

    public ArrayList<Personnage> getListPersos() {
        return this.listPersos;
    }


    /**
     * Add a character into the list
     * @param p
     */
    public void ajouterPersonnage(Personnage p){
        this.listPersos.add(p);
        p.setProprietaire(this);
    }
    /**
     * Add points to player score
     * @param nb
     */
    public void modifierPoints(int nb){
        if(nbPoints > 0){
            this.nbPoints += nb;
        }
        
    }
    /**
     * 
     * @return true if the player has at least one character
     */
    public boolean peutJouer(){
        return listPersos.size() > 0;
    }

    /**
     * @override toString
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
