import java.util.Comparator;

public class ComparatorInv implements Comparator{
    public int compare(Object o1, Object o2){
        int result;
        char char1 = (char) o1;
        char char2 = (char) o2;
        int ascii1 = char1;
        int ascii2 = char2;
        if (ascii1 > ascii2){
            result = -1;
        } else if ( ascii1 == ascii2){
            result = 0;
        } else {
            result = 1;
        }
        return result;
    }
}
