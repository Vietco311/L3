package exercice1;

public class De_memoire extends Des {
	
	//Constructors
	public De_memoire() {
	}
	
	//Methods
	
	//Throw a dice with nbFaces number of faces nb times.
	//Show an error if the late value is the same as the current one.
	public int lancer(int nb) {
		int cache = 0;
		for (int i = 0; i < nb; i++) {
			int nbAleatoire = lancer();
			if (nbAleatoire != cache) {
				cache = nbAleatoire;
			} else {
				System.err.println("ERREUR! Nombre similaires au dernier lancé!");
			}
		}
		return cache;
	}
}
