package atelier_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jeu {
    private String titre;
    private final int NB_JOUEUR_MAX = 6; 
    private final int NB_CASES = 50;
    private List<Joueur> listeJoueurs = new ArrayList<Joueur>();
    private ArrayList<Case> cases = new ArrayList<Case>();
    private int nbEtapes;
    private int nbObstacles;
    private static int scoreMax;
    private Random r = new Random();

    /**
     * Constructor of the game, initialize its title, its number of round and its maximum number of obstacles
     * @param nTitre
     * @param nNbEtapes
     * @param nNbObstacle
     */
    public Jeu(String nTitre, int nNbEtapes, int nNbObstacle){
        this.titre = nTitre;
        this.nbEtapes = nNbEtapes;
        this.nbObstacles = nNbObstacle;
        this.listeJoueurs = new ArrayList<Joueur>();
        this.cases = new ArrayList<Case>();
    }

    /**
     * Add a player to the game
     * @param j
     */
    public void ajouterJoueur(Joueur j){
        if (listeJoueurs.size() <= NB_JOUEUR_MAX){
            listeJoueurs.add(j);
        }

    }

    /**
     * Add in a list all the character who will play
     * @return
     */
    public ArrayList<Personnage> tousLesPersos(){
        ArrayList<Personnage> lesPersos = new ArrayList<>();
        for(int i = 0; i < listeJoueurs.size(); i++){
            for (int j = 0; j < listeJoueurs.get(i).getListPersos().size(); j++){
                lesPersos.add(listeJoueurs.get(i).getListPersos().get(j));
            }
        }
        return lesPersos;
    }

    /**
     * Initialize cases with random value
     */
    public void initialiserCases(){
        int nbObs = 0;
        for (int i = 0; i < NB_CASES; i++){
            int rand = r.nextInt(NB_CASES);
            if (rand%5 == 0 && nbObs < nbObstacles){ //Place an obstacle if the value is modulo of 5
                Obstacle obs = new Obstacle(rand*2);
                Case c = new Case(obs, rand);
                cases.add(c);
                nbObs++;
            }else{
                Case c = new Case(rand);
                cases.add(c);
            }
        }
    }


    /**
     * Launch a game
     * 
     */
    public void lancerJeu(){
        initialiserCases();
        for(int i = 0; i < tousLesPersos().size(); i++){ //Place characters on the first free case of the board
            int j = 0;
            while(!(cases.get(j).estLibre())){
                j++;
            }
            cases.get(j).placerPersonnage((tousLesPersos().get(i)));
            tousLesPersos().get(i).setPosition(j);
        }
        for (int j = 0; j < nbEtapes; j++){
            System.out.println("\n---- Etape "+ j + "----\n");
            afficherParticipants();
            afficheCases();
            for (int k = 0; k < tousLesPersos().size(); k++){
                int avancementEspere = (tousLesPersos().get(k).positionSouhaitee())%NB_CASES;
                int positionEspere = (avancementEspere + tousLesPersos().get(k).getPosition())%NB_CASES;
                if(cases.get(positionEspere).estLibre()){
                    cases.get((tousLesPersos().get(k).getPosition())%NB_CASES).enleverPersonnage();
                    tousLesPersos().get(k).deplacer(avancementEspere, (cases.get(positionEspere).getGain()));
                    cases.get((positionEspere)%NB_CASES).placerPersonnage(tousLesPersos().get(k));
                } else if (cases.get(positionEspere).sansPerso()) {
                    tousLesPersos().get(k).penaliser(cases.get(positionEspere).getPenalite());
                } else {
                    tousLesPersos().get(k).penaliser(-cases.get(positionEspere).getGain());
                }
            }
            
        }
        System.out.println(afficherResultat());
    }

    /**
     * Show all the case with their status
     */
    public void afficheCases(){
        for (int i = 0; i < cases.size(); i++){
            System.out.println(cases.get(i).toString() + " " + i);
        }
    }

    /**
     * Show all the players with their characters
     */
    public void afficherParticipants(){
        System.out.println("LISTE DE JOUEUR");
        for (int i = 0; i < listeJoueurs.size(); i++){
            System.out.println("--------------------\n");
            System.out.println(listeJoueurs.get(i)+"\n");
        }
    }

    /**
     * Show the result of a game(list of players then winner)
     * @return
     */
    public String afficherResultat(){
        Joueur premier = listeJoueurs.get(0);
        afficherParticipants();
        for (int i = 0; i < listeJoueurs.size(); i++){
            if (premier.getNbPoints() < listeJoueurs.get(i).getNbPoints())
                premier = listeJoueurs.get(i);
        }
        String result ="JEU Atelier POO \n ********************\n" +
                    "Le gagnant est " + premier.toString() +
                     (premier.getNbPoints() > scoreMax ? "\nRecord battu: Ancien score maximum " + scoreMax :
                     "\nLe record reste imbattu");
        if (premier.getNbPoints() > scoreMax){
            scoreMax = premier.getNbPoints();
        }
        return result;             
    }
}
