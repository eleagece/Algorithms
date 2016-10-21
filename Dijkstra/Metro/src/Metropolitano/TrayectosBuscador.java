package Metropolitano;
import java.util.ArrayList;
public class TrayectosBuscador extends javax.swing.JFrame 
 {
 public TrayectosBuscador(ArrayList listaTrayectosBuscador, Grafo grafo) 
  {
  initComponents();  // Inicialización de componentes típicos
  String informacionTrayectos="";
  for (int i=0; i<listaTrayectosBuscador.size(); i++)  // Bucle que recorre los trayectos de la lista de trayectos
   {
   ArrayList trayecto=new ArrayList();
   trayecto=(ArrayList)listaTrayectosBuscador.get(i);  // Sacamos el trayecto
   String nombreEstacionesTrayecto="";  // Un string para guardar los nombres de las estaciones que componen el trayecto
   for (int j=0; j<trayecto.size(); j++)  // Bucle que recorre las estaciones del trayecto seleccionado
    {
    int numEstacion=(Integer)trayecto.get(j);  // Sacamos el vértice correspondiente a la estacion
    String nombreEstacion=(String)grafo.dameThCodigos().get(numEstacion);  // Con ese vértice y la tabla hash obtenemos el nombre
    if (j==0)  // Si es el primer elemento empezamos con un guión
     {
     nombreEstacionesTrayecto="-"+nombreEstacion+"->";   
     }
    else if (j==trayecto.size()-1)  // Si es el último acabamos con un salto de linea
     {
     nombreEstacionesTrayecto=nombreEstacionesTrayecto+nombreEstacion+"\n";   
     }
    else  // Y si esta en el medio simplemente lo añadimos
     {
     nombreEstacionesTrayecto=nombreEstacionesTrayecto+nombreEstacion+"->";   
     }
    }
   informacionTrayectos=informacionTrayectos+nombreEstacionesTrayecto;      
   }
  jTextArea1.setText(informacionTrayectos);
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPaneVentana = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jDesktopPaneVentana.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Posibles trayectos dentro del tiempo:");
        jLabel1.setBounds(90, 40, 230, 14);
        jDesktopPaneVentana.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane1.setBounds(40, 80, 320, 180);
        jDesktopPaneVentana.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPaneVentana, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPaneVentana, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPaneVentana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
}
