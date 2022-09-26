package exercice1;

public class DePipe extends Des {
	//Attributes
	private int borneMin;
	
	//Constructor
	public DePipe(String nName, int nNbFace, int nBorneMin) {
		super(nName, nNbFace);
		if (nBorneMin < nNbFace && nBorneMin >= MIN) {
			this.borneMin = nBorneMin;
		}
		else {
			System.err.println("De pipé incorrect");
		}
	}
	
	//Throw a dice which keeps rolling while the random value is under borneMin
	public int lancer() {
		int nbAleatoire = r.nextInt(nbFaces);
		while (nbAleatoire < borneMin) {
			nbAleatoire = r.nextInt(nbFaces);
		}
		return nbAleatoire + 1;
	}	
}
