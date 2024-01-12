package biomarker1;

/*
 * Paralell process for microsatellite search
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class goParal {

    ArrayList Respaldo = new ArrayList();

    public void primerCorrida(int inic, int finl, int filtro, String subseq, String path) throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        ArrayList seqs = new ArrayList();
        ArrayList workers = new ArrayList();
        ArrayList names = new ArrayList();
        FastaFileConsole FR = new FastaFileConsole();
        panel panel = new panel();
        panel.filtro = filtro;
        panel.subseq = subseq;
        panel.tamanio_final = finl;
        panel.tamanio_inicial = inic;
        panel.path = path;
        panel.actualiza();
        System.out.println(panel.path);

        
        FR.use(panel.path);
        seqs = FR.armaSeqs();
        names = FR.armaNames();

        this.Respaldo = (ArrayList) seqs.clone();

        names.add(">MicroSat");
        final String name1 = (String) names.get(0);                             //saves the first sequence as the problem sequence
        final String S1 = (String) seqs.get(0);
        seqs.remove(0);
        names.remove(0);
        panel.seqs = seqs;
        panel.names = names;
        String SubSeqS1 = "";
        int rangooffsetA = inic;
        int rangooffsetB = finl;
        worker wk1 = new worker();                                              //the parallel readers are named workers
        worker wk2 = new worker();
        ArrayList record = new ArrayList();

        for (int i = rangooffsetA; i <= rangooffsetB; i++) {
            int offset = i;
            int indxI = 0;
            int indxF = indxI + offset;
            System.out.println("longitud actual: " + offset);                   //stablish the microsatellite length 
            int contador = 0;
            Class miclase = Class.forName("biomarker1.worker");
            printer printer = new printer();
            while (indxF <= S1.length()) {
                int c = 0;//**
                while (seqs.size() > 0) {
                    System.out.println("seqs size " + seqs.size());
                    if (indxF <= S1.length()) {
                        SubSeqS1 = S1.substring(indxI, indxF);
                        String sTextoBuscado = SubSeqS1;
                        wk1.setup(sTextoBuscado, (String) seqs.get(seqs.size() - 1), seqs.size() - 1, printer);
                        seqs.remove(seqs.size() - 1);
                        wk2.setup(sTextoBuscado, (String) seqs.get(seqs.size() - 1), seqs.size() - 1, printer);
                        seqs.remove(seqs.size() - 1);
                        wk1.start();                                            //start the work
                        wk2.start();
                        try {
                            wk2.join();
                            wk1.join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(goParal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        wk1 = (worker) miclase.newInstance();
                        wk2 = (worker) miclase.newInstance();

                    }

                    System.gc();
                }
                indxI++;
                indxF++;
                while (this.compruebaBusy(workers) > 0) {                       //empty
                }
                workers.clear();
            }
        }
    }

    public void otraCorrida(int inic, int finl, int filtro, String subseq, String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
                                                                                //process for a second run
        ArrayList seqs = new ArrayList();
        ArrayList workers = new ArrayList();
        ArrayList names = new ArrayList();
        FastaFileConsole FR = new FastaFileConsole();
        panel panel = new panel();
        panel.filtro = filtro;
        panel.subseq = subseq;
        panel.tamanio_final = finl;
        panel.tamanio_inicial = inic;
        panel.path = path;
        panel.actualiza();
        System.out.println(panel.path);
        seqs = (ArrayList) this.Respaldo.clone();
        System.out.println("segunda vez!!");
        names.add(">Human");
        String name1 = (String) names.get(0);
        String S1 = (String) seqs.get(0);
        seqs.remove(0);
        names.remove(0);
        panel.seqs = seqs;
        panel.names = names;
        String SubSeqS1 = "";

        int rangooffsetA = inic;
        int rangooffsetB = finl;
        ArrayList record = new ArrayList();

        for (int i = rangooffsetA; i <= rangooffsetB; i++) {
            int offset = i;
            int indxI = 0;
            int indxF = indxI + offset;
            int contador = 0;

            String SeqTurno = null;
            Class miclase = Class.forName("biomarker1.worker");
            printer printer = new printer();

            while (indxF <= S1.length()) {
                int c = 0;//**
                while (c <= seqs.size() - 1) {
                    if (this.compruebaBusy(workers) <= 4) {
                        SeqTurno = (String) seqs.get(c);
                        if (indxF <= S1.length()) {                               //creates worker
                            SubSeqS1 = S1.substring(indxI, indxF);
                            String sTextoBuscado = SubSeqS1;
                            worker miobjeto = (worker) miclase.newInstance();
                            miobjeto.setup(sTextoBuscado, SeqTurno, c, printer);
                            miobjeto.start();
                            workers.add(miobjeto);

                            c++;
                        }
                    }
                    System.gc();
                }
                indxI++;
                indxF++;
                while (this.compruebaBusy(workers) > 0) {                       //vacía
                }
                workers.clear();
            }
        }
    }

    public int compruebaBusy(ArrayList Lista) {                                 //validation of busy readers
        Iterator iT = Lista.iterator();
        int c = 0;
        while (iT.hasNext()) {
            worker rd = new worker();
            rd = (worker) iT.next();
            if (rd.isAlive()) {
                c++;
            } else {
                iT.remove();
            }
        }
        return c;
    }
}
