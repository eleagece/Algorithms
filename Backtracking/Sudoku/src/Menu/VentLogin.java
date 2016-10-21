//   ERRORES
// 1- Al crear la ventana de admin lo hace mal
//   COMPLETAR
// Se debe completar lo que está en comentarios del tipo /* TEXTO EN MAYÚSCULAS */
package Menu;
import javax.swing.*;
import Gestion.BBDD;
public class VentLogin extends javax.swing.JPanel {
    private VentRaiz vRaiz;
    public VentLogin(VentRaiz vRaiz) {
        initComponents();
        this.vRaiz=vRaiz;
        vRaiz.DNI = -1;
    }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTextFieldUser = new javax.swing.JTextField();
        jTextFieldPass = new javax.swing.JTextField();
        jButtonEntrar = new javax.swing.JButton();
        jButtonRegistro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        jTextFieldUser.setBounds(130, 100, 130, 20);
        jDesktopPane1.add(jTextFieldUser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldPass.setBounds(130, 130, 130, 20);
        jDesktopPane1.add(jTextFieldPass, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonEntrar.setText("ENTRAR");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jButtonEntrar.setBounds(285, 100, 80, 50);
        jDesktopPane1.add(jButtonEntrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRegistro.setText("Registrarse");
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });

        jButtonRegistro.setBounds(140, 230, 110, 30);
        jDesktopPane1.add(jButtonRegistro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18));
        jLabel1.setText("Sudoku UCM");
        jLabel1.setBounds(130, 40, 130, 30);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("Usuario");
        jLabel2.setBounds(50, 100, 80, 20);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Password");
        jLabel3.setBounds(50, 130, 80, 20);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("\u00bfNo est\u00e1s registrado? \u00a1Pues hazlo!");
        jLabel4.setBounds(100, 200, 220, 20);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    //******************************************//
    //*** Objetos gráficos *********************//
    //******************************************//
    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        String user=jTextFieldUser.getText();
        String pass=jTextFieldPass.getText();
        
        BBDD bd = new BBDD();
        bd.abrirConexion();
        if (user.equals("admin") && pass.equals("admin"))  // Si es el administrador
        {
            VentAdmin vAdmin=new VentAdmin(vRaiz);
            vAdmin.setVisible(true);
            vAdmin.setSize(2000,2000);
            vRaiz.remove(this);
            vRaiz.add(vAdmin);
            vRaiz.pack();
        }
        
        else if(bd.seleccionaUsuarios(user,pass)) {
            vRaiz.DNI = bd.obtenerDNI(user);
            VentMenu vMenu=new VentMenu(vRaiz);
            vMenu.setVisible(true);
            vMenu.setSize(2000,2000);
            vRaiz.remove(this);
            vRaiz.add(vMenu);
            vRaiz.pack();
        } else {
            jTextFieldUser.setText("");
            jTextFieldPass.setText("");
        }
        bd.cerrarConexion();
    }//GEN-LAST:event_jButtonEntrarActionPerformed
        private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed
            VentReg vReg=new VentReg(vRaiz);  // Creamos vReg
            vReg.setVisible(true);  // Hacemos visible vReg
            vReg.setSize(2000,2000);  // Ponemos un tamaño que supere al de vRaiz
            vRaiz.remove(this);  // Quitamos vPpal de vRaiz
            vRaiz.add(vReg);  // Añadimos vReg a vRaiz
            vRaiz.pack();  // Empaquetamos vRaiz
    }//GEN-LAST:event_jButtonRegistroActionPerformed
            // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldPass;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
