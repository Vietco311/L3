/**
package exercice1;
//EN TRAVAUX!!!
public class DeAutre extends Des {
	
	

	//Constructors
	public DeAutre() {
	}
	
	//Methods
	
	//Throw a dice with peculiar face
	public String lancer() {
		String result; 
		int nbAleatoire = r.nextInt(nbFaces);
		if(nbAleatoire+1 == nbFaces/2) {
			result = "Motié";		
		}
		else if(nbAleatoire+1 == nbFaces/4){
			result = "Quart";
		}
		else if(nbAleatoire+1 == nbFaces/3){
			result = "Tier";
		}
		else if(nbAleatoire+1 == nbFaces){
			result = "Max";
		}
		else {
			result = "Rien de particulier...";
		}
		return result;
	}

}
*/