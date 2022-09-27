package exercice1_2;

public class test {

	public static void main(String[] args) {
		ManipEntier entier1 = new ManipEntier();
		ManipEntier entier2 = new ManipEntier(3);
		ManipEntier entier3 = new EntierFou(5);
		entier1.incremente();
		entier2.incremente(2);
		entier3.incremente();
		entier1.incremente();
		entier2.incremente(3);
		entier3.incremente();
		entier1.incremente();
		entier2.incremente(4);
		entier3.incremente();
		System.out.println(entier1 + " 4");
		System.out.println(entier2 + " 8");
		System.out.println(entier3);
	}

}
