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

    public Jeu(String nTitre, int nNbEtapes, int nNbObstacle){
        this.titre = nTitre;
        this.nbEtapes = nNbEtapes;
        this.nbObstacles = nNbObstacle;
    }

    public void ajouterJoueur(Joueur j){
        if (listeJoueurs.size() <= NB_JOUEUR_MAX){
            listeJoueurs.add(j);
        }

    }

    public ArrayList<Personnage> tousLesPersos(){
        ArrayList<Personnage> lesPersos = new ArrayList<>();
        for(int i = 0; i < listeJoueurs.size(); i++){
            for (int j = 0; j < listeJoueurs.get(i).getListPersos().size(); j++){
                lesPersos.add(listeJoueurs.get(i).getListPersos().get(j));
            }
        }
        return lesPersos;
    }

    public void initialiserCases(){
        int nbObs = 0;
        for (int i = 0; i < NB_CASES; i++){
            int rand = r.nextInt(NB_CASES);
            if (rand%5 == 0 && nbObs < nbObstacles){
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

    public void lancerJeu(){
        for (int i = 0; i < tousLesPersos().size(); i++){
            int j = 0;
            while (j < cases.size()){
                if(cases.get(j).estLibre()){
                    j++;
                    cases.get(j).placerPersonnage(tousLesPersos().get(i));
                }
                else{
                    j += 2;
                    cases.get(j).placerPersonnage(tousLesPersos().get(i));
                }
            }
        }
        initialiserCases();
        afficherParticipants();
        for (int j = 0; j < nbEtapes; j++){
            System.out.println("\n---- Etape "+ j + "----\n");
            for (int k = 0; k < tousLesPersos().size(); k++){
                int positionSouhaitee = (tousLesPersos().get(k).positionSouhaitee() + tousLesPersos().get(k).getPosition())%50;
                if(cases.get(positionSouhaitee).estLibre()){
                    cases.get(tousLesPersos().get(k).getPosition()).eneleverPersonnage(tousLesPersos().get(k));
                    tousLesPersos().get(k).deplacer(positionSouhaitee, (cases.get(positionSouhaitee).getGain()));
                    cases.get(positionSouhaitee).placerPersonnage(tousLesPersos().get(k));
                } else if (cases.get(positionSouhaitee).sansObstacle() == false) {
                    tousLesPersos().get(k).penaliser(cases.get(positionSouhaitee).getPenalite());
                } else {
                    tousLesPersos().get(k).penaliser(-cases.get(positionSouhaitee).getGain());
                }
            }
            afficheCases();
        }
        System.out.println(afficherResultat());
    }

    public void afficheCases(){
        for (int i = 0; i < cases.size(); i++){
            System.out.println(cases.get(i).toString());
        }
    }

    public void afficherParticipants(){
        System.out.println("LISTE DE JOUEUR");
        for (int i = 0; i < listeJoueurs.size(); i++){
            System.out.println("--------------------\n");
            System.out.println(listeJoueurs.get(i));
        }
    }

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
