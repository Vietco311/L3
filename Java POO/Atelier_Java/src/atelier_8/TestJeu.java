package atelier_8;

public class TestJeu {
    public static void main(String[] args) {
            for (int i = 0; i < 5; i++){
            Jeu jeu1 = new Jeu("Atelier POO", 4, 10);
            Joueur j1 = new Joueur("Paul");
            Personnage p1 = new Tauren("Hector", 15, 10);
            Personnage p2 = new Humain("Jean", 10);
            Joueur j2 = new Joueur("Lucien");
            Personnage p3 = new Humain("Marie", 10);
            Personnage p4 = new Tauren("Hercule", 20, 5);
            j1.ajouterPersonnage(p1);
            j1.ajouterPersonnage(p2);
            j2.ajouterPersonnage(p3);
            j2.ajouterPersonnage(p4);
            jeu1.ajouterJoueur(j1);
            jeu1.ajouterJoueur(j2);
            jeu1.lancerJeu();
        }
        
    }
}
