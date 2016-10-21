package Menu;
import java.io.File;
import javax.swing.*;
import Algoritmos.Sudoku;
import Gestion.XML;
import Gestion.BBDD;
import java.util.ArrayList;
public class VentAddSudokuManual extends javax.swing.JPanel
 {
 private VentRaiz vRaiz;
 public VentAddSudokuManual(VentRaiz vRaiz) 
  {
  initComponents();
  this.vRaiz=vRaiz;
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();
        jScrollPaneSudoku = new javax.swing.JScrollPane();
        jTableSudoku = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A\u00f1adir sudoku manualmente");
        jLabel1.setBounds(0, 10, 400, 40);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setText("A\u00f1ade un sudoku");
        jLabelInfo.setBounds(0, 50, 400, 20);
        jDesktopPane1.add(jLabelInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jScrollPaneSudoku.setBounds(130, 80, 140, 150);
        jDesktopPane1.add(jScrollPaneSudoku, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdd.setText("A\u00f1adir");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonAdd.setBounds(100, 250, 90, 30);
        jDesktopPane1.add(jButtonAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonVolver.setBounds(210, 250, 90, 30);
        jDesktopPane1.add(jButtonVolver, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
 //******************************************//
 //*** Métodos auxiliares *******************//
 //******************************************//  
 private void borrarJTableSudoku()
  {
  for (int f=0; f<9; f++) 
   for (int c=0; c<9; c++)
    jTableSudoku.setValueAt("",f,c);
  }
 //******************************************//
 //*** Objetos gráficos *********************//
 //******************************************//    
    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
     VentAddSudokus vAddSudokus=new VentAddSudokus(vRaiz);
     vAddSudokus.setVisible(true);
     vAddSudokus.setSize(2000,2000);
     vRaiz.remove(this);
     vRaiz.add(vAddSudokus);
     vRaiz.pack();
    }//GEN-LAST:event_jButtonVolverActionPerformed
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
     int matrizSudokuAnalizado[][]=new int[9][9];
     boolean malEscrito=false;  // Para indicar si en alguna casilla hemos puesto algo que no sea de 1 a 9
     boolean hayNumeros=false;  // Para indicar que no hemos metido un sudoku vacío
     for (int f=0; f<9; f++)  // Comprobamos que lo introducido por el usuario es un sudoku
      for (int c=0; c<9; c++)
       {
       if ((jTableSudoku.getValueAt(f,c) instanceof Integer))  // Si lo escrito es un entero
        if ((Integer)jTableSudoku.getValueAt(f,c)>0 &&
            (Integer)jTableSudoku.getValueAt(f,c)<10)  // Si el entero está 1 y 9 seguimos añadiendo a la matriz
         {
         matrizSudokuAnalizado[f][c]=(Integer)jTableSudoku.getValueAt(f,c);
         hayNumeros=true;
         }
        else  // Si el entero no está entre 1 y 9
         {
         malEscrito=true;
         }
       else  // Si lo escrito no es un entero (está vacía la casilla) añadimos un 0 en esa posición de la matriz
        {
        matrizSudokuAnalizado[f][c]=0;   
        }
       }
     if (malEscrito || !hayNumeros)  // Si está mal escrito (alguna casilla de la jTableSudoku tiene un número que es 0 o mayor que 9) lo indicamos
      {
      borrarJTableSudoku();
      jLabelInfo.setText("¡Sudoku mal escrito!, introduce otro"); 
      }
     else
      {
      Sudoku sudokuBienEscrito=new Sudoku(matrizSudokuAnalizado);
      if (sudokuBienEscrito.esMatrizIncorrecta())  // Si hemos repetido números en la misma columna, fila o cuadrado lo indicamos
       {
       borrarJTableSudoku();
       jLabelInfo.setText("¡Números repetidos en f/c/q!, introduce otro");
       }
      else if (sudokuBienEscrito.resolverSudoku(0,0))
       {
       jLabelInfo.setText("¡Sudoku introducido correctamente!");
       jButtonAdd.setEnabled(false);
       XML gestionXML=new XML();
       String nombre="nombre";
       String identificador="identificador";
       /* ACTUALIZAR EN BASE DE DATOS Y SACAR NOMBRES A nombre E identificador */
       
      BBDD bd = new BBDD();
      bd.abrirConexion();         
      
      int id = bd.maxSudoku() + 1;
      identificador = String.valueOf(id);      
      nombre = "Sudoku"+identificador;         
      
      bd.insertarTsudokus(id,nombre,0);
      bd.cerrarConexion();        
       
       
       ArrayList infoSudoku=new ArrayList();
       infoSudoku.add(nombre);
       infoSudoku.add(identificador);
       infoSudoku.add(matrizSudokuAnalizado);        
       gestionXML.escribir(infoSudoku,"C:"+File.separator+"Sudokus"+File.separator+nombre+".xml");
       }
      else
       {
       borrarJTableSudoku();
       jLabelInfo.setText("¡Sudoku sin solución!, introduce otro");   
       }
      }
    }//GEN-LAST:event_jButtonAddActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPaneSudoku;
    private javax.swing.JTable jTableSudoku;
    // End of variables declaration//GEN-END:variables
 }
