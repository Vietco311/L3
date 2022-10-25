public class ValeurNegativeException extends Exception{
    
    public ValeurNegativeException(double a){
        super();
        System.err.println(a + "ne doit pas être négatif");
    }
}
