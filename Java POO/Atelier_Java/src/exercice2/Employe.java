package exercice2;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author User
 *
 */
public class Employe extends Personne{
	
	private double salaire;
	private final LocalDateTime DATE_EMBAUCHE;
	private long longevite;
	private static final int anneeMin = 16;
	private static final int anneeMax = 65;
	

		/**
	 * Constructeur
	 * @param unePersonne, la personne qui est employé
	 * @param leSalaire, le salaire de l'employé
	 * @param laDateEmbauche, la date d'embauche de l'employé
	 */
	public Employe(Personne unePersonne, double leSalaire, LocalDateTime laDateEmbauche) {
		super(unePersonne.nom, unePersonne.prenom, unePersonne.dateNaissance, unePersonne.adresse);
		this.salaire = leSalaire;
		this.DATE_EMBAUCHE = laDateEmbauche;
		
	}

	/**
	 * Accesseur
	 * @return
	 */
	public static int getAnneMin(){
		return anneeMin;
	}

	/**
	 * Accesseur
	 * @return
	 */
	public static int getAnneeMax(){
		return anneeMax;
	}

	/**
	 * Accesseur
	 * @return retourne le salaire
	 */
	public double getSalaire() {
		return salaire;
	}
	
	public LocalDateTime getDateEmbauche(){
		return DATE_EMBAUCHE;
	}

	/**
	 * Accesseur
	 * @return retourne la longévité
	 */
	public long getLongevite() {
		return longevite;
	}


	/**
	 * Modificateur
	 * @param modifie le salaire
	 */
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	

	public void setLongevite(long longevite) {
		this.longevite = longevite;
	}


	
	/**
	 * Méthode
	 * @param laPersonne, la personne employé
	 * @param leSalaire
	 * @param laDateEmbauche
	 * @return un employé qui est dans les limites d'âges pour travailler
	 */
	public static Employe createEmployee(Personne laPersonne, double leSalaire, LocalDateTime laDateEmbauche) {
		long age = ChronoUnit.YEARS.between(laPersonne.dateNaissance, LocalDateTime.now());
		if ( age > anneeMin && age < anneeMax) {
			return new Employe(laPersonne, leSalaire, laDateEmbauche);
		}
		else {
			return null;
		}
	}
	
	
	/**
	 * Méthode
	 * @param pourcentage, le pourcentage d'augmentation du salaire
	 */
	public void augmenterSalaire(int pourcentage) {
		if (pourcentage > 0) {
			setSalaire(((salaire / 100) * pourcentage) + salaire);
		}
	}
	
	/**
	 * Méthode
	 * @return la longevité de l'employé dans la boîte
	 */
	public long calculAnnuite() {
		long longevite = ChronoUnit.YEARS.between(this.DATE_EMBAUCHE, LocalDateTime.now());
		setLongevite(longevite);
		return getLongevite();
	}
}
