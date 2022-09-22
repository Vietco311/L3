package exercice02;

public class test {

	public static void main(String[] args) {
		Vecteur3D prime = new Vecteur3D(2,6,7);
		Vecteur3D second = new Vecteur3D(-4,3,-1);
		
		prime.afficheVecteur();
		System.out.println(prime.getNorme());
		second.afficheVecteur();
		System.out.println(second.getNorme());
		prime.produitScalaire(second);
		prime.somme(second);
		System.out.println(Vecteur3D.produitScalaireStatic(prime, second));
		System.out.println(Vecteur3D.sommeStatic(prime, second));
	}

}
