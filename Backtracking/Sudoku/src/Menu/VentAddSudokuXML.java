package Menu;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import Algoritmos.Sudoku;
import Gestion.XML;
import Gestion.BBDD;
public class VentAddSudokuXML extends javax.swing.JPanel 
 {
 private VentRaiz vRaiz;
 public VentAddSudokuXML(VentRaiz vRaiz) 
  {
  initComponents();
  this.vRaiz=vRaiz;
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A\u00f1adir sudoku desde disco");
        jLabel1.setBounds(0, 100, 400, 40);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setBounds(0, 140, 400, 20);
        jDesktopPane1.add(jLabelInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdd.setText("A\u00f1adir");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonAdd.setBounds(110, 170, 80, 30);
        jDesktopPane1.add(jButtonAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonVolver.setBounds(210, 170, 80, 30);
        jDesktopPane1.add(jButtonVolver, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
     // JFileChooser
     JFileChooser cargarXML=new JFileChooser();
     cargarXML.setCurrentDirectory(new File("C:"+File.separator));
     cargarXML.setMultiSelectionEnabled(false);
     cargarXML.setFileSelectionMode(JFileChooser.FILES_ONLY);
     cargarXML.showOpenDialog(jButtonAdd);
     String rutaFichero=cargarXML.getSelectedFile().getPath();
     // gestiónXML
     XML gestionXML=new XML();
     ArrayList infoSudoku=new ArrayList();
     infoSudoku=gestionXML.leer(rutaFichero);
     int[][] matrizSudokuXML=new int[9][9];
     String nombre=(String)infoSudoku.get(0);  // Nombre del sudoku
     String identificador=(String)infoSudoku.get(1);  // Identificador del sudoku
     matrizSudokuXML=(int[][])infoSudoku.get(2);
     // Tratamiento de la matriz del sudoku
     boolean malEscrito=false;  // Para indicar si en alguna casilla hemos puesto algo que no sea de 1 a 9
     boolean hayNumeros=false;  // Para indicar que no hemos metido un sudoku vacío
     for (int f=0; f<9; f++)  // Comprobamos que lo introducido por el usuario es un sudoku
      for (int c=0; c<9; c++)
       {
       if (matrizSudokuXML[f][c]>0 &&
           matrizSudokuXML[f][c]<10)  // Si el entero está 1 y 9 indicamos que hay numeros
        {
        hayNumeros=true;
        }
       else if (matrizSudokuXML[f][c]!=0)  // Si el entero no está entre 0 y 9 decimos que está mal escrito
        {
        malEscrito=true;
        }
       }
     if (malEscrito || !hayNumeros)  // Si está mal escrito (algún número mayor que 0 o menor que 10) o no hay numeros (son todo ceros)
      {
      jLabelInfo.setText("¡Sudoku mal escrito!, introduce otro");    
      }
     else 
      {
      Sudoku sudokuXML=new Sudoku(matrizSudokuXML);    
      if (sudokuXML.esMatrizIncorrecta())  // Si hemos repetido números en la misma columna, fila o cuadrado lo indicamos
       {
       jLabelInfo.setText("¡Números repetidos en f/c/q!, introduce otro");
       }
      else if (sudokuXML.resolverSudoku(0,0))
       {
       jLabelInfo.setText("¡Sudoku introducido correctamente!");
       jButtonAdd.setEnabled(false);
       
       
      BBDD bd = new BBDD();
      bd.abrirConexion();         
      
      int id = bd.maxSudoku() + 1;
      identificador = String.valueOf(id);      
      nombre = "Sudoku"+identificador;      

      bd.insertarTsudokus(id,nombre,0);
      bd.cerrarConexion();        
       
       
       
       ArrayList infoSudoku2=new ArrayList();
       infoSudoku2.add(nombre);
       infoSudoku2.add(identificador);
       infoSudoku2.add(matrizSudokuXML);        
       gestionXML.escribir(infoSudoku2,"C:"+File.separator+"Sudokus"+File.separator+nombre+".xml");
       }
      else
       {
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
    // End of variables declaration//GEN-END:variables
 }
