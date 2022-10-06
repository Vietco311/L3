package exercice1;

public class DePipe extends Des {
	//Attributes
	private int borneMin;
	
	/**
	 * 
	 * @param nName, name of the dice
	 * @param nNbFace, his number of faces
	 * @param nBorneMin, the minimum value required to cheat.
	 */
	public DePipe(String nName, int nNbFace, int nBorneMin) {
		super(nName, nNbFace);
		if (nBorneMin < nNbFace && nBorneMin >= MIN) {
			this.borneMin = nBorneMin;
		}
		else {
			System.err.println("De pipé incorrect");
		}
	}
	
	
	/**
	 * Throw the biased dice
	 */
	public int lancer() {
		int nbAleatoire = r.nextInt(nbFaces);
		while (nbAleatoire < borneMin) {
			nbAleatoire = r.nextInt(nbFaces);
		}
		return nbAleatoire + 1;
	}	
}
