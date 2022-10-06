package atelier_8;

public class Obstacle {
    private int penalite;

    /**
     * 
     * @return penalty of points
     */
    public int getPenalite() {
        return this.penalite;
    }

    /**
     * 
     * @param nPenalite, set the number of points the obstacle remove from the player's score.
     */
    public Obstacle(int nPenalite){
        if(nPenalite > 0){
            this.penalite = -nPenalite;
        }
    }
}
