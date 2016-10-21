//   ERRORES
// 1- Al añadir la ventana del sudoku de entrenamiento da excepción
//   COMPLETAR
// Se debe completar lo que está en comentarios del tipo /* TEXTO EN MAYÚSCULAS */
package Menu;
import javax.swing.*;
import Gestion.BBDD;
import java.util.ArrayList;
public class VentMenu extends javax.swing.JPanel {
    private VentRaiz vRaiz;
    public VentMenu(VentRaiz vRaiz) {
        initComponents();
        this.vRaiz=vRaiz;
    }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroupMenu = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jRadioButtonDatosPersonales = new javax.swing.JRadioButton();
        jRadioButtonJugarConTiempo = new javax.swing.JRadioButton();
        jRadioButtonEntrenar = new javax.swing.JRadioButton();
        jRadioButtonCrearCompeticion = new javax.swing.JRadioButton();
        jRadioButtonJugarCompeticion = new javax.swing.JRadioButton();
        jRadioButtonVerCompeticiones = new javax.swing.JRadioButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        buttonGroupMenu.add(jRadioButtonDatosPersonales);
        jRadioButtonDatosPersonales.setText("Modificar datos personales");
        jRadioButtonDatosPersonales.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonDatosPersonales.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonDatosPersonales.setBounds(160, 80, 250, 15);
        jDesktopPane1.add(jRadioButtonDatosPersonales, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroupMenu.add(jRadioButtonJugarConTiempo);
        jRadioButtonJugarConTiempo.setText("Jugar contrareloj");
        jRadioButtonJugarConTiempo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonJugarConTiempo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonJugarConTiempo.setBounds(160, 110, 250, 15);
        jDesktopPane1.add(jRadioButtonJugarConTiempo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroupMenu.add(jRadioButtonEntrenar);
        jRadioButtonEntrenar.setText("Entrenar");
        jRadioButtonEntrenar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonEntrenar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonEntrenar.setBounds(160, 130, 250, 15);
        jDesktopPane1.add(jRadioButtonEntrenar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroupMenu.add(jRadioButtonCrearCompeticion);
        jRadioButtonCrearCompeticion.setText("Crear competici\u00f3n");
        jRadioButtonCrearCompeticion.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonCrearCompeticion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonCrearCompeticion.setBounds(160, 160, 250, 15);
        jDesktopPane1.add(jRadioButtonCrearCompeticion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroupMenu.add(jRadioButtonJugarCompeticion);
        jRadioButtonJugarCompeticion.setText("Jugar competici\u00f3n");
        jRadioButtonJugarCompeticion.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonJugarCompeticion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonJugarCompeticion.setBounds(160, 180, 250, 15);
        jDesktopPane1.add(jRadioButtonJugarCompeticion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroupMenu.add(jRadioButtonVerCompeticiones);
        jRadioButtonVerCompeticiones.setText("Ver competiciones");
        jRadioButtonVerCompeticiones.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonVerCompeticiones.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonVerCompeticiones.setBounds(160, 200, 250, 15);
        jDesktopPane1.add(jRadioButtonVerCompeticiones, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonAceptar.setBounds(90, 240, 90, 30);
        jDesktopPane1.add(jButtonAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonSalir.setBounds(210, 240, 90, 30);
        jDesktopPane1.add(jButtonSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Competici\u00f3n:");
        jLabel1.setBounds(80, 180, 230, 14);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("Juego:");
        jLabel2.setBounds(110, 120, 230, 14);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Datos:");
        jLabel3.setBounds(110, 80, 60, 14);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14));
        jLabel4.setText("Men\u00fa de usuario");
        jLabel4.setBounds(130, 40, 160, 21);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    //******************************************//
    //*** Objetos gráficos *********************//
    //******************************************//
    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        /* HACER QUE EL USUARIO ACTUAL YA NO LO SEA Y NO HAYA NINGUNO EN ACTIVO */
        VentLogin vPpal=new VentLogin(vRaiz);
        vPpal.setVisible(true);
        vPpal.setSize(2000,2000);
        vRaiz.remove(this);
        vRaiz.add(vPpal);
        vRaiz.pack();
    }//GEN-LAST:event_jButtonSalirActionPerformed
        private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
            if (jRadioButtonDatosPersonales.isSelected()) {
                // Menú de actualización de datos personales
                VentDatosPers vDatosPers=new VentDatosPers(vRaiz);
                vDatosPers.setVisible(true);
                vDatosPers.setSize(2000,2000);
                vRaiz.remove(this);
                vRaiz.add(vDatosPers);
                vRaiz.pack();
            } else if (jRadioButtonJugarConTiempo.isSelected()) {
                // Juego de sudoku con tiempo
                VentSudokuTiempo vSudokuTiempo=new VentSudokuTiempo(vRaiz);
                vSudokuTiempo.setVisible(true);
                vSudokuTiempo.setSize(2000,2000);
                vRaiz.remove(this);
                vRaiz.add(vSudokuTiempo);
                vRaiz.pack();
            } else if (jRadioButtonEntrenar.isSelected()) {
                // Juego de sudoku sin tiempo (entrenamiento)
                VentSudokuEntreno vSudokuEntreno=new VentSudokuEntreno(vRaiz);
                vSudokuEntreno.setVisible(true);
                vSudokuEntreno.setSize(2000,2000);
                vRaiz.remove(this);
                vRaiz.add(vSudokuEntreno);
                vRaiz.pack();
            } else if (jRadioButtonCrearCompeticion.isSelected()) {
                // Ventana para crear competición
                VentCrearComp vCrearComp=new VentCrearComp(vRaiz);
                vCrearComp.setVisible(true);
                vCrearComp.setSize(2000,2000);
                vRaiz.remove(this);
                vRaiz.add(vCrearComp);
                vRaiz.pack();
            } else if (jRadioButtonJugarCompeticion.isSelected()) {
                // Ventana para jugar competición
                
                BBDD bd = new BBDD();
                bd.abrirConexion();
                ArrayList listacompeticiones = new ArrayList();
                listacompeticiones = bd.obtenerCompeticiones(vRaiz.DNI);
                bd.cerrarConexion();
                if(listacompeticiones.size() > 0){
                    
                    VentJugarComp vJugarComp=new VentJugarComp(vRaiz);
                    vJugarComp.setVisible(true);
                    vJugarComp.setSize(2000,2000);
                    vRaiz.remove(this);
                    vRaiz.add(vJugarComp);
                    vRaiz.pack();
                }
            } else if (jRadioButtonVerCompeticiones.isSelected()) {
                // Ventana para ver competiciones en curso
      VentVerComp vVerComp=new VentVerComp(vRaiz);
      vVerComp.setVisible(true);
      vVerComp.setSize(2000,2000);
      vRaiz.remove(this);
      vRaiz.add(vVerComp);
      vRaiz.pack();
            }
    }//GEN-LAST:event_jButtonAceptarActionPerformed
            // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupMenu;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButtonCrearCompeticion;
    private javax.swing.JRadioButton jRadioButtonDatosPersonales;
    private javax.swing.JRadioButton jRadioButtonEntrenar;
    private javax.swing.JRadioButton jRadioButtonJugarCompeticion;
    private javax.swing.JRadioButton jRadioButtonJugarConTiempo;
    private javax.swing.JRadioButton jRadioButtonVerCompeticiones;
    // End of variables declaration//GEN-END:variables
    
}
