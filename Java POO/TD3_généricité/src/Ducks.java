

public class Ducks<T> {
    private T riri;
    private T fifi;
    private T loulou;

    public Ducks(T Riri, T Fifi, T Loulou){
        this.fifi = Fifi;
        this.riri = Riri;
        this.loulou = Loulou;
    }
    
    public T getRiri(){
        return this.riri;
    }

    public T getFifi(){
        return this.fifi;
    }

    public T getLoulou(){
        return this.loulou;
    }

    public String toString(Object e){
        
    }
}
