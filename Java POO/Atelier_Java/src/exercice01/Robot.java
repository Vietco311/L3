package exercice01;

public class Robot {
	private String ref;
	private String name;
	private int x = 0;
	private int y = 0;
	private int orientation;
	private static int nb_robot;
	
	public Robot(String nName, int x, int y, int orientation) {
		this.name = nName;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.ref = "ROB" + nb_robot;
		nb_robot ++;
	}
	
	public Robot(String nName ) {
		this.name = nName;
		this.x = 0;
		this.y = 0;
		this.orientation = 1;
		this.ref = "ROB" + nb_robot;
		nb_robot ++;
	}
	
	public void tourne(int orientation) {
		if (orientation < 1 || orientation > 4) {
			throw new IllegalArgumentException(orientation + " is not a valid orientation. North = 1, East = 2, South = 3, West = 4");
		}
		this.orientation = orientation;
	}
	
	public void avance() {
		
		if (orientation == 1) {
			y ++;
		}
		else if (orientation == 2) {
			x ++;
		}
		else if (orientation == 3 && y != 0) {
			y --;
		}
		else if (orientation == 4 && x != 0){
			x --;
		}
			
	}
	
	public void afficheToi() {
		System.out.println("Nom: " + name + "; Coordonnées: " + x + "," + y + "; Orientation: " + orientation);
	}
	
	public String toString() {
		return "Nom: " + name + "; Coordonnées: " + x + "," + y + "; Orientation: " + orientation;
	}
}
