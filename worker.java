package biomarker1;
/*
The class for the microsatellite search. this process runs un parallel threads
*/

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class worker extends Thread {

    String sproblema;
    String seq;
    boolean busy;
    int archivoNum;
    printer printer;
    int cnt;

    public void setup(String sproblema, String seq, int archivoNum, printer printer) {
        this.sproblema = new String(sproblema);
        this.seq = new String(seq);
        this.archivoNum = archivoNum;
        this.printer = printer;
        this.cnt = 0;
    }

    @Override
    public void run() {
        busy = true;
        boolean done = false;
        Random rn = new Random();
        while (seq.contains(sproblema)) {                                       //validation and count of the microsatellite
            seq = seq.substring(seq.indexOf(sproblema) + 1);
            this.cnt++;
            System.gc();
            done = false;
        }
        this.busy = false;
        String line = " " + sproblema + ", hits: ," + Integer.toString(cnt) + ", Seq Num: ," + archivoNum + " , ";
        System.out.println(line);
        while (done == false) {
            if (printer.busy == false) {
                printer.print(line);
                done = true;
            }
            for (int r = 0; r < rn.nextInt(100); r++) {
            }
        }
    }
}
