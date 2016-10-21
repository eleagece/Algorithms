package GUI;
import com.sun.org.apache.xerces.internal.util.XML11Char;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
public class Ventana1 extends javax.swing.JFrame 
 {
 private ArrayList listaParticipantes=new ArrayList();
 private Principal referencia=null;
 public Ventana1(Principal aux)  
  {
  // ---------------------------------------------------------------------------------//
  // CONSTRUCTOR inicial de Ventana1. Es el que se llama cuando lo hacemos desde el   //
  // menú principal                                                                   //
  // ---------------------------------------------------------------------------------//
  // *param* aux: Referencia al formulario principal (para botón cancelar)            //
  // ---------------------------------------------------------------------------------//
  referencia=aux;
  initComponents();
  }
 public Ventana1(ArrayList listaParticipantes, Principal aux)
  {
  // ---------------------------------------------------------------------------------//
  // CONSTRUCTOR al que se llama desde Ventana2 cuando queremos añadir más partici-   //
  // pantes en la competición                                                         //
  // ---------------------------------------------------------------------------------//
  // *param* listaParticipantes: lista de participantes (nb, ap1, ap2, dni) que hay   //
  //   ya registrados. Se pasa para añadir los nuevos en él                           //
  // *param* aux: Referencia al formulario principal (para botón cancelar)            //
  // ---------------------------------------------------------------------------------//
  referencia=aux;
  this.listaParticipantes=listaParticipantes;
  initComponents();   
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("DATOS PARTICIPANTE");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido 1");

        jLabel4.setText("Apellido 2");

        jLabel5.setText("DNI");

        jButton1.setText("Aceptar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Siguiente >");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(74, 74, 74)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel1)
                        .add(85, 85, 85))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jButton1)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel2)
                                .add(jLabel3)
                                .add(jLabel4)
                                .add(jLabel5)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 47, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jTextField4)
                                    .add(jTextField3)
                                    .add(jTextField2)
                                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(57, 57, 57))
                            .add(layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(jButton2)
                                .add(17, 17, 17)
                                .add(jButton3)))))
                .add(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(46, 46, 46)
                .add(jLabel1)
                .add(33, 33, 33)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(33, 33, 33)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2)
                    .add(jButton3))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
     // ---------------------------------------------------------------------------------//
     // BOTÓN CANCELAR deja referenciada la ventana principal y cierra la actual         //
     // ---------------------------------------------------------------------------------//
     referencia.jMenuItem3.setEnabled(true);
     this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
     // ---------------------------------------------------------------------------------//
     // BOTÓN SIGUIENTE crea la ventana de procesamiento pasándole la lista de parti-    //
     // cipantes que contiene los datos en el orden (nb1,apA1,apB1,dni1,nb2,apA2...)     //
     // y la referencia a la ventana principal. Además cierra la ventana actual          //
     // ---------------------------------------------------------------------------------//
     Ventana2 ventanaProcesar=new Ventana2(listaParticipantes, referencia);  // Creamos una nueva ventana con 
     ventanaProcesar.setVisible(true);  // Hacemos visible la nueva ventana
     this.dispose();  // Y eliminamos la actual
    }//GEN-LAST:event_jButton2MouseClicked
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
     // ---------------------------------------------------------------------------------//
     // BOTÓN ACEPTAR rellena la lista de participantes con lo pasado por los JTextField //
     // ---------------------------------------------------------------------------------//
     listaParticipantes.add(jTextField1.getText());
     listaParticipantes.add(jTextField2.getText());
     listaParticipantes.add(jTextField3.getText());
     listaParticipantes.add(jTextField4.getText());
     jTextField1.setText("");
     jTextField2.setText("");
     jTextField3.setText("");
     jTextField4.setText("");
    }//GEN-LAST:event_jButton1MouseClicked
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
    
}
