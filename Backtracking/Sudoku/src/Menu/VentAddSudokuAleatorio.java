package Menu;
import java.io.File;
import javax.swing.*;
import Algoritmos.Sudoku;
import Gestion.XML;
import Gestion.BBDD;
import java.util.ArrayList;
public class VentAddSudokuAleatorio extends javax.swing.JPanel
 {
 private VentRaiz vRaiz;
 public VentAddSudokuAleatorio(VentRaiz vRaiz) 
  {
  initComponents();
  for (int cont=1; cont<41; cont++)
   {
   jComboBoxElementos.addItem(cont);
   }
  this.vRaiz=vRaiz;
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();
        jComboBoxElementos = new javax.swing.JComboBox();
        jButtonAdd = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A\u00f1adir sudoku aleatoriamente");
        jLabel1.setBounds(0, 70, 400, 40);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel2.setText("N\u00famero de elemntos:");
        jLabel2.setBounds(110, 140, 150, 20);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setBounds(0, 110, 400, 20);
        jDesktopPane1.add(jLabelInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxElementos.setBounds(220, 140, 70, 22);
        jDesktopPane1.add(jComboBoxElementos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdd.setText("A\u00f1adir");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonAdd.setBounds(110, 190, 80, 30);
        jDesktopPane1.add(jButtonAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonVolver.setBounds(210, 190, 80, 30);
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
 
private String creaID(){
      BBDD bd = new BBDD();
      bd.abrirConexion();  
      
      int id = bd.maxSudoku() + 1;
      bd.cerrarConexion();
      return String.valueOf(id);
      //nombre = "Sudoku"+ID;
      
         
}


//******************************************//
 //*** Objetos gráficos *********************//
 //******************************************//   
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
     Sudoku sudokuAleatorio=new Sudoku();
     int[][] matrizSudokuSinResolver=new int[9][9];
     int numCasillas=(Integer)jComboBoxElementos.getSelectedItem();
     jLabelInfo.setText("Generando sudoku...");
     jButtonAdd.setEnabled(false);
     jButtonVolver.setEnabled(false);
     boolean resuelto=sudokuAleatorio.resolverSudokuAleatorio(numCasillas,matrizSudokuSinResolver);
     if (resuelto)
      {
      jLabelInfo.setText("¡Sudoku generado!");
      jButtonVolver.setEnabled(true);
      XML gestionXML=new XML();
      String nombre="nombre";
      String identificador;//="identificador";
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
      infoSudoku.add(matrizSudokuSinResolver);        
      gestionXML.escribir(infoSudoku,"C:"+File.separator+"Sudokus"+File.separator+nombre+".xml");
      }
     else
      {
      jLabelInfo.setText("No se ha podido generar un sudoku. Inténtelo de nuevo");
      jButtonAdd.setEnabled(true);
      jButtonVolver.setEnabled(true);
      }
    }//GEN-LAST:event_jButtonAddActionPerformed
    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
     VentAddSudokus vAddSudokus=new VentAddSudokus(vRaiz);
     vAddSudokus.setVisible(true);
     vAddSudokus.setSize(2000,2000);
     vRaiz.remove(this);
     vRaiz.add(vAddSudokus);
     vRaiz.pack();
    }//GEN-LAST:event_jButtonVolverActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox jComboBoxElementos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelInfo;
    // End of variables declaration//GEN-END:variables
 }
