package Metropolitano;
import java.util.ArrayList;
import java.util.Hashtable;
public class Trayectos extends javax.swing.JFrame 
 {
 public Trayectos(ArrayList trayecto, Grafo grafo) 
  {
  initComponents();
  String nombreEstacionesTrayecto="";
  for (int i=0; i<trayecto.size(); i++)
   {
   int nEstacion=(Integer)trayecto.get(i);  // Sacamos el número de la estación
   String nombreEstacion=(String)grafo.dameThCodigos().get(nEstacion);  // Sacamos el nombre correspondiente a la estación
   if (nombreEstacionesTrayecto=="")  // Y la añadimos al recorrido mínimo
    {
    nombreEstacionesTrayecto="-"+nombreEstacion;
    }
   else
    {
    nombreEstacionesTrayecto=nombreEstacionesTrayecto+", "+nombreEstacion;   
    }
   }
  jTextField1.setText(nombreEstacionesTrayecto);
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDesktopPane1.setBackground(new java.awt.Color(51, 102, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 10));
        jTextField1.setBounds(60, 60, 270, 30);
        jDesktopPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Trayectos Resultantes");
        jLabel1.setBounds(130, 30, 150, 14);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new Trayectos().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}

