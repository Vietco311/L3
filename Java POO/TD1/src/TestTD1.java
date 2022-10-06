import java.util.ArrayList;
import java.util.List;

public class TestTD1 {

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int addition2(int[] c) {
        int result = 0;
        for (int i = 0; i < c.length; i++) {
            result += c[i];
        }
        return result;
    }

    public static String tableMult(int a){
        String result = "";
        for (int i = 0; i <= 10; i++){
            int calc = a * i;
            result += a + "x" + i + "=" + calc + "\n";  
        }
        return result;
    }

    public static double aireCercle(int a){
        return Math.pow(Math.PI * a, 2);
    }

    public static double periCercle(int a){
        return 2 * Math.PI * a;
    }

    public static double moyenne(int[] c){
        double calc = 0;
        for (int i = 0; i < c.length; i++){
            calc += c[i];
        }
        return calc/c.length;
    }

    public static String reverse(String d){
        String result = "";
        for (int i = d.length()-1; i >= 0; i--){
            result += d.charAt(i);
        }
        return result;
    }

    public static int ascii(char a){
        return a;
    }

    public static double fToC(double a){
        double calc = (double)(a - 32) * 5/9;
        return calc;
    }

    public static double cToF(double a){
        double calc = (double)9/5*a + 32;
        return calc;
    }

    public static boolean nbrPremier(int a){
        boolean result = true;
        if (a == 1){
            return false;
        }
        for (int i = 2; i < a; i++){
            if (a%i == 0){
                result  =  false;
                break;
            }
            else {
                continue;
            }
        }
        return result;
    }

    public static List<Integer> premiers(int a){
        List<Integer> nbrPremier = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++){
            if (nbrPremier(i)){
                nbrPremier.add(i);
            }
        }
        return nbrPremier;
    }
}
