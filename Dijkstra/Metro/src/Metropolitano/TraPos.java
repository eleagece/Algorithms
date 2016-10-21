/*
 * TraPos.java
 *
 * Created on 27 de abril de 2007, 0:51
 */

package Metropolitano;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author  Antonio
 */
public class TraPos extends javax.swing.JFrame {
        private Grafo grafo;
    /** Creates new form TraPos */
    public TraPos(Grafo grafo) {
        initComponents();
        this.grafo=grafo;
        String Sestaciones[] = new String[grafo.thCodigos.size()];
        for(int i=0; i<grafo.thCodigos.size();i++){
            Sestaciones[i] = (String)grafo.thCodigos.get(i);            
        }
        jComboBox1.setModel(new DefaultComboBoxModel(Sestaciones));
        jComboBox2.setModel(new DefaultComboBoxModel(Sestaciones));
        
        String Sestaciones2[] = new String[grafo.thCodigos.size()+1];
        Sestaciones[0] = "";
        for(int i=0; i<grafo.thCodigos.size();i++){
            Sestaciones2[i+1] = (String)grafo.thCodigos.get(i);            
        }
        jComboBox3.setModel(new DefaultComboBoxModel(Sestaciones2));
        jComboBox4.setModel(new DefaultComboBoxModel(Sestaciones2));        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDesktopPane1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trayectos Posibles");
        jLabel1.setBounds(150, 40, 120, 14);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("Origen");
        jLabel2.setBounds(70, 70, 60, 20);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Destino");
        jLabel3.setBounds(70, 100, 50, 20);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Parada Intermedia");
        jLabel4.setBounds(70, 130, 110, 20);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Parada Intermedia");
        jLabel5.setBounds(70, 160, 110, 20);
        jDesktopPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox1.setBounds(180, 70, 110, 20);
        jDesktopPane1.add(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox2.setBounds(180, 100, 110, 22);
        jDesktopPane1.add(jComboBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton1.setBounds(170, 210, 80, 23);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox3.setBounds(180, 130, 110, 22);
        jDesktopPane1.add(jComboBox3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox4.setBounds(180, 160, 110, 22);
        jDesktopPane1.add(jComboBox4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String estacionOrigen = (String)jComboBox1.getSelectedItem();
String estacionDestino = (String)jComboBox2.getSelectedItem();
String estacionIntermedia1 = (String)jComboBox3.getSelectedItem();
String estacionIntermedia2 = (String)jComboBox4.getSelectedItem();
int estOrigen = (Integer)grafo.thEstaciones.get(estacionOrigen);
int estDestino = (Integer)grafo.thEstaciones.get(estacionDestino);
    ArrayList trayectos=new ArrayList();
if (estacionIntermedia1 == null && estacionIntermedia2 == null) 
 {

    trayectos=grafo.trayectosDos(estOrigen,estDestino);
 }
else
 {
    ArrayList Intermedias = new ArrayList();
    if (estacionIntermedia1 != null) {
        int estIntermedia1= (Integer)grafo.thEstaciones.get(estacionIntermedia1);
        Intermedias.add(estIntermedia1);        
    }
    if (estacionIntermedia2 != null) {
        int estIntermedia2 = (Integer)grafo.thEstaciones.get(estacionIntermedia2);
        Intermedias.add(estIntermedia2);
    }

       trayectos = grafo.todosTrayectosDos(estOrigen,estDestino,Intermedias);
}        
    TrayectosBuscador tr = new TrayectosBuscador(trayectos,grafo);
    tr.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TraPos().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
    
}
