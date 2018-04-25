import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Just run script and check if it works");

        Process procBuildScript = new ProcessBuilder("MiniSat+/run.sh", "MiniSat+/Examples/garden9x9.opb").start();

        System.out.println("Yeah! It works");
    }
}
