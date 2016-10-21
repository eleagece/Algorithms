package Menu;
import javax.swing.*;
public class VentAdmin extends javax.swing.JPanel 
 {
 private VentRaiz vRaiz;
 public VentAdmin(VentRaiz vRaiz) 
  {
  initComponents();
  this.vRaiz=vRaiz;
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonTUsuarios = new javax.swing.JRadioButton();
        jRadioButtonTSudokus = new javax.swing.JRadioButton();
        jRadioButtonTComp = new javax.swing.JRadioButton();
        jRadioButtonTEstadoComp = new javax.swing.JRadioButton();
        jRadioButtonTConfig = new javax.swing.JRadioButton();
        jRadioButtonAddSudoku = new javax.swing.JRadioButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administraci\u00f3n");
        jLabel1.setBounds(0, 10, 400, 40);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(jRadioButtonTUsuarios);
        jRadioButtonTUsuarios.setText("Tabla de usuarios");
        jRadioButtonTUsuarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonTUsuarios.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonTUsuarios.setBounds(130, 80, 170, 15);
        jDesktopPane1.add(jRadioButtonTUsuarios, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(jRadioButtonTSudokus);
        jRadioButtonTSudokus.setText("Tabla de sudokus");
        jRadioButtonTSudokus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonTSudokus.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonTSudokus.setBounds(130, 100, 170, 15);
        jDesktopPane1.add(jRadioButtonTSudokus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(jRadioButtonTComp);
        jRadioButtonTComp.setText("Tabla de competiciones");
        jRadioButtonTComp.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonTComp.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonTComp.setBounds(130, 120, 170, 15);
        jDesktopPane1.add(jRadioButtonTComp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(jRadioButtonTEstadoComp);
        jRadioButtonTEstadoComp.setText("Tabla de estado competici\u00f3n");
        jRadioButtonTEstadoComp.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonTEstadoComp.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonTEstadoComp.setBounds(130, 140, 170, 15);
        jDesktopPane1.add(jRadioButtonTEstadoComp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(jRadioButtonTConfig);
        jRadioButtonTConfig.setText("Tabla de configuraci\u00f3n");
        jRadioButtonTConfig.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonTConfig.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonTConfig.setBounds(130, 160, 170, 15);
        jDesktopPane1.add(jRadioButtonTConfig, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(jRadioButtonAddSudoku);
        jRadioButtonAddSudoku.setText("A\u00f1adir sudokus");
        jRadioButtonAddSudoku.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonAddSudoku.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonAddSudoku.setBounds(130, 180, 170, 15);
        jDesktopPane1.add(jRadioButtonAddSudoku, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonAceptar.setBounds(100, 230, 90, 30);
        jDesktopPane1.add(jButtonAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonVolver.setBounds(210, 230, 90, 30);
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

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        VentLogin vLogin=new VentLogin(vRaiz);
        vLogin.setVisible(true);
        vLogin.setSize(2000,2000);
        vRaiz.remove(this);
        vRaiz.add(vLogin);
        vRaiz.pack();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        if (jRadioButtonTUsuarios.isSelected()) {
            // Menú de gestión de tabla de usuarios
      VentGestTablaUsuarios vGestTablaUsuarios=new VentGestTablaUsuarios(vRaiz);
      vGestTablaUsuarios.setVisible(true);
      vGestTablaUsuarios.setSize(2000,2000);
      vRaiz.remove(this);
      vRaiz.add(vGestTablaUsuarios);
      vRaiz.pack();
        } else if (jRadioButtonTSudokus.isSelected()) {
            // Menú de gestión de tabla de sudokus
      VentGestTablaSudokus vGestTablaSudokus=new VentGestTablaSudokus(vRaiz);
      vGestTablaSudokus.setVisible(true);
      vGestTablaSudokus.setSize(2000,2000);
      vRaiz.remove(this);
      vRaiz.add(vGestTablaSudokus);
      vRaiz.pack();
        } else if (jRadioButtonTComp.isSelected()) {
            // Menú de gestión de tabla de competiciones
      VentGestTablaComp vGestTablaComp=new VentGestTablaComp(vRaiz);
      vGestTablaComp.setVisible(true);
      vGestTablaComp.setSize(2000,2000);
      vRaiz.remove(this);
      vRaiz.add(vGestTablaComp);
      vRaiz.pack();
        } else if (jRadioButtonTEstadoComp.isSelected()) {
            // Menú de gestión de tabla de estado de competición
      VentGestTablaEstadoComp vGestTablaEstadoComp=new VentGestTablaEstadoComp(vRaiz);
      vGestTablaEstadoComp.setVisible(true);
      vGestTablaEstadoComp.setSize(2000,2000);
      vRaiz.remove(this);
      vRaiz.add(vGestTablaEstadoComp);
      vRaiz.pack();
        } else if (jRadioButtonTConfig.isSelected()) {
            // Menú de gestión de tabla de configuración
      VentGestTablaConfig vGestTablaConfig=new VentGestTablaConfig(vRaiz);
      vGestTablaConfig.setVisible(true);
      vGestTablaConfig.setSize(2000,2000);
      vRaiz.remove(this);
      vRaiz.add(vGestTablaConfig);
      vRaiz.pack();
        } else if (jRadioButtonAddSudoku.isSelected()) {
            // Menú de añadir sudokus
            VentAddSudokus vAddSudokus=new VentAddSudokus(vRaiz);
            vAddSudokus.setVisible(true);
            vAddSudokus.setSize(2000,2000);
            vRaiz.remove(this);
            vRaiz.add(vAddSudokus);
            vRaiz.pack();
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButtonAddSudoku;
    private javax.swing.JRadioButton jRadioButtonTComp;
    private javax.swing.JRadioButton jRadioButtonTConfig;
    private javax.swing.JRadioButton jRadioButtonTEstadoComp;
    private javax.swing.JRadioButton jRadioButtonTSudokus;
    private javax.swing.JRadioButton jRadioButtonTUsuarios;
    // End of variables declaration//GEN-END:variables
    
}
