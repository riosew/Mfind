package biomarker1;

/*
* Process for microsatellite count on a given slide window
*/

import java.util.ArrayList;

public class motifCounter {

    ArrayList seqs;
    ArrayList names;

    motifCounter(ArrayList seqs, ArrayList names) {
        this.seqs = seqs;
        this.names = names;
    }

    public String find(String motif) {
        String sTextoBuscado = motif;
        int contador = 0;
        int numSeqTurno = 0;
        String S = "";

        for (Object seq : seqs) {
            contador = 0;
            String SeqTurno = (String) seq;
            String sTexto = SeqTurno;
            while (sTexto.contains(sTextoBuscado)) {
                sTexto = sTexto.substring(sTexto.indexOf(sTextoBuscado) + 1);
                contador++;                                                     //increment the counter while the window containes the microsatellite
            }
            System.out.println("For sequence " + names.get(numSeqTurno) + " And subsequence " + sTextoBuscado + " hit count: " + contador);
            S = S + " \n For sequence " + names.get(numSeqTurno) + " And subsequence " + sTextoBuscado + " hit count: " + contador + "\n";
            numSeqTurno++;
        }
        S = S + "--------------------------\n ";
        return S;
    }
}
