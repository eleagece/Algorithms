package Metropolitano;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.Hashtable;
public class Buscador extends javax.swing.JFrame 
 {
 private Grafo grafo;
 public Buscador(Grafo grafo) 
  {
  //***** Constructor *********************************************************//
  //*** Crea un ventana para el buscador con la información predeterminada  ***//
  //*** y según el grafo pasado por parámetro                               ***//
  //***************************************************************************//
  initComponents();  // Inicializa los componentes predeterminados
  this.grafo=grafo;  // Inicializa su propio grafo con el pasado por parámetro
  String listaNombresEstacionesOrigen[]=new String[grafo.dameTamano()];  // Array de nombres de estaciones de origen
  String listaNombresEstacionesDestino[]=new String[grafo.dameTamano()+1];  // Array de nombres de estaciones con una en blanco
  listaNombresEstacionesDestino[0]="";  // La estación no seleccionada será la primera
  for(int i=0; i<grafo.dameTamano(); i++)
   {
   listaNombresEstacionesOrigen[i]=(String)grafo.dameThCodigos().get(i);  // Llenamos los arrays con los nombres de las estaciones
   listaNombresEstacionesDestino[i+1]=(String)grafo.dameThCodigos().get(i);
   }
  jComboBoxOrigen.setModel(new DefaultComboBoxModel(listaNombresEstacionesOrigen));  // Llenamos los jComboBox con las estaciones
  jComboBoxDestino.setModel(new DefaultComboBoxModel(listaNombresEstacionesDestino));
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jComboBox1 = new javax.swing.JComboBox();
        jDesktopPaneVentana = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxOrigen = new javax.swing.JComboBox();
        jComboBoxDestino = new javax.swing.JComboBox();
        jTextFieldTiempo = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDesktopPaneVentana.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Origen");
        jLabel2.setBounds(90, 94, 60, 20);
        jDesktopPaneVentana.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Destino");
        jLabel3.setBounds(90, 124, 60, 14);
        jDesktopPaneVentana.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Tiempo");
        jLabel4.setBounds(90, 150, 60, 20);
        jDesktopPaneVentana.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("BUSCADOR");
        jLabel1.setBounds(170, 40, 70, 14);
        jDesktopPaneVentana.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxOrigen.setBounds(170, 90, 120, 22);
        jDesktopPaneVentana.add(jComboBoxOrigen, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxDestino.setBounds(170, 120, 120, 22);
        jDesktopPaneVentana.add(jComboBoxDestino, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldTiempo.setBounds(170, 150, 120, 20);
        jDesktopPaneVentana.add(jTextFieldTiempo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBuscarMouseClicked(evt);
            }
        });

        jButtonBuscar.setBounds(160, 200, 110, 23);
        jDesktopPaneVentana.add(jButtonBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jDesktopPaneVentana, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPaneVentana, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButtonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarMouseClicked
     //***** Botón Buscar ********************************************************//
     //*** Gestiona la acción del botón buscar. Si los datos que introduce el  ***//
     //*** usuario son erroneos se lo indica y si no llama a una nueva venta-  ***//
     //*** tana que mostrará el resultado de la búsqueda                       ***//
     //***************************************************************************//
     ///// OBTENCIÓN DE PARÁMETROS PARA EL ALGORITMO
     String nbEstacionOrigen=(String)jComboBoxOrigen.getSelectedItem();  // Sacamos los nombres de la estación origen y destino
     String nbEstacionDestino=(String)jComboBoxDestino.getSelectedItem();
     int nEstacionOrigen=(Integer)grafo.dameThEstaciones().get(nbEstacionOrigen);  // Sacamos los números de la estación origen y destino 
     int nEstacionDestino;
     if (nbEstacionDestino=="")
      {
      nEstacionDestino=9999;  // Para decirle al algoritmo que no hay estación destino   
      }
     else
      {
      nEstacionDestino=(Integer)grafo.dameThEstaciones().get(nbEstacionDestino);
      }
     String tiempoMaxString=jTextFieldTiempo.getText();
     int tiempoMax=new Integer(Integer.parseInt(tiempoMaxString));  // Sacamos el tiempo máximo posible
     ///// GESTIÓN DE ERRORES
     if (nEstacionOrigen==nEstacionDestino)  // FALTA GESTIONAR EL ESCRIBIR NEGATIVO O ALGO QUE NO SEA NUMERO
      {
      String error="Ha elegido la misma estación como origen y destino";
      // SHOWMESSAGE
      }
     else
      {
      ///// APLICACIÓN DEL ALGORITMO
      ArrayList listaTrayectosBuscador=new ArrayList();
      listaTrayectosBuscador=grafo.buscadorInteligente(nEstacionOrigen,nEstacionDestino,tiempoMax);  // Aplicamos el algoritmo
      if (listaTrayectosBuscador.get(0) instanceof Integer && (Integer)listaTrayectosBuscador.get(0)==-1)
       {  // En caso de que no encontremos una lista, sino un -1 sabremos que no hay trayectos bajo las premisas introducidas
       String mensaje="No hay trayectos bajo los términos especificados";
       // SHOWMESSAGE
       }
      else  // En caso de que sí encontremos una lista con trayectos creamos una nueva ventana que los representará al usuario
       {
       TrayectosBuscador ventanaTrayectosBuscador=new TrayectosBuscador(listaTrayectosBuscador,grafo);
       ventanaTrayectosBuscador.setVisible(true);
       this.dispose();   
       }
      }
    }//GEN-LAST:event_jButtonBuscarMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxDestino;
    private javax.swing.JComboBox jComboBoxOrigen;
    private javax.swing.JDesktopPane jDesktopPaneVentana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldTiempo;
    // End of variables declaration//GEN-END:variables
    
}
