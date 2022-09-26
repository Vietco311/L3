package exercice1;

public class DeMemoire extends Des {
	private int valMemoire;
	
	
	//Constructors
	public DeMemoire() {
	}
	
	//Methods
	
	//Throw a dice with nbFaces number of faces nb times.
	//Show an error if the late value is the same as the current one.
	public int lancer() {
		int nbAleatoire = r.nextInt(nbFaces);
		while(valMemoire == nbAleatoire + 1) {
			nbAleatoire = r.nextInt(nbFaces);
		}
		this.valMemoire = nbAleatoire + 1;
		
		return nbAleatoire + 1;
	}
}
