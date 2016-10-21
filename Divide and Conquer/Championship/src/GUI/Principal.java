package GUI;
import com.sun.org.apache.xerces.internal.util.XML11Char;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
public class Principal extends JFrame  // Hereda del contenedor de alto nivel JFrame 
 {
 private JPanel jPanel;
 private JMenuItem jMenuItem2;
 JMenuItem jMenuItem3=new javax.swing.JMenuItem();
 public Principal() 
  {
  // ---------------------------------------------------------------------------------//
  // CONSTRUCTOR de la ventana principal. Llama al método privado initComponents()    //
  // ---------------------------------------------------------------------------------//
  initComponents();
  }
 private void borraDirectorio(String ruta)
  {
  File directorio=new File(ruta);  // Ruta abstracta del directorio destino
  if (directorio.exists())  // Si el directorio destino existe...
   {
   String[] lista=directorio.list();  // ...sacamos la lista de todos los archivos y directorios que tiene...
   for (int i=0; i<lista.length; i++)  // ...y con un bucle los recorremos
    {
    File dir_o_archivo=new File(ruta+File.separator+lista[i]);
    if (dir_o_archivo.isDirectory())  // Si son directorios volvemos a llamar a borraDirectorio
     {
     borraDirectorio(ruta+File.separator+lista[i]);   
     }
    else if (dir_o_archivo.isFile())  // Pero si es un archivo lo eliminamos directamente
     {
     dir_o_archivo.delete();  
     }
    }
   directorio.delete();  // Después de borrar todo lo del directorio, borramos el propio directorio
   }
  }
 private void initComponents() 
  {
  // Título de la aplicación
  setTitle("Práctica 1: Generador de Competiciones");
  // Menús de la aplicación
  JMenuBar jMenuBar1=new javax.swing.JMenuBar();  // Menú principal
  JMenu jMenu1=new javax.swing.JMenu();  // Submenú 1: Procesamiento Masivo.
  JMenu jMenu2=new javax.swing.JMenu();  // Submenú 2.
  JMenu jMenu3=new javax.swing.JMenu();  // Submenú 3
  JMenuItem jMenuItem1=new javax.swing.JMenuItem();  // Ítem del submenú 1
  jMenuItem2=new javax.swing.JMenuItem();  // Ítem del submenú 2
  JMenuItem jMenuItem3=new javax.swing.JMenuItem();  // Ítem del submenú 3
  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // Se cierra la ventana con X
  // ---- Submenú de Procesamiento Masivo
  jMenu1.setText("Masivo");  // Título del submenú
  jMenuItem1.setText("Ejecutar");  // Título del ítem del submenú
  jMenuItem1.addActionListener(new ActionListener()  // Lo que hace el ítem del submenú 
   {
   public void actionPerformed(ActionEvent evt) 
    {
    jMenuItem1ActionPerformed(evt);
    }
   });
  jMenu1.add(jMenuItem1);  // Añade el ítem al submenú
  // ---- Submenú de Procesamiento Individual
  jMenu2.setText("Individual");  // Título del submenú
  jMenuItem2.setText("Ejecutar");  // Título del ítem del submenú
  jMenuItem2.addActionListener(new ActionListener()  // Lo que hace el ítem del submenú 
   {
   public void actionPerformed(ActionEvent evt) 
    {
    jMenuItem2ActionPerformed(evt);
    }
   });
  jMenu2.add(jMenuItem2);  // Añade el ítem al submenú
  // ---- Submenú de Procesamiento Directo
  jMenu3.setText("Directo");  // Título del submenú
  jMenuItem3.setText("Ejecutar");  // Título del ítem del submenú
  jMenuItem3.addActionListener(new ActionListener()  // Lo que hace el ítem del submenú 
   {
   public void actionPerformed(ActionEvent evt) 
    {
    jMenuItem3ActionPerformed(evt);
    }
   });
  jMenu3.add(jMenuItem3);  // Añade el ítem al submenú
  // Se añaden los menús
  jMenuBar1.add(jMenu1);  // Añade el submenú 1 al menú principal
  jMenuBar1.add(jMenu2);  // Añade el submenú 2 al menú principal
  jMenuBar1.add(jMenu3);  // Añade el submenú 3 al menú principal
  setJMenuBar(jMenuBar1);  // Relaciona el Frame con el menú principal que hemos creado
  // Tamaño del Frame
  setSize(800,600);  
  // Panel con información
  Container contenido=getContentPane();  // Creamos un contenedor
  jPanel=new JPanel();  // Damos vida al panel
  JLabel jlabel=new JLabel("GRUPO 11B: Luis Alfonso González y Alberto López Rubio");  // Creamos una etiqueta con el nombre del grupo
  jPanel.add(jlabel);  // Se la añadimos al panel
  contenido.add(jPanel);  // El container guarda la información del panel
  }
 private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) 
  {
  // PROCESAMIENTO MASIVO
  // -- Preparación de directorios C:/Temporales y C:/Resultados
  File directorioResultados=new File("C:/Resultados");  // Ruta abstracta del directorio Resultados
  File directorioTemporales=new File("C:/Temporales");  // Ruta abstracta del directorio Temporales
  if (directorioResultados.exists())  // Si ya existe...
   {
   borraDirectorio("C:/Resultados");  // ...borramos todo lo que tenga dentro y el propio directorio
   }
  directorioResultados.mkdir();  // Creamos de nuevo el directorio, ya porque lo hayamos eliminado o porque no existiera al principio 
  if (directorioTemporales.exists())  // Si ya existe...
   {
   borraDirectorio("C:/Temporales");  // Borramos el directorio temporal
   }
  directorioTemporales.mkdir();  // Creamos el directorio físico
  // -- Descompresión de archivos zip (extracción de archivos xml) en la carpeta C:/Temporal
  String[] listaZIP;
  IO.Zip gestionZIP=new IO.Zip();  // Objeto Zip para gestionar los zip
  listaZIP=gestionZIP.listaarchivos("C:/Fuentes");  // Lista de todos los archivos zip que hay en el directorio pasado por parámetro
  File directorioFuentes=new File("C:/Fuentes");
  gestionZIP.descomprime(listaZIP,directorioFuentes,"C:/Temporales");  // Descomprime los archivos de la lista y del directorioFuentes en el directorioTemporales
  // -- Procesar archivos xml y tablas de competición
  XML.Utils gestionXML=new XML.Utils();  // Objeto XML para gestionar los xml
  for (int i=0; i<listaZIP.length; i++)  // Recorremos todas las carpetas con el nombre del archivo ZIP
   {                                     // que contienen su correspondiente XML cada una
   ArrayList listaParticipantes;  // ArrayList de participantes
   listaParticipantes=gestionXML.leer("C:/Temporales/"+listaZIP[i].substring(0,listaZIP[i].length()-4)+"/"+listaZIP[i].substring(0,listaZIP[i].length()-4)+".xml");  // Lee .xml (C:/Temporales/ZIP1/ZIP1.xml) y devuelve una lista de participantes
   int competicion[][];  // Matriz de competición
   DYV.Competicion gestionCOMP=new DYV.Competicion(listaParticipantes.size());  // Creamos una competición de 'size' participantes...
   competicion=gestionCOMP.getTabla();  // ...y la guardamos en la matriz competición
   gestionXML.escribir(listaParticipantes,competicion,"C:/Resultados/"+listaZIP[i].substring(0,listaZIP[i].length()-4)+".xml");  // Dejamos el .xml de salida con la competición (C:/Resultados/ZIP1.xml)
   }
  Dialogo dialogo=new Dialogo(this, "Procesamiento terminado");
  dialogo.setVisible(true);
  }
 private void jMenuItem2ActionPerformed(ActionEvent evt) 
  {
  // PROCESAMIENTO INDIVIDUAL
  // -- Preparación de directorio C:/Temporales
  borraDirectorio("C:/Temporales");  // Borramos el directorio temporal
  File directorioTemporales=new File("C:/Temporales");  // Creamos la ruta abstracta
  directorioTemporales.mkdir();  // Creamos el directorio físico
  // -- Navegador de archivos para elegir archivo
  JFileChooser jFileChooser= new JFileChooser();
  Filtro filtro=new Filtro();
  jFileChooser.setFileFilter(filtro);
  jFileChooser.setCurrentDirectory(new File("C:"+File.separator));
  jFileChooser.setMultiSelectionEnabled(false);
  jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
  jFileChooser.showOpenDialog(jMenuItem2);
  String fichero=jFileChooser.getSelectedFile().getPath();
  //  -- Descompresión de archivo zip (extracción de xml) en la carpeta C:/Temporales
  IO.Zip gestionZIP=new IO.Zip();
  gestionZIP.unzip("C:/Temporales",fichero);  // Descomprimimos el fichero en C:/Temporales
  //  -- Procesar archivo xml y tabla de competición
  XML.Utils gestionXML=new XML.Utils();  // Objeto XML
  ArrayList listaParticipantes;
  File ficheroXML=new File(fichero);
  String nombreFicheroXML=ficheroXML.getName();
  listaParticipantes=gestionXML.leer("C:/Temporales/"+nombreFicheroXML.substring(0,nombreFicheroXML.length()-4)+".xml");  // Lee archivo
  int competicion[][];  // Matriz de competición vacía
  DYV.Competicion gestionCOMP=new DYV.Competicion(listaParticipantes.size());  // Procesamiento de la competición  
  competicion=gestionCOMP.getTabla();  // Matriz de competición llena
  jFileChooser.setCurrentDirectory(new File("C:/"));
  jFileChooser.setMultiSelectionEnabled(false);
  jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
  jFileChooser.showSaveDialog(this);
  String directorioDestino=jFileChooser.getSelectedFile().getPath();  
  gestionXML.escribir(listaParticipantes,competicion,directorioDestino);
  Dialogo dialogo=new Dialogo(this, "Procesamiento terminado");
  dialogo.setVisible(true);
  }
 private void jMenuItem3ActionPerformed(ActionEvent evt) 
  {
  // PROCESAMIENTO DIRECTO
  this.jMenuItem3.setEnabled(false);  // Desactivamos ítem desde el que se llamo
  Ventana1 ventanaDatos=new Ventana1(this);  // Creamos la nueva ventana
  ventanaDatos.setVisible(true);  // Y la hacemos visible
  }
 public static void main(String args[]) 
  {
  java.awt.EventQueue.invokeLater(new Runnable() 
   {
   public void run() 
    {
    new Principal().setVisible(true);
    }
   });
  }
 }