import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

        //EXERCICE 1
        List<String> pokemons = new ArrayList<>();
        pokemons.add("Pikachu");
        pokemons.add("Bulbizarre");
        pokemons.add("Salamèche");
        pokemons.add("Carapuce");

        for(int i = 0; i < pokemons.size(); i++){
            System.out.println(pokemons.get(i));
        }

        pokemons.add(0, "Magikarpe");
        pokemons.remove(1);

        for(int i = 0; i < pokemons.size(); i++){
            System.out.println(pokemons.get(i));
        }

        //EXERCICE 2

        ArrayList<Integer> entier1 = new ArrayList<>();
        entier1.ensureCapacity(100);

        for(int i = 0; i < 100; i++){
            entier1.add((int)(Math.random() * 1000));
        }

        entier1.sort(null);
        System.out.println(entier1);

        //EXERCICE 3

        PriorityQueue<Integer> entier2 = new PriorityQueue<>();

        for(int i = 0; i < 100; i++){
            entier2.add((int)(Math.random() * 1000));
        }

        for(int i = 0; i < 100; i++){
            System.out.println(entier2.poll());
        }

        //EXERCICE 4

        Set<Integer> ensemble = new TreeSet<>();
        for(int i = 0; i < 1000; i++){
            ensemble.add((int) (Math.random() * 10));
        }
        System.out.println(ensemble);

        //EXERCICE 5

        Map<Integer, String> tableau = new HashMap<>();
        tableau.put(20191218, "Buteau Lucia");
        tableau.put(20191219, "Castelli Serena");
        tableau.put(20191220, "Jond Jean");

        System.out.println(tableau);

        //EXERCICE 6

        List<String> phrase = new ArrayList<>();
        Collections.sort(phrase, new ComparatorAlph());
    }
}
