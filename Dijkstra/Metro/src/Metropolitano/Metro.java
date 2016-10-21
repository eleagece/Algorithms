package Metropolitano;

import javax.swing.JFileChooser;
import java.util.Hashtable;
public class Metro extends javax.swing.JFrame {
    Grafo grafo;
    public boolean admin;
    public boolean empleado;
    /** Creates new form Metro */
    public Metro() {
        initComponents();
        admin = false;
        empleado = false;
        
        JFileChooser selector=new JFileChooser();
        selector.showOpenDialog(jMenuItem6);
        if(selector.getSelectedFile() != null){
            String fichero=selector.getSelectedFile().getPath();
            Utils xml = new Utils();
            Hashtable thEstaciones = new Hashtable();
            Hashtable thCodigos = new Hashtable();
            int matriz[][] = xml.leer(fichero,thEstaciones,thCodigos);
            grafo = new Grafo(matriz,thEstaciones,thCodigos);
        }
        activa();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JSeparator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JSeparator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jDesktopPane1.setBackground(new java.awt.Color(0, 102, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Metropolitano/logoMetro.gif")));
        jLabel2.setBounds(130, 120, 120, 69);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("Usuarios");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem9.setText("Ver plano");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem9);

        jMenu1.add(jSeparator5);

        jMenuItem10.setText("Trayecto m\u00ednimo");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem10);

        jMenu1.add(jSeparator6);

        jMenuItem11.setText("Trayectos posibles");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem11);

        jMenu1.add(jSeparator7);

        jMenuItem12.setText("Buscador");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem12);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Empleados");
        jMenuItem7.setText("Gesti\u00f3n estaciones");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });

        jMenu2.add(jMenuItem7);

        jMenu2.add(jSeparator4);

        jMenuItem8.setText("Recubrimiento m\u00ednimo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });

        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Administrador");
        jMenuItem5.setText("Gesti\u00f3n empleados");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem5);

        jMenu4.add(jSeparator3);

        jMenuItem6.setText("Cargar red");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Login");
        jMenuItem3.setText("Autenticarse");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });

        jMenu5.add(jMenuItem3);

        jMenu5.add(jSeparator2);

        jMenuItem4.setText("Registrarse");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });

        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("Ayuda");
        jMenuItem1.setText("Ayuda");
        jMenu3.add(jMenuItem1);

        jMenu3.add(jSeparator1);

        jMenuItem2.setText("Acerca");
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        Buscador b = new Buscador(grafo);
        b.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed
    
    public void activa(){
        jMenu4.setEnabled(this.admin);
        jMenu2.setEnabled(this.empleado || admin);
    }        
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Login lg = new Login(this);
        lg.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Registro reg = new Registro();
        reg.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(admin){
            gesusuarios gu = new gesusuarios();
            gu.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        TraPos tr = new TraPos(grafo);
        tr.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed
    
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if(admin || empleado){
            boolean minimo[][] = new boolean[grafo.grafo.length][grafo.grafo.length];
            grafo.kruskal(minimo);
            int dibukruskal[][] = new int[grafo.grafo.length][grafo.grafo.length];
            for(int i=0; i<grafo.grafo.length;i++){
                for(int j=i+1;j<grafo.grafo.length;j++){
                    if(minimo[i][j]) dibukruskal[i][j] = grafo.grafo[i][j];
                }
            }
            Dibuja dibu = new Dibuja(dibukruskal,grafo.thCodigos);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed
    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(admin || empleado){
            gesparadas GesPar = new gesparadas(grafo);
            GesPar.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Dibuja dibu = new Dibuja(grafo.grafo,grafo.thCodigos);
    }//GEN-LAST:event_jMenuItem9ActionPerformed
    
    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed
    
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(admin){
            JFileChooser selector=new JFileChooser();
            selector.showOpenDialog(jMenuItem6);
            if(selector.getSelectedFile() != null){
                String fichero=selector.getSelectedFile().getPath();
                Utils xml = new Utils();
                Hashtable thEstaciones = new Hashtable();
                Hashtable thCodigos = new Hashtable();
                int matriz[][] = xml.leer(fichero,thEstaciones,thCodigos);
                grafo = new Grafo(matriz,thEstaciones,thCodigos);
            }
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        TraMin trayectosMinimos=new TraMin(grafo);
        trayectosMinimos.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Metro().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
    
}
