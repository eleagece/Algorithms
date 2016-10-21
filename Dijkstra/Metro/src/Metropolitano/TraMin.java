package Metropolitano;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.util.ArrayList;
public class TraMin extends javax.swing.JFrame 
 {
 private Grafo grafo;
 public TraMin(Grafo grafo) 
  {
  //***** Constructor *********************************************************//
  //*** Crea un ventana para el buscador con la información predeterminada  ***//
  //*** y según el grafo pasado por parámetro                               ***//
  //***************************************************************************//
  initComponents();  // Inicialización de componentes
  this.grafo=grafo;  // Inicialización de este grafo
  String listaNombreEstacionesOrigenYDestino[]=new String[grafo.dameTamano()];  // Array de nombres de estaciones origen y destino
  String listaNombreEstacionesIntermedias[]=new String[grafo.dameTamano()+1];  // Array de estaciones intermedias
  listaNombreEstacionesIntermedias[0]="";  // Primer elemento vacío
  for(int i=0; i<grafo.dameTamano(); i++)
   {
   listaNombreEstacionesOrigenYDestino[i]=(String)grafo.dameThCodigos().get(i);  // LLenamos el array de estaciones origen y destino
   listaNombreEstacionesIntermedias[i+1]=(String)grafo.dameThCodigos().get(i);  // Llenamos el array de estaciones intermedias
   }
  jComboBoxOrigen.setModel(new DefaultComboBoxModel(listaNombreEstacionesOrigenYDestino));  // combobox origen 
  jComboBoxDestino.setModel(new DefaultComboBoxModel(listaNombreEstacionesOrigenYDestino));  // combobox destino
  jComboBoxIntermedias1.setModel(new DefaultComboBoxModel(listaNombreEstacionesIntermedias));  // comobbox intermedias 1
  jComboBoxIntermedias2.setModel(new DefaultComboBoxModel(listaNombreEstacionesIntermedias));  // comobbox intermedias 1   
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxOrigen = new javax.swing.JComboBox();
        jComboBoxDestino = new javax.swing.JComboBox();
        jComboBoxIntermedias1 = new javax.swing.JComboBox();
        jComboBoxIntermedias2 = new javax.swing.JComboBox();
        jButtonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDesktopPane1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trayecto M\u00ednimo");
        jLabel1.setBounds(150, 40, 110, 14);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("Origen");
        jLabel2.setBounds(90, 80, 50, 20);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Destino");
        jLabel3.setBounds(90, 110, 50, 20);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Parada Intermedia");
        jLabel4.setBounds(90, 140, 110, 20);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Parada Intermedia");
        jLabel5.setBounds(90, 170, 110, 20);
        jDesktopPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxOrigen.setBounds(220, 80, 110, 20);
        jDesktopPane1.add(jComboBoxOrigen, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxDestino.setBounds(220, 110, 110, 20);
        jDesktopPane1.add(jComboBoxDestino, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxIntermedias1.setBounds(220, 140, 110, 22);
        jDesktopPane1.add(jComboBoxIntermedias1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxIntermedias2.setBounds(220, 170, 110, 22);
        jDesktopPane1.add(jComboBoxIntermedias2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceptarMouseClicked(evt);
            }
        });

        jButtonAceptar.setBounds(160, 220, 110, 23);
        jDesktopPane1.add(jButtonAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButtonAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceptarMouseClicked
     //***** Botón Aceptar *******************************************************//
     //*** Gestiona la acción del botón aceptar. Si los datos que introduce el ***//
     //*** usuario son erroneos se lo indica y si no llama a una nueva venta-  ***//
     //*** tana que mostrará el resultado de la búsqueda                       ***//
     //***************************************************************************//
     ///// OBTENCIÓN DE PARÁMETROS PARA EL ALGORITMO
     String nbEstacionOrigen=(String)jComboBoxOrigen.getSelectedItem();
     String nbEstacionDestino=(String)jComboBoxDestino.getSelectedItem();
     String nbEstacionIntermedia1=(String)jComboBoxIntermedias1.getSelectedItem();
     String nbEstacionIntermedia2=(String)jComboBoxIntermedias2.getSelectedItem();
     int nEstacionOrigen=(Integer)grafo.dameThEstaciones().get(nbEstacionOrigen);  // Sacamos los números de la estación origen
     int nEstacionDestino=(Integer)grafo.dameThEstaciones().get(nbEstacionDestino);  // Sacamos los números de la estación destino
     int nEstacionIntermedia1;
     int nEstacionIntermedia2;
     ///// GESTIÓN DE ERRORES
     if (nbEstacionOrigen==nbEstacionDestino ||
         nbEstacionOrigen==nbEstacionIntermedia1 ||
         nbEstacionOrigen==nbEstacionIntermedia2 ||
         nbEstacionDestino==nbEstacionIntermedia1 ||
         nbEstacionDestino==nbEstacionIntermedia2 ||
         (nbEstacionIntermedia1==nbEstacionIntermedia2 && nbEstacionIntermedia1!=""))
      {
      String error="Ha elegido un trayecto imposible";
      // SHOWMESSAGE
      }
     else
      {
      ///// APLICACIÓN DEL ALGORITMO
      ArrayList trayectoMinimo=new ArrayList();  // ArrayList que guarda el trayecto en caso de que no haya estaciones intermedias
      ArrayList trayectoMinimoIntermedio=new ArrayList();  // ArrayList que guarda el trayecto en caso de que sí haya estaciones intermedias
      if (nbEstacionIntermedia1=="" && nbEstacionIntermedia2=="")  // Caso de sólo estación origen y estación destino 
       {
       trayectoMinimo=grafo.trayectoMinimo(nEstacionOrigen,nEstacionDestino);
       Trayectos ventanaTrayectoMinimo=new Trayectos(trayectoMinimo,grafo);
       ventanaTrayectoMinimo.setVisible(true);
       this.dispose();   
       }
      else if (nbEstacionIntermedia1=="")  // Caso de estación origen, destino e intermedia2
       {
       nEstacionIntermedia2=(Integer)grafo.dameThEstaciones().get(nbEstacionIntermedia2);
       ArrayList listaEstacionesIntermedias=new ArrayList();
       listaEstacionesIntermedias.add(nEstacionIntermedia2);
       trayectoMinimoIntermedio=grafo.trayectoMinimoIntermedio(nEstacionOrigen,nEstacionDestino,listaEstacionesIntermedias);
       Trayectos ventanaTrayectoMinimoIntermedio=new Trayectos(trayectoMinimoIntermedio,grafo);
       ventanaTrayectoMinimoIntermedio.setVisible(true);
       this.dispose();
       }
      else if (nbEstacionIntermedia2=="")  // Caso de estación origen, destino e intermedia1
       {
       nEstacionIntermedia1=(Integer)grafo.dameThEstaciones().get(nbEstacionIntermedia1);
       ArrayList listaEstacionesIntermedias=new ArrayList();
       listaEstacionesIntermedias.add(nEstacionIntermedia1);
       trayectoMinimoIntermedio=grafo.trayectoMinimoIntermedio(nEstacionOrigen,nEstacionDestino,listaEstacionesIntermedias);
       Trayectos ventanaTrayectoMinimoIntermedio=new Trayectos(trayectoMinimoIntermedio,grafo);
       ventanaTrayectoMinimoIntermedio.setVisible(true);
       this.dispose();
       }
      else  // Caso de estación origen, destino, intermedia1 e intermedia2
       {
       nEstacionIntermedia1=(Integer)grafo.dameThEstaciones().get(nbEstacionIntermedia1);
       nEstacionIntermedia2=(Integer)grafo.dameThEstaciones().get(nbEstacionIntermedia2);
       ArrayList listaEstacionesIntermedias=new ArrayList();
       listaEstacionesIntermedias.add(nEstacionIntermedia1);
       listaEstacionesIntermedias.add(nEstacionIntermedia2);
       trayectoMinimoIntermedio=grafo.trayectoMinimoIntermedio(nEstacionOrigen,nEstacionDestino,listaEstacionesIntermedias);
       Trayectos ventanaTrayectoMinimoIntermedio=new Trayectos(trayectoMinimoIntermedio,grafo);
       ventanaTrayectoMinimoIntermedio.setVisible(true);
       this.dispose();
       }
      }
    }//GEN-LAST:event_jButtonAceptarMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JComboBox jComboBoxDestino;
    private javax.swing.JComboBox jComboBoxIntermedias1;
    private javax.swing.JComboBox jComboBoxIntermedias2;
    private javax.swing.JComboBox jComboBoxOrigen;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
    
}
