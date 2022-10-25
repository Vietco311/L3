public class RetraitException extends Exception {
    
    public RetraitException(int e){
        System.err.println("retrait impossible: " + e + "est trop grand");
    }
}
