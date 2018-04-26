package script;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScriptRunner {
    private String script = "MiniSat+/run.sh";
    private String problem = "MiniSat+/Examples/garden9x9.opb";
    private String solution = "Solution/ans.txt";


    public void setProblem(String path) {
        this.problem = path;
    }

    public void runScript() {
        StringBuffer output = new StringBuffer();
        System.out.println(problem);
        Process p;
        try {
            String[] commands = new String[]{script, problem};
            p = Runtime.getRuntime().exec(commands);
            p.waitFor();
            BufferedReader br = null;
            FileReader fr = null;
            try {
                fr = new FileReader(solution);
                br = new BufferedReader(fr);

                String currentLine;
                String previousLine = null;

                while ((currentLine = br.readLine()) != null) {
                    if (currentLine.startsWith("s")) {
                        System.out.println(previousLine);
                        System.out.println(currentLine);
                    } else if (currentLine.startsWith("v")) {
                        System.out.println(currentLine);
                    }
                    previousLine = currentLine;
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}