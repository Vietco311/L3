package exercice12;
import java.util.*;

public class EntierFou extends ManipEntier {
	//Attributes
	private int niveauDeFolie;
	private static Random r = new Random();
	
	//Constructors
	public EntierFou(int nFolie) {
		this.entier = 0;
		this.niveauDeFolie = nFolie;
	}
	
	public EntierFou(int nEntier, int nFolie) {
		this.entier = nEntier;
		this.niveauDeFolie = nFolie;
		
	}
	
	//Methods
	
	//Increment a random number(From 0 to niveauDeFolie) to the object without going beyond boundaries
	public void incremente() {
		int n = r.nextInt(niveauDeFolie);
		incremente(n);
	}
	
	
	
	
}
