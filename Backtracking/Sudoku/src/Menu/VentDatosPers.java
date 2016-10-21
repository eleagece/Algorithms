//   ERRORES
// Ninguno
//   COMPLETAR
// Se debe completar lo que está en comentarios del tipo /* TEXTO EN MAYÚSCULAS */
package Menu;
import Gestion.BBDD;
import javax.swing.*;
import java.util.ArrayList;

public class VentDatosPers extends javax.swing.JPanel {
    public VentRaiz vRaiz;
    public VentDatosPers(VentRaiz vRaiz) {
        initComponents();
        this.vRaiz=vRaiz;
        rellena();
    }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jTextFieldPuntos = new javax.swing.JTextField();
        jTextFieldNb = new javax.swing.JTextField();
        jTextFieldAp1 = new javax.swing.JTextField();
        jTextFieldAp2 = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldPass = new javax.swing.JTextField();
        jTextFieldPassConf = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14));
        jLabel1.setText("Datos de usuario");
        jLabel1.setBounds(130, 10, 160, 20);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("Usuario");
        jLabel2.setBounds(70, 40, 110, 20);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Puntos");
        jLabel3.setBounds(70, 60, 110, 20);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Password");
        jLabel4.setBounds(70, 200, 110, 20);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Confirmar Password");
        jLabel5.setBounds(70, 220, 110, 20);
        jDesktopPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setText("Nombre");
        jLabel6.setBounds(70, 90, 110, 20);
        jDesktopPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setText("Apellido 1");
        jLabel7.setBounds(70, 110, 110, 20);
        jDesktopPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setText("Apellido 2");
        jLabel8.setBounds(70, 130, 110, 20);
        jDesktopPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setText("Email");
        jLabel9.setBounds(70, 150, 110, 20);
        jDesktopPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setText("DNI");
        jLabel10.setBounds(70, 170, 110, 20);
        jDesktopPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldUser.setEditable(false);
        jTextFieldUser.setBounds(180, 40, 140, 20);
        jDesktopPane1.add(jTextFieldUser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldPuntos.setEditable(false);
        jTextFieldPuntos.setBounds(180, 60, 140, 20);
        jDesktopPane1.add(jTextFieldPuntos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldNb.setBounds(180, 90, 140, 20);
        jDesktopPane1.add(jTextFieldNb, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldAp1.setBounds(180, 110, 140, 20);
        jDesktopPane1.add(jTextFieldAp1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldAp2.setBounds(180, 130, 140, 20);
        jDesktopPane1.add(jTextFieldAp2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldEmail.setBounds(180, 150, 140, 20);
        jDesktopPane1.add(jTextFieldEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldDNI.setEditable(false);
        jTextFieldDNI.setBounds(180, 170, 140, 20);
        jDesktopPane1.add(jTextFieldDNI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldPass.setBounds(180, 200, 140, 20);
        jDesktopPane1.add(jTextFieldPass, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldPassConf.setBounds(180, 220, 140, 20);
        jDesktopPane1.add(jTextFieldPassConf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonActualizar.setBounds(80, 260, 100, 30);
        jDesktopPane1.add(jButtonActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBounds(220, 260, 100, 30);
        jDesktopPane1.add(jButtonCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
    //*** Métodos auxiliares *******************//
    //******************************************//
    
    private void rellena(){
        BBDD bd = new BBDD();
        bd.abrirConexion();
        
        ArrayList usuario = new ArrayList();
        usuario = bd.obtenerTusuario(vRaiz.DNI);
        bd.cerrarConexion();
        
        jTextFieldUser.setText((String)usuario.get(0));
        jTextFieldPuntos.setText((String)usuario.get(1));
        jTextFieldNb.setText((String)usuario.get(2));
        jTextFieldAp1.setText((String)usuario.get(3));
        jTextFieldAp2.setText((String)usuario.get(4));
        jTextFieldEmail.setText((String)usuario.get(5));
        jTextFieldDNI.setText((String)usuario.get(6));
        jTextFieldPass.setText((String)usuario.get(7));
        jTextFieldPassConf.setText((String)usuario.get(7));
        
    }
    private void borrarFormulario() {
        //***** borrarFormulario() **************************************************//
        //*** borra los jTextField del formulario                                 ***//
        //***************************************************************************//
        jTextFieldNb.setText("");
        jTextFieldAp1.setText("");
        jTextFieldAp2.setText("");
        jTextFieldEmail.setText("");
        jTextFieldPass.setText("");
        jTextFieldPassConf.setText("");
    }
    private boolean emailIncorrecto() {
        //***** emailIncorrecto() ***************************************************//
        //*** Comprueba si el email metido en el jTextFieldEmail es incorrecto.   ***//
        //*** Si es incorrecto devuelve true. En caso contrario devuelve false.   ***//
        //***************************************************************************//
        String email=jTextFieldEmail.getText();
        if (email=="")
            return true;
        else {
            int numArrobas=0;
            int numPuntos=0;
            int posArroba=0;
            int posPunto=0;
            String arroba="@";
            String punto=".";
            for (int i=0; i<email.length(); i++) {
                String letra=email.substring(i,i+1);
                if (letra.equals(arroba)) {
                    numArrobas++;
                    posArroba=i;
                } else if (letra.equals(punto)) {
                    numPuntos++;
                    posPunto=i;
                }
            }
            int longitud=email.length();
            if (numArrobas==1 && numPuntos==1 && posArroba!=-1 && posPunto!=-1 && posArroba>0 && posPunto<longitud-1 && posArroba+1<posPunto)
                return false;  // Devuelve false, indicando que el email no es incorrecto
            else
                return true;  // Devuelve true, indicando que el email es incorrecto
        }
    }
    
    private boolean campoErroneo() {
        //***** campoErroneo() ******************************************************//
        //*** Devuelve true si los datos introducidos en el formulario corres-    ***//
        //*** ponden a algún usuario registrado o el email está mal puesto. De-   ***//
        //*** vuelve false en otro caso.                                          ***//
        //***************************************************************************//
        String Nombre = jTextFieldNb.getText();
        String Apellido1 = jTextFieldAp1.getText();
        String Apellido2 = jTextFieldAp2.getText();
        String Email = jTextFieldEmail.getText();
        String DNI = jTextFieldDNI.getText();
        String Usuario = jTextFieldUser.getText();
        String Password = jTextFieldPass.getText();
        String RPassword = jTextFieldPassConf.getText();
        
        if (Nombre.equals("") || Apellido1.equals("") || Apellido2.equals("") || Email.equals("") || DNI.equals("") || Usuario.equals("") || Password.equals("") || RPassword.equals(""))
            return true;  // Devuelve true si el email es incorrecto o el usuario introducido estaba en la base de datos
        else if(emailIncorrecto() || !Password.equals(RPassword))
            return true;  // Devuelve false si el email es correcto y el usuario introducido no estaba en la base de datos
        else return false;
        
    }
    
    //******************************************//
    //*** Objetos gráficos *********************//
    //******************************************//
    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        if (!campoErroneo()){//(!emailIncorrecto() && !Password.equals(RPassword))
            /* ACTUALIZAR LOS DATOS DEL USUARIO EN LA BASE DE DATOS */
            BBDD bd = new BBDD();
            bd.abrirConexion();
            
            bd.modificarTusuarios("Nombre",jTextFieldNb.getText(),vRaiz.DNI);
            bd.modificarTusuarios("Apellido1",jTextFieldAp1.getText(),vRaiz.DNI);
            bd.modificarTusuarios("Apellido2",jTextFieldAp2.getText(),vRaiz.DNI);
            bd.modificarTusuarios("Email",jTextFieldEmail.getText(),vRaiz.DNI);
            bd.modificarTusuarios("Password",jTextFieldPassConf.getText(),vRaiz.DNI);
            
            
            VentMenu vMenu=new VentMenu(vRaiz);
            vMenu.setVisible(true);
            vMenu.setSize(2000,2000);
            vRaiz.remove(this);
            vRaiz.add(vMenu);
            vRaiz.pack();
        } else {
            borrarFormulario();
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed
        private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
            VentMenu vMenu=new VentMenu(vRaiz);
            vMenu.setVisible(true);
            vMenu.setSize(2000,2000);
            vRaiz.remove(this);
            vRaiz.add(vMenu);
            vRaiz.pack();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
            // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldAp1;
    private javax.swing.JTextField jTextFieldAp2;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNb;
    private javax.swing.JTextField jTextFieldPass;
    private javax.swing.JTextField jTextFieldPassConf;
    private javax.swing.JTextField jTextFieldPuntos;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
