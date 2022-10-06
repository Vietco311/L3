package atelier_8;

public class Case {
    private int gain;
    private Personnage perso;
    private Obstacle obs;

    /**
     * Case with obstacle
     * @param nObs, Obstacle on the case
     * @param nGain, Gain from the case
     */
    public Case(Obstacle nObs, int nGain){
        this.obs = nObs;
        this.gain = nGain;
    }

    /**
     * Case without obstacle
     * @param nGain
     */
    public Case(int nGain){
        this(null, nGain);
    }

    public int getGain() {
        return this.gain;
    }

    /**
     * 
     * @return value of the penalty.
     */
    public int getPenalite(){
        int result;
        if (this.obs == null){
            result = 0;
        }else{
            result = obs.getPenalite();
        }
        return result;
    }

    /**
     * Place a character on the case
     * @param perso
     */
    public void placerPersonnage(Personnage perso){
        this.perso = perso;
    }

    /**
     * Remove a character from the case
     * @param perso
     */
    public void enleverPersonnage(){
        this.perso = null;
    }
    /**
     * Place an obstacle on the case
     * @param obs
     */
    public void placerObstacle(Obstacle obs){
        this.obs = obs;
    }

    /**
     * Check if a case is free
     */
    public boolean estLibre(){
        boolean result = false;
        if(sansObstacle() && sansPerso()){
            result = true;
        }
        return result;
    }

    /**
     * Check if there is an obstacle on the case
     * @return
     */
    public boolean sansObstacle(){
        boolean result = false;
        if(this.obs == null){
            result = true;
        }
        return result; 
    }

    /**
     * Check if there is a character on the case
     * @return
     */
    public boolean sansPerso(){
        boolean result = false;
        if(this.perso == null){
            result = true;
        }
        return result; 
    }

    /**
     * 
     * @return complete information about a case
     */
    public String toString(){
        String result;
        if (estLibre()){
            result = "Libre (gain = " + gain + ")";
        }
        else if (sansObstacle() == false){
            result = "Obstacle (penalité = " + getPenalite() + ")"; 
        }
        else if (sansPerso() == false){
            result = perso.toString() + "(penalité = -" + gain + ")";
        }else{
            result = null;
        }
        return result;
    }

}
