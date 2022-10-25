import java.lang.Math;

public class Racine {

    public static double calculer(double a) throws ValeurNegativeException{
        try{
            if (a < 0){
                throw new ValeurNegativeException(a);
            }
            return Math.sqrt(a);
        }
        catch(ValeurNegativeException e){
            return a;
        }
    }   
    
}
