package exercice2;

import java.util.*;
import java.time.*;


public class Personne{
    protected static final Adresse ADRESSE_INCONNUE = null;
    protected String nom;
    protected String prenom;
    protected final LocalDateTime dateNaissance;
    protected Adresse adresse=ADRESSE_INCONNUE;
    protected static int nb_Personne;
	
	/**
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le pr�nom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
	 */
	public Personne(String leNom,String lePrenom, LocalDateTime laDate, Adresse lAdresse){
		nb_Personne++;
		nom = leNom.toUpperCase();
		prenom=lePrenom;
		dateNaissance=laDate;
		adresse=lAdresse;
	}
	
	/** 
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'année de naissance
	 * @param numero le n° de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
	 */
	public Personne(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville){
		this(leNom, lePrenom, LocalDateTime.of(a,m,j,0,0),new Adresse(numero,rue,code_postal,ville));
	}

	/**
	 * Accesseur
	 * @return retourne le nom
	 */
	public String getNom(){
		return nom;
	}
	/**
	 * Accesseur
	 * @return retourne le pr�nom
	 */
	public String getPrenom(){
		return prenom;
	}
	/**
	 * Accesseur
	 * @return retourne la date de naissance	 
	 */
	public LocalDateTime getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * Accesseur
	 * @return retourne l'adresse	 
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	
	/**
	 * Accesseur
	 * @return retourne le nombre de personne	 
	 */
	public static int getNb_Personne() {
		return nb_Personne;
	}

	/**
	 * Modificateur
	 * @param retourne l'adresse	 
	 */
	public void setAdresse(Adresse a) {
		adresse=a;
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String result="\nNom : "+nom+"\n"
		+"Pr�nom : "+prenom+"\n"+
		"Né(e) le : "+dateNaissance.getDayOfMonth()+
		"-"+dateNaissance.getMonthValue()+
		"-"+dateNaissance.getYear()+"\n"+
		"Adresse : "+
		adresse.toString();
		return result;
	}
	
	/**
	 * Compare l'âge de deux personnes
	 * @param p1, first person
	 * @param p2, second people
	 * @return
	 */
	public static boolean plusAgee(Personne p1, Personne p2) {
		return p1.dateNaissance.compareTo(p2.dateNaissance) < 0;
	}
	/**
	 * Compare l'âge de la personne actuelle avec une autre
	 * @param p1
	 * @return
	 */
	public boolean plusAgeeQue(Personne p1) {
		return plusAgee(this, p1);
	}
	
	public boolean equals(Object p1) {
		boolean result = false;
		if(p1 != null && p1 instanceof Personne) {
			Personne personne = (Personne) p1; 
			result = (this.nom.equals(personne.nom)
					&& this.prenom.equals(personne.prenom)
					&& this.dateNaissance.equals(personne.dateNaissance));
		}
		return result;
	}
}

    
   
   