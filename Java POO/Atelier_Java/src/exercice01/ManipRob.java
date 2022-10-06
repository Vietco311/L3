package exercice01;

public class ManipRob {

	public static void main(String[] args) {
		Robot toto = new Robot("Toto", 10, 20, 3);
		Robot titi = new Robot("Titi");
		
		toto.avance();
		toto.tourne(2);
		toto.avance();
		System.out.println(toto); 
		titi.avance();
		titi.avance();
		titi.tourne(4);
		titi.avance();
		System.out.println(titi);
		
		
	}

}
