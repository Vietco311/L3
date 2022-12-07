import java.io.IOException;
import java.util.Random;

public class Process extends Thread{
    Random rand = new Random();
    public Process(){
        super();
    }

    public void run(){
        int a = rand.nextInt(100);
        int b = rand.nextInt(100);
        int c = a + b;
        System.out.println(c);
        try {
            Thread.sleep(rand.nextInt(10)* 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
    }
}
