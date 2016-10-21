package Menu;
import java.util.ArrayList;
import javax.swing.*;
import Algoritmos.Sudoku;
import Gestion.BBDD;
import Gestion.XML;
import java.util.Random;
import java.io.File;
public class VentSudokuEntreno extends javax.swing.JPanel
 {
 private VentRaiz vRaiz;
 private Sudoku sudokuActual;
 private int idsudoku;
 private String nombresudoku;
 private int matrizSudokuSinResolver[][]=new int[9][9];
 private int puntosUsuario=0;
 private int puntosSudoku=0;
 public VentSudokuEntreno(VentRaiz vRaiz) 
  {
  initComponents();
  this.vRaiz=vRaiz;
  /* SACAR PUNTOS DEL USUARIO DE LA BASE DE DATOS A puntos */
  /* IDENTIFICAR UN SUDOKU EN LA BASE DE DATOS DE MÁS PUNTOS QUE LOS QUE TIENE EL USUARIO */
  /* SI NO LO HAY, IDENTIFICAR EL QUE MÁS SE ACERQUE A SUS PUNTOS POR DEBAJO */
  /* SACAR SUDOKU IDENTIFICADO DEL XML A matrizSudokuSinResolver */
  /* SACAR PUNTOS DEL SUDOKU A puntosSudoku */
  
     BBDD bd = new BBDD();
     bd.abrirConexion();
     String puntos = (String)bd.obtenerDatosTusuarios(vRaiz.DNI,"Puntos");
     puntosUsuario = Integer.valueOf(puntos);

     ArrayList sudokus = new ArrayList();
     sudokus = bd.obtenerTsudokusordenados();
     
     if(seleccionaSudoku(sudokus)){     
        abresudoku();

  
      jTextAreaInfo.setEditable(false);  // Ponemos el area de información no editable para el usuario
      sudokuActual=new Sudoku(matrizSudokuSinResolver);  // Creamos un sudoku con los datos sacados del xml
      imprimirSudoku();  // Imprime el sudoku, en esta ocasión aún sin resolver
      jButtonVolver.setEnabled(false);  // Pone el botón volver a false, para que sólo puedas dar a Terminado o a Rendirse
     }
     else{
        jTableSudoku.setEnabled(false);
        jButtonTerminado.setEnabled(false);
        jButtonRendirse.setEnabled(false);
     }
          bd.cerrarConexion();
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPaneSudoku = new javax.swing.JScrollPane();
        jTableSudoku = new javax.swing.JTable();
        jScrollPaneInfo = new javax.swing.JScrollPane();
        jTextAreaInfo = new javax.swing.JTextArea();
        jButtonTerminado = new javax.swing.JButton();
        jButtonRendirse = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sudoku entrenamiento");
        jLabel1.setBounds(0, 10, 400, 40);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTableSudoku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneSudoku.setViewportView(jTableSudoku);

        jScrollPaneSudoku.setBounds(20, 60, 160, 150);
        jDesktopPane1.add(jScrollPaneSudoku, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextAreaInfo.setColumns(20);
        jTextAreaInfo.setFont(new java.awt.Font("Tahoma", 0, 10));
        jTextAreaInfo.setRows(5);
        jTextAreaInfo.setText("\n   - En el caso de que te rindas o re-\n      suelvas el sudoku mal, pasar\u00e1 a\n      valer 100 puntos m\u00e1s\n   - En el caso de que resuelvas el su-\n      doku de manera correcta no ob-\n      tendr\u00e1s ning\u00fan tipo de punto ya\n      que estamos en el modo entrena-\n      miento. Para obtener puntos de-\n      bes acceder al modo contrareloj");
        jScrollPaneInfo.setViewportView(jTextAreaInfo);

        jScrollPaneInfo.setBounds(190, 60, 190, 150);
        jDesktopPane1.add(jScrollPaneInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonTerminado.setText("Terminado");
        jButtonTerminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminadoActionPerformed(evt);
            }
        });

        jButtonTerminado.setBounds(20, 240, 100, 30);
        jDesktopPane1.add(jButtonTerminado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRendirse.setText("Rendirse");
        jButtonRendirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRendirseActionPerformed(evt);
            }
        });

        jButtonRendirse.setBounds(150, 240, 100, 30);
        jDesktopPane1.add(jButtonRendirse, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonVolver.setBounds(280, 240, 100, 30);
        jDesktopPane1.add(jButtonVolver, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
 //******************************************//
 //*** Métodos auxiliares *******************//
 //******************************************// 
    
private boolean seleccionaSudoku(ArrayList sudokus){
    if(sudokus.size()>0){
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i<sudokus.size()){
            ArrayList sudoku = new ArrayList();
            sudoku = (ArrayList)sudokus.get(i);
            String pt = (String)sudoku.get(2);
            puntosSudoku = Integer.valueOf(pt);
            
            if(puntosSudoku >= puntosUsuario){
                encontrado = true;
                String id = (String)sudoku.get(0);
                idsudoku = Integer.valueOf(id);
                
                nombresudoku = (String)sudoku.get(1);
            }
            i++;
        }
        if(!encontrado){
                Random generator=new Random(); 
                int s =generator.nextInt(i);
                ArrayList sudoku = new ArrayList();        
                sudoku = (ArrayList)sudokus.get(s);
                String id = (String)sudoku.get(0);
                idsudoku = Integer.valueOf(id);
                nombresudoku = (String)sudoku.get(1);        
        }
        return true;
    }
    else return false;
}

private void abresudoku(){
    ArrayList sudo = new ArrayList();
    XML archivo = new XML();
    sudo = archivo.leer("C:"+File.separator+"Sudokus"+File.separator+nombresudoku+".xml");
    matrizSudokuSinResolver = (int[][]) sudo.get(2);
}
    
 public void imprimirSudoku()
  {
  //***** imprimirSudoku() ****************************************************//
  //*** Imprime el sudoku actual en la jTable                               ***//
  //***************************************************************************//
  int matrizSudokuActual[][]=new int[9][9];
  matrizSudokuActual=sudokuActual.dameMatrizSudoku();
  for (int f=0; f<9; f++)
   for (int c=0; c<9; c++)
    {
    if (!sudokuActual.esVacia(f,c))  // Si la casilla no está vacía...
     {
     jTableSudoku.setValueAt(matrizSudokuActual[f][c],f,c);  // La pinta en la jTable y la pone no editable
     /* PONER NO EDITABLE LA CELDA */
     }
    }
  }
 //******************************************//
 //*** Objetos gráficos *********************//
 //******************************************// 
    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
     VentMenu vMenu=new VentMenu(vRaiz);
     vMenu.setVisible(true);
     vMenu.setSize(2000,2000);
     vRaiz.remove(this);
     vRaiz.add(vMenu);
     vRaiz.pack();
    }//GEN-LAST:event_jButtonVolverActionPerformed
    private void jButtonRendirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRendirseActionPerformed
     puntosSudoku=puntosSudoku+100;
     sudokuActual.resolverSudoku(0,0);  // Si nos rendimos se resuelve el sudoku
     imprimirSudoku();  // Y se muestra por pantalla
     jTextAreaInfo.setText("\n"+
                           "\n"+
                           "\n"+
                           "   - Sobre ti:\n"+  // Además damos información sobre el usuario y el sudoku
                           "       ¡Te has rendido!\n"+
                           "\n"+
                           "   - Sobre este sudoku:\n"+
                           "       Pasará a valer "+puntosSudoku+" puntos");
     jButtonTerminado.setEnabled(false);  // Ponemos el botón de volver como único utilizable
     jButtonRendirse.setEnabled(false);
     jButtonVolver.setEnabled(true);
     /* ACTUALIZAR LA DIFICULTAD (PUNTOS) DEL SUDOKU NO RESUELTO EN SU XML Y BBDD CORRESPONDIENTE CON puntosSudoku */
     BBDD bd = new BBDD();
     bd.abrirConexion();
     bd.sumadificultadTsudokus(idsudoku,100);
     bd.cerrarConexion();
    }//GEN-LAST:event_jButtonRendirseActionPerformed
    private void jButtonTerminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminadoActionPerformed
     boolean malResuelto=false;  // Variable que será true en el caso de que el usuario haya resuelto mal el sudoku
     sudokuActual.resolverSudoku(0,0);  // Si creemos que hemos resuelto el sudoku, la máquina también lo resuelve para comparar
     int matrizSudokuActual[][]=new int[9][9];
     matrizSudokuActual=sudokuActual.dameMatrizSudoku();  // Sacamos la matriz que representa al sudoku resuelta por la máquina
     for (int f=0; f<9; f++)  // Comprobamos que la solución del usuario sea la misma que la de la máquina
      for (int c=0; c<9; c++)
       if (!(jTableSudoku.getValueAt(f,c) instanceof Integer) ||
           (Integer)jTableSudoku.getValueAt(f,c)!=matrizSudokuActual[f][c])
        malResuelto=true;  // Si la solución es distinta tendremos que decir que está mal resuelto
       if (malResuelto)  // Si está mal resuelto...
        {
        puntosSudoku=puntosSudoku+100;  // Aumentamos los puntos (dificultad) del sudoku
        imprimirSudoku();  // Y mostramos por pantalla el sudoku bien resuelto
        jTextAreaInfo.setText("\n"+
                              "\n"+
                              "\n"+
                              "   - Sobre ti:\n"+  // Además damos información sobre el usuario y el sudoku
                              "       ¡Has resuelto mal el sudoku!\n"+
                              "\n"+
                              "   - Sobre este sudoku:\n"+
                              "       Pasará a valer "+puntosSudoku+" puntos");
        jButtonTerminado.setEnabled(false);  // Ponemos el botón de volver como único utilizable
        jButtonRendirse.setEnabled(false);
        jButtonVolver.setEnabled(true);
     BBDD bd = new BBDD();
     bd.abrirConexion();
     bd.sumadificultadTsudokus(idsudoku,100);
     bd.cerrarConexion();
        } 
       else  // Si está bien resuelto...
        {
        jTextAreaInfo.setText("\n"+
                              "\n"+
                              "\n"+
                              "   - Sobre ti:\n"+  // Además damos información sobre el usuario y el sudoku
                              "       ¡Resuelto! ¡Enhorabuena!\n"+
                              "       No recibes puntos, estás en modo entrenamiento\n"+
                              "\n"+
                              "   - Sobre este sudoku:\n"+
                              "       No varía su puntuación: "+puntosSudoku+" puntos");
        jButtonTerminado.setEnabled(false);  // Ponemos el botón de volver como único utilizable
        jButtonRendirse.setEnabled(false);
        jButtonVolver.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonTerminadoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRendirse;
    private javax.swing.JButton jButtonTerminado;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPaneInfo;
    private javax.swing.JScrollPane jScrollPaneSudoku;
    private javax.swing.JTable jTableSudoku;
    private javax.swing.JTextArea jTextAreaInfo;
    // End of variables declaration//GEN-END:variables
 }
