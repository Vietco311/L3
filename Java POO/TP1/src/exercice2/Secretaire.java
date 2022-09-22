package exercice2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 *
 */
public class Secretaire extends Employe{
	private List<Manager> listManager = new ArrayList<Manager>();
	private int nbManager = 0;
	private double bonus = 0;
	
	/**
	 * Accesseur
	 * @return listManager, la liste de manager pour lesquels la secrétaire travaille.
	 */
	public List<Manager> getListManager() {
		return listManager;
	}
	


	public void setBonus(double bonus) {
		this.bonus = bonus;
	}




	/**
	 * @param unEmploye, la secrétaire est une employé avant tout
	 * @param unManager, le premier manager attribué à cette secrétaire
	 */
	public Secretaire(Employe unEmploye) {
		super(unEmploye, unEmploye.salaire, unEmploye.dateEmbauche);
		
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
		if (listManager.size() <= 6) {
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
		setSalaire(((salaire / 100) * (pourcentage + bonus)) + salaire);
	}
}
