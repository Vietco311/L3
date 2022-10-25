public class Calculatrice extends Affichage implements Operation{
    
    public Object addition(Object a, Object b){
        int aInt = (int) a;
        int bInt = (int) b;
        Object objRetour = aInt + bInt;
        return objRetour;
    }
    public Object soustraction(Object a, Object b){
        int aInt = (int) a;
        int bInt = (int) b;
        Object objRetour = aInt - bInt;
        return objRetour;
    }
    public Object multiplication(Object a, Object b){
        int aInt = (int) a;
        int bInt = (int) b;
        Object objRetour = aInt * bInt;
        return objRetour;
    }
    public Object division(Object a, Object b){
        int aInt = (int) a;
        int bInt = (int) b;
        Object objRetour = aInt / bInt;
        return objRetour;
    }

    public String toString(Object a){
        return "Resultat: " + a;
    }
}
