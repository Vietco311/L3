package exercice2;

import java.time.LocalDateTime;

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
	

	public Secretaire getSecretaire() {
		return secretaire;
	}


	/**
	 * Constructeur
	 * @param unEmploye, le Manager est un employé avant tout
	 * @param laSecretaire, la secrétaire personnelle du manager
	 */
	public Manager(Employe unEmploye, Secretaire laSecretaire) {
		super(unEmploye, unEmploye.salaire, unEmploye.dateEmbauche);
		laSecretaire.getListManager().add(this);
	}
	
	/**
	 * Méthode
	 *@param pourcentage, le pourcentage d'augmentation du salaire
	 */
	public void augmenterSalaire(int pourcentage) {
		if (pourcentage > 0) {
			setSalaire(((salaire / 100) * (pourcentage + bonus)) + salaire);
		}
	}
	
	/**
	 * Méthode
	 * @param secretaire, change la secrétaire du manager
	 */
	public void changeSecretaire(Secretaire secretaire) {
		setSecretaire(secretaire);
		secretaire.getListManager().remove(this);
	}
}
