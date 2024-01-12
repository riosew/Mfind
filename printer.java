package biomarker1;
/*
this class builds a csv file with the microsatellite findings
*/

import java.io.FileWriter;
import java.io.PrintWriter;

public class printer {

    boolean busy;

    public void print(String line) {
        busy = true;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\ernes\\OneDrive\\Documents\\mfind_out.csv", true);  //change the destination if you like. Create it first!!
            pw = new PrintWriter(fichero);
            pw.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            busy = false;
        }
    }
}
