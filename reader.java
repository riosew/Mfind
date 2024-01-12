package biomarker1;
/*
the class for the parallel reader
*/

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class reader extends Thread {

    String S;
    public RandomAccessFile fichero = null;
    int numLines;
    boolean busy;

    public void setup(String archa) throws IOException {
        this.fichero = new RandomAccessFile(archa, "r");
    }

    @Override
    public void run() {                                                         // this is the process that runs in parallel threads
        this.busy = true;
        try {
            fichero.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cadena = null;
        try {
            cadena = fichero.readLine();
        } catch (IOException ex) {
            Logger.getLogger(reader.class.getName()).log(Level.SEVERE, null, ex);
        }

        int c = 0;
        while (cadena != null) {
            this.S += cadena;
            c++;
            try {
                cadena = fichero.readLine();
            } catch (IOException ex) {
                Logger.getLogger(reader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            fichero.close();
        } catch (IOException ex) {
            Logger.getLogger(reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.busy = false;
    }
}
