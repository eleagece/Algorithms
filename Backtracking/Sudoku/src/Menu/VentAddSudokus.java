package Menu;
import javax.swing.*;
public class VentAddSudokus extends javax.swing.JPanel 
 {
 private VentRaiz vRaiz;
 public VentAddSudokus(VentRaiz vRaiz) 
  {
  initComponents();
  this.vRaiz=vRaiz;
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroupGenerarSudoku = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonDisco = new javax.swing.JRadioButton();
        jRadioButtonManual = new javax.swing.JRadioButton();
        jRadioButtonAleatorio = new javax.swing.JRadioButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A\u00f1adir sudoku...");
        jLabel1.setBounds(0, 20, 400, 50);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroupGenerarSudoku.add(jRadioButtonDisco);
        jRadioButtonDisco.setText("...desde disco");
        jRadioButtonDisco.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonDisco.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonDisco.setBounds(140, 110, 190, 15);
        jDesktopPane1.add(jRadioButtonDisco, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroupGenerarSudoku.add(jRadioButtonManual);
        jRadioButtonManual.setText("...manualmente");
        jRadioButtonManual.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonManual.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonManual.setBounds(140, 140, 180, 15);
        jDesktopPane1.add(jRadioButtonManual, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroupGenerarSudoku.add(jRadioButtonAleatorio);
        jRadioButtonAleatorio.setText("...aleatoriamente");
        jRadioButtonAleatorio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonAleatorio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonAleatorio.setBounds(140, 170, 190, 15);
        jDesktopPane1.add(jRadioButtonAleatorio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonAceptar.setBounds(90, 230, 90, 30);
        jDesktopPane1.add(jButtonAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonVolver.setBounds(200, 230, 90, 30);
        jDesktopPane1.add(jButtonVolver, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
 //******************************************//
 //*** Objetos gráficos *********************//
 //******************************************//    
    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
     VentAdmin vAdmin=new VentAdmin(vRaiz);
     vAdmin.setVisible(true);
     vAdmin.setSize(2000,2000);
     vRaiz.remove(this);
     vRaiz.add(vAdmin);
     vRaiz.pack();
    }//GEN-LAST:event_jButtonVolverActionPerformed
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
     if (jRadioButtonDisco.isSelected()) 
      {
      // Añadir sudoku desde .XML 
      VentAddSudokuXML vAddSudokuXML=new VentAddSudokuXML(vRaiz);
      vAddSudokuXML.setVisible(true);
      vAddSudokuXML.setSize(2000,2000);
      vRaiz.remove(this);
      vRaiz.add(vAddSudokuXML);
      vRaiz.pack();
      } 
     else if (jRadioButtonManual.isSelected()) 
      {
      // Añadir sudoku manualmente
      VentAddSudokuManual vAddSudokuManual=new VentAddSudokuManual(vRaiz);
      vAddSudokuManual.setVisible(true);
      vAddSudokuManual.setSize(2000,2000);
      vRaiz.remove(this);
      vRaiz.add(vAddSudokuManual);
      vRaiz.pack();
      } 
     else if (jRadioButtonAleatorio.isSelected()) 
      {
      // Añadir sudoku aleatoriamente
      VentAddSudokuAleatorio vAddSudokuAleatorio=new VentAddSudokuAleatorio(vRaiz);
      vAddSudokuAleatorio.setVisible(true);
      vAddSudokuAleatorio.setSize(2000,2000);
      vRaiz.remove(this);
      vRaiz.add(vAddSudokuAleatorio);
      vRaiz.pack();
      }
    }//GEN-LAST:event_jButtonAceptarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupGenerarSudoku;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButtonAleatorio;
    private javax.swing.JRadioButton jRadioButtonDisco;
    private javax.swing.JRadioButton jRadioButtonManual;
    // End of variables declaration//GEN-END:variables
 }
