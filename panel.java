package biomarker1;
/*
the graphic inteface
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class panel extends javax.swing.JFrame {

    ArrayList seqs;
    ArrayList names;
    int tamanio_inicial;
    int tamanio_final;
    int filtro;
    String subseq;
    String path;
    goParal goParal = new goParal();

    public panel() {
        initComponents();
        this.setTitle("Mfind");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txt_tinicial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_subseq = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btn_reporte = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_tinicial.setText("4");
        txt_tinicial.setName(""); // NOI18N
        txt_tinicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tinicialActionPerformed(evt);
            }
        });

        jLabel1.setText("Size");

        jLabel3.setText("Find Microsatellites");

        txt_subseq.setText("Type a subsequence..");
        txt_subseq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_subseqActionPerformed(evt);
            }
        });

        jLabel4.setText("Count hits for this sub sequence");

        txt_filtro.setText("100");
        txt_filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_filtroActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Rios-Willars 2023\n\n1- Select your Fasta File and make sure there is a microSatellite first sequence\n2- Set the microSatellite size \n3- Hit Search Button\n4- Enjoy at Documents\\\\mfind_out.csv");
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_reporte.setText("Go");
        btn_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reporteActionPerformed(evt);
            }
        });

        jButton2.setText("Select Fasta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton2)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_tinicial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(175, 175, 175)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(162, 162, 162)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_subseq, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(292, 292, 292))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tinicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_subseq, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    public void publica(String s) {
        String texto = jTextArea1.getText();
        this.jTextArea1.setText(texto + s);
    }

    public void actualiza() {
        this.txt_filtro.setText(Integer.toString(this.filtro));
        this.txt_subseq.setText(this.subseq);
        this.txt_tinicial.setText(Integer.toString(this.tamanio_inicial));
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (this.path != null) {
            this.filtro = Integer.parseInt(this.txt_filtro.getText());
            this.subseq = this.txt_subseq.getText();
            this.tamanio_inicial = Integer.parseInt(this.txt_tinicial.getText());
            this.tamanio_final = this.tamanio_inicial; //Integer.parseInt(this.txt_tfinal.getText());
            if (goParal.Respaldo.size() == 0) {
                try {
                    goParal.primerCorrida(tamanio_inicial, tamanio_final, filtro, subseq, path);
                    System.out.println("Terminado -- ");
                } catch (InstantiationException ex) {
                    Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    goParal.otraCorrida(tamanio_inicial, tamanio_final, filtro, subseq, path);
                    System.out.println("Terminado -- ");
                } catch (InstantiationException ex) {
                    Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else
            this.jTextArea1.setText("Select you fasta file!");
    }                                        

    private void txt_tinicialActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void txt_subseqActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btn_reporteActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (!"Type a subsequence..".equals(this.txt_subseq.getText()) && !"What are you searching for?".equals(this.txt_subseq.getText()) && this.path != null) {
            motifCounter mC = new motifCounter(seqs, names);
            this.jTextArea1.setText(this.jTextArea1.getText() + " " + mC.find(this.txt_subseq.getText()));
        } else
            this.txt_subseq.setText("What are you searching for?");
    }                                           

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JFileChooser abrirArchivo;
        abrirArchivo = new JFileChooser();
        abrirArchivo.showOpenDialog(this);
        File f = abrirArchivo.getSelectedFile();
        this.jTextArea1.setText(f.getAbsolutePath());
        this.path = f.getAbsolutePath();
    }                                        

    private void txt_filtroActionPerformed(java.awt.event.ActionEvent evt) {                                           
    }                                          
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_reporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txt_filtro;
    private javax.swing.JTextField txt_subseq;
    private javax.swing.JTextField txt_tinicial;
    // End of variables declaration                   
}
