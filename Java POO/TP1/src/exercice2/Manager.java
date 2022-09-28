package exercice2;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Manager extends Employe{
	private Secretaire secretaire;
	private double bonus = calculAnnuite() * 0.5;
	
	/**
	 * Modificateur
	 * @param secretaire
	 */
	public void setSecretaire(Secretaire secretaire) {
		this.secretaire = secretaire;
	}
	
	/**
	 * Accesseur
	 * @return 
	 */
	public Secretaire getSecretaire() {
		return secretaire;
	}


	/**
	 * Constructeur
	 * @param unEmploye, le Manager est un employé avant tout
	 * @param laSecretaire, la secrétaire personnelle du manager
	 */
	public Manager(Employe unEmploye, Secretaire laSecretaire) {
		super(unEmploye, unEmploye.getSalaire(), unEmploye.getDateEmbauche());
		laSecretaire.getListManager().add(this);
	}

	public static Manager createManager(Employe unEmploye, Secretaire laSecretaire) {
		long age = ChronoUnit.YEARS.between(unEmploye.dateNaissance, LocalDateTime.now());
		if ( age > getAnneMin() && age < getAnneeMax()) {
			return new Manager(unEmploye, laSecretaire);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Méthode
	 *@param pourcentage, le pourcentage d'augmentation du salaire
	 */
	public void augmenterSalaire(int pourcentage) {
		if (pourcentage > 0) {
			setSalaire(((getSalaire() / 100) * (pourcentage + bonus)) + getSalaire());
		}
	}
	
	/**
	 * Méthode
	 * @param secretaire, change la secrétaire du manager
	 */
	public void changeSecretaire(Secretaire secretaire) {
		this.secretaire.enleveManager(this);
		setSecretaire(secretaire);
		secretaire.ajouteManager(this);
	}
}
