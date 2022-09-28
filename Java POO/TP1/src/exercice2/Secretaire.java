package exercice2;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author User
 *
 */
public class Secretaire extends Employe{
	private List<Manager> listManager = new ArrayList<Manager>();
	private int nbManager = 0;
	private double bonus = 0;
	
	/**
	 * @param unEmploye, la secrétaire est une employé avant tout
	 * @param unManager, le premier manager attribué à cette secrétaire
	 */
	public Secretaire(Employe unEmploye) {
		super(unEmploye, unEmploye.getSalaire(), unEmploye.getDateEmbauche());
		
	}

	/**
	 * Accesseur
	 * @return listManager, la liste de manager pour lesquels la secrétaire travaille.
	 */
	public List<Manager> getListManager() {
		return listManager;
	}
	
	
	/**
	 * Modificateur
	 * @param bonus
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	
	/**
	 * Méthode
	 * @param laPersonne, la personne employé
	 * @param leSalaire
	 * @param laDateEmbauche
	 * @return un employé qui est dans les limites d'âges pour travailler
	 */
	public static Secretaire createSecretaire(Employe unEmploye) {
		long age = ChronoUnit.YEARS.between(unEmploye.dateNaissance, LocalDateTime.now());
		if ( age > getAnneMin() && age < getAnneeMax()) {
			return new Secretaire(unEmploye);
		}
		else {
			return null;
		}
	}

	/**
	 * Méthode
	 * @param manager, un des managers à enlever
	 */
	public void enleveManager(Manager manager) {
		this.listManager.remove(manager);
		this.nbManager--;
	}
	
	/**
	 * Méthode
	 * @param manager, un manager à ajouter
	 */
	public void ajouteManager(Manager manager) {
		if (listManager.size() <= 6 && !(listManager.contains(manager))) {
			this.listManager.add(manager);
			this.nbManager++;
		}
	}
	
	/**
	 * Méthode
	 * @param secretaire, change la secrétaire du manager
	 */
	public void augmenterSalaire(int pourcentage) {
		if (pourcentage > 0 && listManager.size() > 0) {
			setBonus(listManager.size() * 0.1);
		}
		setSalaire(((getSalaire() / 100) * (pourcentage + bonus)) + getSalaire());
	}
}
