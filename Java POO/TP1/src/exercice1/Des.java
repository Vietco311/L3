package exercice1;
import java.util.*;

public class Des {
	protected String name;
	protected int nbFaces;
	private static final int NB_FACES_DEFAUT = 6;
	static final int MIN = 3;
	static final int MAX = 120;
	protected static Random r = new Random();
	protected static int nbDes = 0;
	
	
	//Constructors
	
	//Set default name to "De n°x"
	public Des(String nName, int nNbFace) {
		nbDes ++;
		if (nName == "" || nName == null) {
			this.name = "De n°" + nbDes;
		}
		else {
			this.name = nName;
		}
		setNbFaces(nNbFace);
		
	}
	
	public Des() {
		this("De n°" + nbDes, NB_FACES_DEFAUT);
	}
	public Des(int nNbFace) {
		this("De n°" + nbDes, nNbFace);
		
	}
	public Des(String nName) {
		this(nName, NB_FACES_DEFAUT);
		
	}
	
	
	//Getters
	
	public String getName() {
		return name;
	}
	public static int getNb_Des() {
		return nbDes;
	}
	public int getNbFaces() {
		return nbFaces;
	}
	
	//Setter
	public void setNbFaces(int nbFaces) {
		if (nbFaces < MIN || nbFaces > MAX) {
			System.err.println("Nombre de faces incorrect");
			this.nbFaces = NB_FACES_DEFAUT;
		}
		else {
			this.nbFaces = nbFaces;
		}
	}
	

	
	//Methods
	//Throw a dice
	public int lancer() {
		return r.nextInt(nbFaces+1);
	}
	
	//Throw a dice nb number of time
	public int lancer(int nb) {
		int max = 0;
		int i = 0;
		while (i != nbFaces && max != MAX) {
			int nbAleatoire = lancer();
			if (nbAleatoire > max) {
				max = nbAleatoire;
			}
		}
		return max;
	}
	
	//Override toString method from String class so it can show the object with the passed attributes
	public String toString() {
		return "Nom: " + name + "; Nombre de faces: " + nbFaces;
	}
	
	//Override equal method from Object class so it can compare our object
	public boolean equal(Object de1) {
		boolean result = false;
		if(de1 != null && de1 instanceof Des) {
			Des de =(Des) de1; 
			result = (this.name.equals(de.name) && this.nbFaces==de.nbFaces);
		}
		return result;
		
		
	}
}
