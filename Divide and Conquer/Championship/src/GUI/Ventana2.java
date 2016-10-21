package GUI;
import com.sun.org.apache.xerces.internal.util.XML11Char;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
public class Ventana2 extends javax.swing.JFrame 
 {
 private JButton jButton1;
 private JButton jButton2;
 private JButton jButton3;
 private ArrayList listaParticipantesLocal=null;
 private JTextField tablaParticipantesLocal[][];
 private Principal referencia=null;
 public Ventana2(ArrayList listaParticipantes, Principal aux) 
  {
  listaParticipantesLocal=listaParticipantes;
  initComponents2(listaParticipantesLocal);
  referencia=aux;
  }
 private void initComponents2(ArrayList listaParticipantes) 
  {
  // Inicialización de la tabla
  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  this.setSize(400,400);
  setLayout(new GridLayout(2+(listaParticipantes.size()/4),4)); // (filas,columnas)
  JLabel arrayEtiquetas[]=new JLabel[4];  // Array de 4 etiquetas
  arrayEtiquetas[0]=new JLabel("Nombre");
  add(arrayEtiquetas[0]);
  arrayEtiquetas[1]=new JLabel("Apellido1");
  add(arrayEtiquetas[1]);
  arrayEtiquetas[2]=new JLabel("Apellido2");
  add(arrayEtiquetas[2]);
  arrayEtiquetas[3]=new JLabel("DNI");
  add(arrayEtiquetas[3]);
  JTextField tablaParticipantes[][]=new JTextField[listaParticipantes.size()/4][4];
  for (int j=0;j<listaParticipantes.size()/4;j++)  // Recorre todos los participantes
   {
   for (int i=0;i<4;i++)  // Por cada participante rellena su Nombre, Apellido 1, Apellido 2 y DNI
    {
    String dato=(String)listaParticipantes.get(i+(4*j));
    tablaParticipantes[j][i]=new JTextField(dato);
    add(tablaParticipantes[j][i]);
    }
   }
  tablaParticipantesLocal=tablaParticipantes;
  JButton arrayBotones[]=new JButton[4];
  arrayBotones[0]=new JButton("Aceptar");
  add(arrayBotones[0]);
  arrayBotones[1]=new JButton("Añadir");
  add(arrayBotones[1]);
  arrayBotones[2]=new JButton("Modificar");
  add(arrayBotones[2]);
  pack();
  jButton1=arrayBotones[0];
  jButton2=arrayBotones[1];
  jButton3=arrayBotones[2];
  jButton1.addMouseListener(new java.awt.event.MouseAdapter() 
   {
   public void mouseClicked(java.awt.event.MouseEvent evt)
    {
    jButton1MouseClicked(evt);
    }
   });
  jButton2.addMouseListener(new java.awt.event.MouseAdapter() 
   {
   public void mouseClicked(java.awt.event.MouseEvent evt)
    {
    jButton2MouseClicked(evt);
    }
   });
  jButton3.addMouseListener(new java.awt.event.MouseAdapter() 
   {
   public void mouseClicked(java.awt.event.MouseEvent evt)
    {
    jButton3MouseClicked(evt);
    }
   });
  } 
 private void jButton1MouseClicked(java.awt.event.MouseEvent evt) 
  {
  // -- BOTÓN ACEPTAR
  // -- Conversion de listaParticipantesLocal a listaParticipantesXML
  ArrayList listaParticipantesXML=new ArrayList();  // Lista que se sacaraía del XML de origen
  for (int j=0; j<listaParticipantesLocal.size()/4; j++)  // Recorre todos los participantes
   {
   String participanteXML[];
   participanteXML=new String[4];  // Cada participante tiene 4 Strings para nombre, ap1, ap2 y dni
   for (int i=0; i<4; i++)  // Por cada participante guarda su nombre, apellidos y dni en el ArrayList de strings
    {
    participanteXML[i]=(String)listaParticipantesLocal.get(i+(4*j));
    }
   listaParticipantesXML.add(participanteXML);
   }
  // -- Gestión del archivo xml generado
  XML.Utils gestionXML=new XML.Utils();  // Objeto XML
  int competicion[][];  // Matriz de competición vacía
  DYV.Competicion gestionCOMP=new DYV.Competicion(listaParticipantesXML.size());  // Procesamiento de la competición  
  competicion=gestionCOMP.getTabla();  // Matriz de competición llena
  // -- Gestión del guardado en disco
  JFileChooser jFileChooser= new JFileChooser();
  jFileChooser.setCurrentDirectory(new File("C:/"));
  jFileChooser.setMultiSelectionEnabled(false);
  jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
  jFileChooser.showSaveDialog(this);
  String directorioDestino=jFileChooser.getSelectedFile().getPath();  
  gestionXML.escribir(listaParticipantesXML,competicion,directorioDestino);
  this.dispose();
  }
 private void jButton2MouseClicked(java.awt.event.MouseEvent evt) 
  {
  // -- BOTÓN AÑADIR
  Ventana1 ventanaAnadir=new Ventana1(listaParticipantesLocal, referencia);  // Creamos una nueva ventana con el constructor nuevo
  ventanaAnadir.setVisible(true);  // Hacemos visible la nueva ventana
  this.dispose();  // Y eliminamos la actual
  }
 private void jButton3MouseClicked(java.awt.event.MouseEvent evt) 
  {
  // -- BOTÓN MODIFICAR
  for (int j=0; j<listaParticipantesLocal.size()/4; j++)  // La j recorre todos los participantes
   {
   for (int i=0; i<4; i++)  // La i por cada participante pasa por su Nombre, Apellido 1, Apellido 2 y DNI
    {
    String dato=tablaParticipantesLocal[j][i].getText();  // Sacamos el String de la tabla de JTextField...
    listaParticipantesLocal.set(i+(4*j),dato);  // ...y lo ponemos en su corresondiente de la tablaParticipantesLocal
    }
   }
  }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
 }
