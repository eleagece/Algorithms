/*
 * gesusuarios.java
 *
 * Created on 27 de abril de 2007, 1:26
 */

package Metropolitano;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Antonio
 */
public class gesusuarios extends javax.swing.JFrame {
    
    /** Creates new form gesusuarios */
    public gesusuarios() {
        initComponents();
        this.pintar();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDesktopPane1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLEADOS METRO");
        jLabel1.setBounds(270, 50, 140, 14);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Elimina", "Nombre", "Apellido 1", "Apellido 2", "Email", "DNI", "Usuario", "Password", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane1.setBounds(20, 90, 590, 90);
        jDesktopPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton1.setBounds(180, 210, 90, 23);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jDesktopPane2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EMPLEADOS METRO");
        jLabel2.setBounds(270, 50, 140, -1);
        jDesktopPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Elimina", "Nombre", "Apellido 1", "Apellido 2", "Email", "DNI", "Usuario", "Password", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jScrollPane2.setBounds(20, 90, 590, 90);
        jDesktopPane2.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Aceptar");
        jButton2.setBounds(240, 210, 90, -1);
        jDesktopPane2.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jDesktopPane2.setBounds(0, 0, 0, 0);
        jDesktopPane1.add(jDesktopPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("A\u00f1adir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton3.setBounds(350, 210, 100, 23);
        jDesktopPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void pintar(){
        BasesDatos bd = new BasesDatos();
        bd.abrirConexion();
        bd.obtenerDatos();
        try {
            DefaultTableModel model = new DefaultTableModel();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            int i=0;
            
            while (bd.rs.next()) {
                model.addRow(new Object[]{});
                jTable1.setValueAt(false,i,0);
                jTable1.setValueAt(bd.rs.getString("Nombre"),i,1);
                jTable1.setValueAt(bd.rs.getString("Apellido1"),i,2);
                jTable1.setValueAt(bd.rs.getString("Apellido2"),i,3);
                jTable1.setValueAt(bd.rs.getString("Email"),i,4);
                jTable1.setValueAt(bd.rs.getInt("DNI"),i,5);
                jTable1.setValueAt(bd.rs.getString("Usuario"),i,6);
                jTable1.setValueAt(bd.rs.getString("Password"),i,7);
                jTable1.setValueAt(bd.rs.getBoolean("Activo"),i,8);
                i++;
            }
            bd.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error al visualizar datos");
        }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Registro reg = new Registro(this);
        reg.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for(int i=0; i<jTable1.getRowCount();i++){
            Boolean eliminar = (Boolean)jTable1.getValueAt(i,0);
            Boolean activar = (Boolean)jTable1.getValueAt(i,8);
            if(eliminar){
                BasesDatos bd = new BasesDatos();
                bd.abrirConexion();
                bd.borrar((Integer)jTable1.getValueAt(i,5));
                bd.cerrarConexion();
            } else{
                BasesDatos bd = new BasesDatos();
                bd.abrirConexion();
                int dni = (Integer)jTable1.getValueAt(i,5);
                bd.modificar("Nombre",(String)jTable1.getValueAt(i,1),dni);
                bd.modificar("Apellido1",(String)jTable1.getValueAt(i,2),dni);    
                bd.modificar("Apellido2",(String)jTable1.getValueAt(i,3),dni);
                bd.modificar("Email",(String)jTable1.getValueAt(i,4),dni);
                //bd.modificar("DNI",(Integer)jTable1.getValueAt(i,5),dni);
                bd.modificar("Usuario",(String)jTable1.getValueAt(i,6),dni);
                bd.modificar("Password",(String)jTable1.getValueAt(i,7),dni);
                bd.activar(dni, activar);
                bd.cerrarConexion();
            }
            
        }
        this.pintar();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gesusuarios().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
    
}
