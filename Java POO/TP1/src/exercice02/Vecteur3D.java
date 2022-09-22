package exercice02;
import static java.lang.Math.sqrt;


public class Vecteur3D {
	private double x = 0;
	private double y = 0;
	private double z = 0;
	
	public Vecteur3D(double x, double y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vecteur3D() {
	}
	
	public void afficheVecteur() {
		System.out.println("<" + x + "," + y + "," + z + ">");
	}
	
	public double getNorme() {
		return sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}
	
	public double produitScalaire(Vecteur3D vecteur) {
		return this.x * vecteur.x + this.x * vecteur.y + this.x * vecteur.z;
		
	}
	public String somme(Vecteur3D vecteur) {
		return (this.x + vecteur.x) + "," + (this.y + vecteur.y) + (this.z + vecteur.z);
	}
	
	public static double produitScalaireStatic(Vecteur3D vecteur1, Vecteur3D vecteur2) {
		return vecteur1.x * vecteur2.x + vecteur1.y * vecteur2.y + vecteur1.z * vecteur2.z;
		
	}
	
	public static String sommeStatic(Vecteur3D vecteur1, Vecteur3D vecteur2) {
		return (vecteur1.x + vecteur2.x) + "," + (vecteur1.y + vecteur2.y) + "," + (vecteur1.z + vecteur2.z);
	}
}
