package exercice0_3;

public class testAPI {

	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.random());
		double r = Math.random() * 3 + 1;
		int random = (int) r;
		System.out.println(random);
		int x1 = 20;
		int x2 = 16;
		System.out.println(Math.max(x1, x2));
		String n1 = "zbcd";
		String n2 = "dcba";
		if (n1.compareTo(n2) < 0) {
			System.out.println(n1);
		}
		else {
			System.out.println(n2);
		}
			
		
		
		

	}

}
