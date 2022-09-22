package exercice1;

public class De_pipe extends Des {
	//Attributes
	private int borneMin;
	
	//Constructor
	public De_pipe(String nName, int nNbFace, int nBorneMin) {
		if (nNbFace > min && nNbFace < max){
			this.nbFaces = nNbFace;
		}
		if (nBorneMin < nNbFace && nBorneMin > 0) {
			this.borneMin = nBorneMin;
		}
		else {
			System.err.println("De pipé incorrect");
		}
	}
	
	//Throw a dice which keeps rolling while the random value is under borneMin
	public int lancer() {
		int nbAleatoire = r.nextInt(nbFaces);
		if (nbAleatoire < borneMin) {
			return lancer();
		}
		else {
			return nbAleatoire + 1;
		}
	}	
}
