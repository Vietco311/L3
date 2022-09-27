package exercice1_2;


public class ManipEntier {
	//Attributes
	protected int entier;
	protected final int MIN = 0;
	protected final int MAX = 12;
	
	//Getters
	public int getEntier() {
		return entier;
	}
	
	
	//Setters
	public void setEntier(int entier) {
		if (entier < MAX && entier > MIN) {
			this.entier = entier;
		}
		else {
			System.err.println("ERREUR! Bornes non respectées! Valeur inchangée" );
		}
	}
	
	//Constructors
	public ManipEntier() {
		setEntier(MIN + 1);
	}
	
	public ManipEntier(int nEntier) {
		setEntier(nEntier);
		
	}
	
	//Methods
	
	//Increment n to the object without going beyond boundaries
	public int incremente(int n) {
		if (this.entier + n < MAX && this.entier + n > MIN) {
			return this.entier += n;
		}
		else {
			System.err.println("ERREUR! Bornes non respectées! Valeur inchangée " + this.entier);
			int errRetour = MIN - 1;
			return errRetour;
		}
	}
	
	//Increment 1 to the object without going beyond boundaries
	public void incremente() {
		incremente(1);
	}
	
	//Override toString from String class method so it can show the object with the passed attributes
	public String toString() {
		return "Entier actuel: " + entier;
	}
	
	//Override equal from Object class method so it can compare our object
	public boolean equal(ManipEntier entier1, ManipEntier entier2) {
		if (entier1 == entier2) {
			return true;
		}
		else {
			return false;
		}
	}
}
