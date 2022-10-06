package tp1.test;

import exercice2.Personne;
import exercice2.Secretaire;

import java.time.LocalDateTime;

import exercice2.Employe;
import exercice2.Manager;

public class TestQuestion1 {

	public static void main(String[] args) {
		Personne p1 = new Personne("Colin", "Anthony", 11, 3, 2002, 20, "Av. Président Pierucci", "20250", "Corte");
		Personne p2 = new Personne("Colin", "Karine", 12, 12, 2003, 20, "Av. Président Pierucci", "20250", "Corte");
		Personne p3 = new Personne("Garau", "Thomas", 6, 1, 2001, 22, "Av. Jean Nicoli", "20250", "Corte");
		Personne p4 = new Personne("Grondin", "David", 3, 1, 2002, 666, "Aux Arènes je sais plus où", "34000", "Montpellier");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2));
		System.out.println(Personne.plusAgee(p1, p2));
		System.out.println(p1.plusAgeeQue(p2));
		LocalDateTime em1 = LocalDateTime.of(2020, 2, 2, 0, 0);
		LocalDateTime em2 = LocalDateTime.of(2021, 2, 2, 0, 0);
		Employe e1 = Employe.createEmployee(p3, 3000, em1);
		System.out.println(e1.getSalaire());
		
		System.out.println(e1.getSalaire());
		System.out.println(e1.calculAnnuite());
		Employe e2 = Employe.createEmployee(p1, 4000, em1);
		Employe e3 = Employe.createEmployee(p4, 4000, em2);
		Secretaire s1 = new Secretaire(e1);
		Manager m1 = new Manager(e2, s1);
		Manager m2 = new Manager(e3, s1);
		Employe e4 = Employe.createEmployee(p2, 3000, em2);
		Secretaire s2 = new Secretaire(e4);
		m1.augmenterSalaire(10);
		m2.augmenterSalaire(10);
		s1.augmenterSalaire(10);
		s2.augmenterSalaire(10);
		System.out.println(m1.getSalaire());
		System.out.println(m2.getSalaire());
		System.out.println(s1.getSalaire());
		System.out.println(s2.getSalaire());
		m1.changeSecretaire(s2);
		s1.enleveManager(m2);
		s2.ajouteManager(m2);
		System.out.println(m1.getSecretaire());
		System.out.println(m2.getSecretaire());
		System.out.println(s1.getListManager());
		System.out.println(s2.getListManager());
		
	}

}
