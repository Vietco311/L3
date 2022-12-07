import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.io.BufferedReader;

public class App {
    public static void main(String[] args) throws Exception {
        Process proc = new Process();
        for(int i = 0; i < 10; i++){
            proc.run();
        }
    }
}
