package exercice1;

public class De_autre extends Des {
	
	//Constructors
	public De_autre() {
	}
	
	//Methods
	
	//Throw a dice with peculiar face
	public int lancer() {
		int nbAleatoire = r.nextInt(nbFaces);
		if(nbAleatoire+1 == nbFaces/2) {
			System.out.println("Moitié");		
		}
		else if(nbAleatoire+1 == nbFaces/4){
			System.out.println("Quart");
		}
		else if(nbAleatoire+1 == nbFaces/3){
			System.out.println("Tier");
		}
		else if(nbAleatoire+1 == nbFaces){
			System.out.println("MAX");
		}
		return nbAleatoire + 1;
	}

}
