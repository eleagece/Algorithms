package Menu;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import Algoritmos.Sudoku;
import Gestion.BBDD;
import Gestion.XML;
import java.util.ArrayList;
import java.io.File;
public class VentSudokuComp extends javax.swing.JPanel {
    private VentRaiz vRaiz;
    private int idcompeticion;
    private int idsudoku;
    private String nombresudoku;
    private String numsudoku;
    private Sudoku sudokuActual;
    private int matrizSudokuSinResolver[][]=new int[9][9];
    private int puntosUsuario=0;
    private int puntosSudoku=0;
    private int tiempo=30;
    private int tiempototal=0;
    private Timer reloj;
    private TimerTask tarea;
    public VentSudokuComp(VentRaiz vRaiz,int idcompeticion) {
        initComponents();
        this.vRaiz=vRaiz;
        this.idcompeticion = idcompeticion;
        /* SACAR PUNTOS DEL USUARIO DE LA BASE DE DATOS A puntos */
        /* SACAR TIEMPO QUE LE QUEDA AL USIARIO EN LA COMPETICIÓN A tiempo */
        /* IDENTIFICAR UN SUDOKU DE LOS DE LA COMPETICIÓN DEL USUARIO */
        /* SACAR SUDOKU IDENTIFICADO DEL XML A matrizSudokuSinResolver */
        /* SACAR PUNTOS DEL SUDOKU A puntosSudoku */
        
        BBDD bd = new BBDD();
        bd.abrirConexion();
        String puntos = (String)bd.obtenerDatosTusuarios(vRaiz.DNI,"Puntos");
        puntosUsuario = Integer.valueOf(puntos);
        
        //ArrayList sudokus = new ArrayList();
        //sudokus = bd.obtenerTsudokusordenados();
        
        seleccionaSudoku();
        abresudoku();
        
        
        jTextAreaInfo.setEditable(false);  // Ponemos el area de información no editable para el usuario
        sudokuActual=new Sudoku(matrizSudokuSinResolver);  // Creamos un sudoku con los datos sacados del xml
        imprimirSudoku();  // Imprime el sudoku, en esta ocasión aún sin resolver
        jButtonVolver.setEnabled(false);  // Pone el botón volver a false, para que sólo puedas dar a Terminado o a Rendirse
        
        bd.cerrarConexion();
        
        
        
        jTextFieldTiempo.setText(""+tiempo);
        jTextFieldPuntos.setEditable(false);  // Ponemos el area de puntos no editable para el usuario
        jTextFieldTiempo.setEditable(false);  // Ponemos el area de tiempo no editable para el usuario
        jTextAreaInfo.setEditable(false);  // Ponemos el area de información no editable para el usuario
        jTextFieldPuntos.setText(""+puntosSudoku);  // Mostramos los puntos que ganará el usuario si resuelve el sudoku
        sudokuActual=new Sudoku(matrizSudokuSinResolver);  // Creamos un sudoku con los datos sacados del xml
        imprimirSudoku();  // Imprime el sudoku, en esta ocasión aún sin resolver
        jButtonVolver.setEnabled(false);  // Pone el botón volver a false, para que sólo puedas dar a Terminado o a Rendirse
        reloj=new Timer();
        tarea=new TimerTask() {
            public void run() {
                if (!jButtonVolver.isEnabled())  // Si el botón volver no esta encendido seguimos restando tiempo, ya que o no hemos consumi-
                {                               // do los 30 minutos, o no nos hemos rendido, o no hemos terminado el sudoku
                    tiempo--;  // Reduce los minutos en 1
                    jTextFieldTiempo.setText(""+tiempo);
                    if (tiempo==0)  // Si hemos consumido todo el tiempo actuamos en consecuencia
                    {
                        puntosSudoku=puntosSudoku+100;
                        sudokuActual.resolverSudoku(0,0);  // Si se acaba el tiemo se resuelve el sudoku
                        imprimirSudoku();  // Y se muestra por pantalla
                        jTextAreaInfo.setText("\n"+
                                "   - Sobre ti:\n"+  // Además damos información sobre el usuario y el sudoku
                                "       ¡Has consumido todo el tiempo!\n"+
                                "       Tú puntuación no varía: "+puntosUsuario+" puntos\n"+
                                "\n"+
                                "   - Sobre este sudoku:\n"+
                                "       Pasará a valer "+puntosSudoku+" puntos");
                        jButtonTerminado.setEnabled(false);  // Ponemos el botón de volver como único utilizable
                        jButtonRendirse.setEnabled(false);
                        jButtonVolver.setEnabled(true);
                        /* ACTUALIZAR LA DIFICULTAD (PUNTOS) DEL SUDOKU NO RESUELTO EN SU XML Y BBDD CORRESPONDIENTE CON puntosSudoku */

                        actualizar();
                    }
                }
            }
        };
        reloj.scheduleAtFixedRate(tarea,60000,60000);  // ejecuta 'tarea' a los '60000'ms, y la repite cada '60000'ms
    }
    
    private void actualizar(){
                        BBDD bd = new BBDD();
                        bd.abrirConexion();
                        bd.sumadificultadTsudokus(idsudoku,100);
                        bd.modificarTestadocompeticion(numsudoku,true,idcompeticion,vRaiz.DNI);
                        bd.cerrarConexion();        
    }
    
    private void seleccionaSudoku(){
        BBDD bd = new BBDD();
        bd.abrirConexion();
        
        ArrayList comp = new ArrayList();
        comp = bd.seleccionaCompeticion(idcompeticion);
        
        tiempo = (Integer) comp.get(5);
        tiempototal = tiempo;
        
        int menor = Integer.MAX_VALUE;
        for(int i=1;i<5;i++){
            if (menor > (Integer) comp.get(i)){
                boolean terminado = (Boolean) bd.obtenerDatosTestadocompeticion(idcompeticion,vRaiz.DNI,"Sudoku"+i);
                if(!terminado) {
                    menor = (Integer) comp.get(i);
                    numsudoku = "Sudoku"+i;
                }
            }
            
        }
        idsudoku = menor;
        nombresudoku = (String)bd.obtenerDatosTsudokus(idsudoku,"Nombre");
    }
    
    private void abresudoku(){
        ArrayList sudo = new ArrayList();
        XML archivo = new XML();
        sudo = archivo.leer("C:"+File.separator+"Sudokus"+File.separator+nombresudoku+".xml");
        matrizSudokuSinResolver = (int[][]) sudo.get(2);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPaneSudoku = new javax.swing.JScrollPane();
        jTableSudoku = new javax.swing.JTable();
        jTextFieldTiempo = new javax.swing.JTextField();
        jTextFieldPuntos = new javax.swing.JTextField();
        jScrollPaneInfo = new javax.swing.JScrollPane();
        jTextAreaInfo = new javax.swing.JTextArea();
        jButtonTerminado = new javax.swing.JButton();
        jButtonRendirse = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(212, 208, 200));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel1.setText("Tiempo:");
        jLabel1.setBounds(190, 60, 70, 20);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel2.setText("Puntos:");
        jLabel2.setBounds(270, 60, 80, 20);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sudoku competici\u00f3n");
        jLabel3.setBounds(0, 10, 400, 40);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jTextFieldTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTiempo.setText("30");
        jTextFieldTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTiempoActionPerformed(evt);
            }
        });

        jTextFieldTiempo.setBounds(230, 60, 30, 20);
        jDesktopPane1.add(jTextFieldTiempo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldPuntos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPuntos.setBounds(310, 60, 70, 20);
        jDesktopPane1.add(jTextFieldPuntos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextAreaInfo.setColumns(20);
        jTextAreaInfo.setFont(new java.awt.Font("Tahoma", 0, 10));
        jTextAreaInfo.setRows(5);
        jTextAreaInfo.setText("\n   - Tienes 30 minutos para resolver el\n      sudoku\n   - En el caso de que te rindas o se\n      acabe el tiempo, no sumar\u00e1s pun-\n      tos, pero el sudoku aumentar\u00e1 100\n   - Si crees haberlo resuelto haz click en\n      en 'Terminado'");
        jScrollPaneInfo.setViewportView(jTextAreaInfo);

        jScrollPaneInfo.setBounds(190, 90, 190, 120);
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
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTiempoActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTiempoActionPerformed
    //******************************************//
    //*** Métodos auxiliares *******************//
    //******************************************//
    public void imprimirSudoku() {
        //***** imprimirSudoku() ****************************************************//
        //*** Imprime el sudoku actual en la jTable                               ***//
        //***************************************************************************//
        int matrizSudokuActual[][]=new int[9][9];
        matrizSudokuActual=sudokuActual.dameMatrizSudoku();
        for (int f=0; f<9; f++)
            for (int c=0; c<9; c++) {
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
                    "   - Sobre ti:\n"+  // Además damos información sobre el usuario y el sudoku
                    "       ¡Te has rendido!\n"+
                    "       Tú puntuación no varía: "+puntosUsuario+" puntos\n"+
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
            bd.modificarTestadocompeticion(numsudoku,true,idcompeticion,vRaiz.DNI);
            bd.cerrarConexion();
            
    }//GEN-LAST:event_jButtonRendirseActionPerformed
            private void jButtonTerminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminadoActionPerformed
                boolean malResuelto=false;  // Variable que será true en el caso de que el usuario haya resuelto mal el sudoku
                sudokuActual.resolverSudoku(0,0);  // Si creemos que hemos resuelto el sudoku, la máquina también lo resuelve para comparar
                int matrizSudokuActual[][]=new int[9][9];
                matrizSudokuActual=sudokuActual.dameMatrizSudoku();  // Sacamos la matriz que representa al sudoku resuelta por la máquina
                for (int f=0; f<9; f++)  // Comprobamos que la solución del usuario sea la misma que la de la máquina
                    for (int c=0; c<9; c++)
                        if (!(jTableSudoku.getValueAt(f,c) instanceof Integer) ||  // Para casos en que no hayamos escrito un número y esté vacía
                        (Integer)jTableSudoku.getValueAt(f,c)!=matrizSudokuActual[f][c])
                            malResuelto=true;  // Si la solución es distinta tendremos que decir que está mal resuelto
                if (malResuelto)  // Si está mal resuelto...
                {
                    puntosSudoku=puntosSudoku+100;  // Aumentamos los puntos (dificultad) del sudoku
                    imprimirSudoku();  // Y mostramos por pantalla el sudoku bien resuelto
                    jTextAreaInfo.setText("\n"+
                            "   - Sobre ti:\n"+  // Además damos información sobre el usuario y el sudoku
                            "       ¡Has resuelto mal el sudoku!\n"+
                            "       Tú puntuación no varía: "+puntosUsuario+" puntos\n"+
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
                    bd.modificarTestadocompeticion(numsudoku,true,idcompeticion,vRaiz.DNI);
                    bd.cerrarConexion();
                } else  // Si está bien resuelto...
                {
                    puntosUsuario=puntosUsuario+puntosSudoku;  // Sumamos los puntos que valía el sudoku al usuario
                    jTextAreaInfo.setText("\n"+
                            "   - Sobre ti:\n"+  // Además damos información sobre el usuario y el sudoku
                            "       ¡Resuelto! ¡Enhorabuena!\n"+
                            "       Tú puntuación aumenta: "+puntosUsuario+" puntos\n"+
                            "\n"+
                            "   - Sobre este sudoku:\n"+
                            "       No varía su puntuación: "+puntosSudoku+" puntos");
                    jButtonTerminado.setEnabled(false);  // Ponemos el botón de volver como único utilizable
                    jButtonRendirse.setEnabled(false);
                    jButtonVolver.setEnabled(true);
                    /* ACTUALIZAR LOS PUNTOS DEL USUARIO EN LA BBDD SEGÚN puntosUsuario */
                    BBDD bd = new BBDD();
                    bd.abrirConexion();
                    //bd.sumapuntosTusuarios(vRaiz.DNI,puntosSudoku);
                    bd.sumapuntosTestadocompeticion(idcompeticion,vRaiz.DNI,tiempototal - tiempo);
                    bd.cerrarConexion();
                    
                }
    }//GEN-LAST:event_jButtonTerminadoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRendirse;
    private javax.swing.JButton jButtonTerminado;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPaneInfo;
    private javax.swing.JScrollPane jScrollPaneSudoku;
    private javax.swing.JTable jTableSudoku;
    private javax.swing.JTextArea jTextAreaInfo;
    private javax.swing.JTextField jTextFieldPuntos;
    private javax.swing.JTextField jTextFieldTiempo;
    // End of variables declaration//GEN-END:variables
}
