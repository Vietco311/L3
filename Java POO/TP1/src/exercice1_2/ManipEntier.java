package exercice1_2;


public class ManipEntier {
	//Attributes
	protected int entier;
	protected final int min = 0;
	protected final int max = 12;
	
	//Getters
	public int getEntier() {
		return entier;
	}
	
	
	//Setters
	public void setEntier(int entier) {
		if (entier < max && entier > min) {
			this.entier = entier;
		}
		else {
			System.err.println("ERREUR! Bornes non respectées! Valeur inchangée" );
		}
	}
	
	//Constructors
	public ManipEntier() {
		this.entier = 0;
		setEntier(min + 1);
	}
	
	public ManipEntier(int nEntier) {
		this.entier = nEntier;
		
	}
	
	//Methods
	
	//Increment n to the object without going beyond boundaries
	public int incremente(int n) {
		if (this.entier + n < max && this.entier + n > min) {
			return this.entier += n;
		}
		else {
			System.err.println("ERREUR! Bornes non respectées! Valeur inchangée " + this.entier);
			return this.min - 1;
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
