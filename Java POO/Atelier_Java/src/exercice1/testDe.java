package exercice1;

public class testDe {

	public static void main(String[] args) {
		Des de1 = new Des();
		Des de2 = new Des("", 60);
		Des de3 = new DePipe("Dépipé", 52, 20);
		Des de4 = new DeMemoire();
		//Des de5 = new DeAutre();
		Des de6 = new Des(2);
		System.out.println(de1.lancer());
		System.out.println(de2.lancer(6));
		System.out.println(de2);
		System.out.println(de3);
		System.out.println(de4);
		//System.out.println(de5);
		System.out.println(de6);
		System.out.println(de3.lancer());
		System.out.println(de4.lancer() + "De memoire");
		System.out.println(de4.lancer() + "De memoire");
		//System.out.println(de5.lancer());
		System.out.println(de6 + " 6");
	}

}
