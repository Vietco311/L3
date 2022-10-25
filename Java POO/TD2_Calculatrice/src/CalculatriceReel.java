public class CalculatriceReel extends Affichage implements Operation{

    public Object addition(Object a, Object b){
        double aDouble = (double) a;
        double bDouble = (double) b;
        Object objRetour = aDouble + bDouble;
        return objRetour;
    }
    public Object soustraction(Object a, Object b){
        Double aDouble = (Double) a;
        Double bDouble = (Double) b;
        Object objRetour = aDouble - bDouble;
        return objRetour;
    }
    public Object multiplication(Object a, Object b){
        Double aDouble = (Double) a;
        Double bDouble = (Double) b;
        Object objRetour = aDouble * bDouble;
        return objRetour;
    }
    public Object division(Object a, Object b){
        Double aDouble = (Double) a;
        Double bDouble = (Double) b;
        Object objRetour = aDouble / bDouble;
        return objRetour;
    }

    public String toString(Object a){
        return "Resultat: " + a;
    }
}
