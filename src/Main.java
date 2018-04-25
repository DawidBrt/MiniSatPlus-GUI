import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static String script = "MiniSat+/run.sh";
    private static String problem = "MiniSat+/Examples/garden9x9.opb";
    private static String solution = "Solution/ans.txt";

    public static void main(String[] args) throws IOException {
        Process procBuildScript = new ProcessBuilder(script, problem).start();
        System.out.println("Script is running...");
        try {
            procBuildScript.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(solution);
            br = new BufferedReader(fr);

            String currentLine;
            String previousLine = null;

            while ((currentLine = br.readLine()) != null) {
                if(currentLine.startsWith("s")) {
                    System.out.println(previousLine);
                    System.out.println(currentLine);
                }
                else if(currentLine.startsWith("v")){
                    System.out.println(currentLine);
                }
                previousLine=currentLine;
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }
}
